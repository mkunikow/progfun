package week7

object Glass {
  class Pouring(capacity: Vector[Int]) {

    type State = Vector[Int]

    val initialState = capacity map (_ => 0)

    trait Move {
      def change(state: State): State
    }
    case class Empty(glass: Int) extends Move {
      def change(state: State) = state updated (glass, 0)
    }
    case class Fill(glass: Int) extends Move {
      def change(state: State) = state updated (glass, capacity(glass))
    }
    case class Pour(from: Int, to: Int) extends Move {
      def change(state: State) = {
        val amount = state(from) min (capacity(to) - state(to))
        state updated (from, state(from) - amount) updated (to, state(to) + amount)
      }
    }

    val glasses = 0 until capacity.length

    val moves =
      (for (g <- glasses) yield Empty(g)) ++
        (for (g <- glasses) yield Fill(g)) ++
        (for (from <- glasses; to <- glasses; if from != to) yield Pour(from, to))

    /*
    class Path(history: List[Move]) {
      
      
      def endState: State = (history foldRight initialState)(_ change _)

      /* Primera solucion recursiva, mas costosa pero por ahi mas clara}
      def endState: State = trackState(history)

      def trackState(xs: List[Move]): State = xs match {
        case Nil => initialState
        case move :: xs1 => move change trackState(xs1)
      }
      */

      def extend(move: Move) = new Path(move :: history)

      override def toString = (history.reverse mkString " ") + "--> " + endState

    }
    */
    //Esta es la segunda PAth, cacheando endState en cambio de estar recalculandolo todo el tiempo

    class Path(history: List[Move], val endState: State) {

      def extend(move: Move) = new Path(move :: history, move change endState)

      override def toString = (history.reverse mkString " ") + "--> " + endState

    }

    val initialPath = new Path(Nil, initialState)

    def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] =
      if (paths.isEmpty) Stream.empty
      else {
        val more = for {
          path <- paths
          next <- moves map path.extend
          //Con esto filtro los estados por los que pase, de forma de evitar recursividad sin sentido
          if !(explored contains next.endState)
        } yield next
        paths #:: from(more, explored ++ (more map (_.endState)))
      }

    val pathSets = from(Set(initialPath), Set(initialState))

    def solution(target: Int): Stream[Path] = {
      for {
        pathSet <- pathSets
        path <- pathSet
        if path.endState contains target
      } yield path
    }

  }

  val problem = new Pouring(Vector(4, 9))         //> problem  : week7.Glass.Pouring = week7.Glass$Pouring@5ff3cd32

  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with 
                                                  //| week7.Glass.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Po
                                                  //| ur(0,1), Pour(1,0))
  problem.pathSets.take(3).toList                 //> res1: List[Set[week7.Glass.problem.Path]] = List(Set(--> Vector(0, 0)), Set
                                                  //| (Fill(0)--> Vector(4, 0), Fill(1)--> Vector(0, 9)), Set(Fill(0) Fill(1)--> 
                                                  //| Vector(4, 9), Fill(0) Pour(0,1)--> Vector(0, 4), Fill(1) Fill(0)--> Vector(
                                                  //| 4, 9), Fill(1) Pour(1,0)--> Vector(4, 5)))
  problem.solution(6)                             //> res2: Stream[week7.Glass.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(0) 
                                                  //| Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), ?)
}