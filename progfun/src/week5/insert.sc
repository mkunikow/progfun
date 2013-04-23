package week5

object insert {

	def isort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case y :: ys => insert(y, isort(ys))
	
	}                                         //> isort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil
    case y :: ys =>
      if (x > y) y :: insert(x, ys) else x :: xs
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  insert(5, List(1, 2, 3, 4, 6, 7, 8, 9))         //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  insert(0, List(1, 2, 3, 4, 6, 7, 8, 9))         //> res1: List[Int] = List(0, 1, 2, 3, 4, 6, 7, 8, 9)
  insert(10, List(1, 2, 3, 4, 6, 7, 8, 9))        //> res2: List[Int] = List(1, 2, 3, 4, 6, 7, 8, 9, 10)
  insert(2, List())                               //> res3: List[Int] = List(2)
}