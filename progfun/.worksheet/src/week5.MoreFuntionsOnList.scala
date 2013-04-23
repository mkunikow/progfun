package week5

object MoreFuntionsOnList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(214); 
  def init(xs: List[Int]): List[Int] = xs match {
    case List() => throw new Error("init on empty list")
    case List(y) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: (xs: List[Int])List[Int]""");$skip(29); val res$0 = 

  init(List(1, 2, 3, 4, 5));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  init(List(1));System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(151); 
  //init(List())

  def concat(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  };System.out.println("""concat: (xs: List[Int], ys: List[Int])List[Int]""");$skip(31); val res$2 = 


	concat(List(1,2),List(3,4));System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(127); 

  def reverse(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  };System.out.println("""reverse: (xs: List[Int])List[Int]""");$skip(28); val res$3 = 
  
  reverse(List(1,2,3,4));System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(158); 

  def removeAt(n: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
  };System.out.println("""removeAt: (n: Int, xs: List[Int])List[Int]""");$skip(114); 

	//Asi lo implemento Odersky
  def removeAt2(n: Int, xs: List[Int]): List[Int] = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt2: (n: Int, xs: List[Int])List[Int]""");$skip(31); val res$4 = 

  removeAt2(1, List(1, 2, 3));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(30); val res$5 = 
  removeAt2(4, List(1, 2, 3));System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(30); val res$6 = 
  removeAt2(0, List(1, 2, 3));System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(23); val res$7 = 
  removeAt2(0, List());System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(228); 

  //Primera implementacion
  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case y :: ys => (y match {
      case z: List[Any] => flatten(z)
      case _ => List(y)
    }) ::: flatten(ys)

  };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(59); val res$8 = 

  flatten(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))));System.out.println("""res8: List[Any] = """ + $show(res$8));$skip(209); 

  //Segunda implementacion
  def flatten2(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (y: List[Any]) :: ys => flatten(y) ::: flatten(ys)
    case y :: ys => y :: flatten(ys)
  };System.out.println("""flatten2: (xs: List[Any])List[Any]""");$skip(60); val res$9 = 

  flatten2(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))));System.out.println("""res9: List[Any] = """ + $show(res$9));$skip(259); 

  //Esta respuesta la encontre en el foro, es mucho mas elegante a mi gusto
  def flatten3(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
    case y :: ys => y :: flatten(ys)
  };System.out.println("""flatten3: (xs: List[Any])List[Any]""");$skip(60); val res$10 = 

  flatten3(List(List(1, 1), 2, 3, 4, List(List(5, 6, 7))));System.out.println("""res10: List[Any] = """ + $show(res$10))}

}