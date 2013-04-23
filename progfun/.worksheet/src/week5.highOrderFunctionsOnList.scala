package week5

object highOrderFunctionsOnList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(172); 
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case x :: xs => x * x :: squareList(xs)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(77); 

  def squareListWithMap(xs: List[Int]): List[Int] =
    xs map (x => x * x);System.out.println("""squareListWithMap: (xs: List[Int])List[Int]""");$skip(35); val res$0 = 

  squareList(List(1, 2, 3, 4, 5));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(41); val res$1 = 
  squareListWithMap(List(1, 2, 3, 4, 5));System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(34); 

  val nums = List(1, 2, 3, 5, 6);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(28); val res$2 = 

  nums filter (x => x > 3);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(30); val res$3 = 
  nums filterNot (x => x > 3);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  nums partition (x => x > 3);System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(31); val res$5 = 

  nums takeWhile (x => x < 3);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(30); val res$6 = 
  nums dropWhile (x => x < 3);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(25); val res$7 = 
  nums span (x => x < 3);System.out.println("""res7: (List[Int], List[Int]) = """ + $show(res$7));$skip(173); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, snd) = xs span (y => y == x)
      first :: pack(snd)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(49); val res$8 = 

  pack(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res8: List[List[java.lang.String]] = """ + $show(res$8));$skip(91); 

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (x => (x.head, x.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(51); val res$9 = 

  encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res9: List[(java.lang.String, Int)] = """ + $show(res$9))}
}