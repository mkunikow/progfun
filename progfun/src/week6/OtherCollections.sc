//package week6

object OtherCollections {

  val xs = Array(1, 2, 3, 44)
  xs map (_ * 2)
  val s = "Hello World"
  s filter (_.isUpper)
  s exists(_.isUpper)
  s forall (_.isUpper)
  val pairs = List(1,2,3) zip s
  pairs.unzip
  s.flatMap(List('.', _))
  xs.sum
  xs.max
  val M = 10
  val N = 11
  (1 to M) flatMap(x => (1 to N) map (y => (x,y)))
  def scalaProducts(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  def scalaProducts2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{case (x, y) => x * y}.sum
  scalaProducts(Vector(1,2), Vector(3,4))
  scalaProducts2(Vector(1,2), Vector(3,4))

  def isPrime(n: Int): Boolean =
    (2 until n) forall (x => n % x != 0)      //> isPrime: (n: Int)Boolean

  isPrime(2)                                //> res0: Boolean = true

}