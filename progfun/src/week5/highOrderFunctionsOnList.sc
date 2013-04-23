package week5

object highOrderFunctionsOnList {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case x :: xs => x * x :: squareList(xs)
  }                                               //> squareList: (xs: List[Int])List[Int]

  def squareListWithMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListWithMap: (xs: List[Int])List[Int]

  squareList(List(1, 2, 3, 4, 5))                 //> res0: List[Int] = List(1, 4, 9, 16, 25)
  squareListWithMap(List(1, 2, 3, 4, 5))          //> res1: List[Int] = List(1, 4, 9, 16, 25)

  val nums = List(1, 2, 3, 5, 6)                  //> nums  : List[Int] = List(1, 2, 3, 5, 6)

  nums filter (x => x > 3)                        //> res2: List[Int] = List(5, 6)
  nums filterNot (x => x > 3)                     //> res3: List[Int] = List(1, 2, 3)
  nums partition (x => x > 3)                     //> res4: (List[Int], List[Int]) = (List(5, 6),List(1, 2, 3))

  nums takeWhile (x => x < 3)                     //> res5: List[Int] = List(1, 2)
  nums dropWhile (x => x < 3)                     //> res6: List[Int] = List(3, 5, 6)
  nums span (x => x < 3)                          //> res7: (List[Int], List[Int]) = (List(1, 2),List(3, 5, 6))

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, snd) = xs span (y => y == x)
      first :: pack(snd)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(List("a", "a", "a", "b", "c", "c", "a"))   //> res8: List[List[java.lang.String]] = List(List(a, a, a), List(b), List(c, c)
                                                  //| , List(a))

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (x => (x.head, x.length))        //> encode: [T](xs: List[T])List[(T, Int)]

  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res9: List[(java.lang.String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}