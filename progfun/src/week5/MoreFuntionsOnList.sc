//package week5

object MoreFuntionsOnList {
  def init(xs: List[Int]): List[Int] = xs match {
    case List() => throw new Error("init on empty list")
    case List(y) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: (xs: List[Int])List[Int]

  init(List(1, 2, 3, 4, 5))                       //> res0: List[Int] = List(1, 2, 3, 4)
  init(List(1))                                   //> res1: List[Int] = List()
  //init(List())

  def concat(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: (xs: List[Int], ys: List[Int])List[Int]


	concat(List(1,2),List(3,4))               //> res2: List[Int] = List(1, 2, 3, 4)

  def reverse(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: (xs: List[Int])List[Int]
  
  reverse(List(1,2,3,4))                          //> res3: List[Int] = List(4, 3, 2, 1)

  def removeAt(n: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
  }                                               //> removeAt: (n: Int, xs: List[Int])List[Int]

	//Asi lo implemento Odersky
  def removeAt2(n: Int, xs: List[Int]): List[Int] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt2: (n: Int, xs: List[Int])List[Int]

  removeAt2(1, List(1, 2, 3))                     //> res4: List[Int] = List(1, 3)
  removeAt2(4, List(1, 2, 3))                     //> res5: List[Int] = List(1, 2, 3)
  removeAt2(0, List(1, 2, 3))                     //> res6: List[Int] = List(2, 3)
  removeAt2(0, List())                            //> res7: List[Int] = List()

  //Primera implementacion
  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case y :: ys => (y match {
      case z: List[Any] => flatten(z)
      case _ => List(y)
    }) ::: flatten(ys)

  }                                               //> flatten: (xs: List[Any])List[Any]

  flatten(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))))
                                                  //> res8: List[Any] = List(1, 1, 2, 3, 4, 5, 6, 7)

  //Segunda implementacion
  def flatten2(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (y: List[Any]) :: ys => flatten(y) ::: flatten(ys)
    case y :: ys => y :: flatten(ys)
  }                                               //> flatten2: (xs: List[Any])List[Any]

  flatten2(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))))
                                                  //> res9: List[Any] = List(1, 1, 2, 3, 4, 5, 6, 7)

  //Esta respuesta la encontre en el foro, es mucho mas elegante a mi gusto
  def flatten3(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
    case y :: ys => y :: flatten(ys)
  }                                               //> flatten3: (xs: List[Any])List[Any]

  flatten3(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))))
                                                  //> res10: List[Any] = List(1, 1, 2, 3, 4, 5, 6, 7)

}