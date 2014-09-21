//package week6

object pairs {
  //Sacado de OtherColections
  def isPrime(n: Int): Boolean =
    (2 until n) forall (x => n % x != 0)          //> isPrime: (n: Int)Boolean

  def combine(n: Int): IndexedSeq[(Int, Int)] = {
    val xss = (1 until n) map (i => (1 until i) map (j => (i, j)))
    //xss.foldRight(IndexedSeq[(Int, Int)]())(_ ++ _)
    //Es lo mismo!!
    xss.flatten
  }

                                                 //> combine: (n: Int)IndexedSeq[(Int, Int)]
//law
// xs flatMap f = (xs map f).flatten

  def combine2(n: Int): IndexedSeq[(Int, Int)] = {
    (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
  }                                               //> combine2: (n: Int)IndexedSeq[(Int, Int)]

  def combinePrimes(n: Int): IndexedSeq[(Int, Int)] = {
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
  }                                               //> combinePrimes: (n: Int)IndexedSeq[(Int, Int)]

  combine(10) filter (x => isPrime(x._1 + x._2))  //> res0: IndexedSeq[(Int, Int)] = Vector((2,1), (3,2), (4,1), (4,3), (5,2), (6,
                                                  //| 1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (9,4), (9,8))

  combinePrimes(10)                               //> res1: IndexedSeq[(Int, Int)] = Vector((2,1), (3,2), (4,1), (4,3), (5,2), (6,
                                                  //| 1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (9,4), (9,8))

  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for ((x, y) <- xs zip ys) yield (x * y)).sum //> scalarProduct: (xs: List[Double], ys: List[Double])Double
 
  scalarProduct(List(1, 2, 3), List(4, 5, 6))     //> res2: Double = 32.0

}