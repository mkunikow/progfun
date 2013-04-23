package week5

object insert {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(149); 

	def isort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case y :: ys => insert(y, isort(ys))
	
	};System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(162); 

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil
    case y :: ys =>
      if (x > y) y :: insert(x, ys) else x :: xs
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(43); val res$0 = 

  insert(5, List(1, 2, 3, 4, 6, 7, 8, 9));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(42); val res$1 = 
  insert(0, List(1, 2, 3, 4, 6, 7, 8, 9));System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(43); val res$2 = 
  insert(10, List(1, 2, 3, 4, 6, 7, 8, 9));System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(20); val res$3 = 
  insert(2, List());System.out.println("""res3: List[Int] = """ + $show(res$3))}
}