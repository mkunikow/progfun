package week4

object Lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 

  def singleton[T](cons: T) = new Cons[T](cons, new Nil[T]);System.out.println("""singleton: [T](cons: T)week4.Cons[T]""");$skip(195); 
  
  def nth[T](position: Int, list: List[T]) : T =
		if(position < 0 || list.isEmpty) throw new IndexOutOfBoundsException;
		else if(position == 0) list.head
		else nth(position - 1, list.tail);System.out.println("""nth: [T](position: Int, list: week4.List[T])T""");$skip(43); val res$0 = 
  
	nth(1,new Cons(5,new Cons(6,new Nil)));System.out.println("""res0: Int = """ + $show(res$0));$skip(32); val res$1 = 
	
	  
  
  
  singleton[Int](1);System.out.println("""res1: week4.Cons[Int] = """ + $show(res$1));$skip(44); 
  println("Welcome to the Scala worksheet");$skip(13); val res$2 = 
  
  List(1);System.out.println("""res2: week4.List[Int] = """ + $show(res$2));$skip(15); val res$3 = 
  
  List(1,2);System.out.println("""res3: week4.List[Int] = """ + $show(res$3))}
}