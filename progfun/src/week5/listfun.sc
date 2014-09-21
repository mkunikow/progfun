
object listfun {
  val nums = List(2, -4, 5, 7, 1)
  val friuts = List("apple", "pinapple",  "orange", "bannana")

  nums filter (_ > 0)
  nums filterNot (_ > 0)
  nums partition  (_ > 0)
  nums takeWhile (_ > 0)
  nums dropWhile (_ > 0)
  nums span (_ > 0)
}