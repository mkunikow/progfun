package week2

object Currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(134); 
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(55); 
    
  def factorial(n: Int) =  	product(x => x) (1,n);System.out.println("""factorial: (n: Int)Int""");$skip(170); 
	
	def mapReduce (unit: Int, combine: (Int, Int) => Int) (f: Int => Int) (a: Int, b: Int): Int =
		if (a > b) unit else combine(f(a), mapReduce(unit, combine)(f)(a+1,b));System.out.println("""mapReduce: (unit: Int, combine: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$0 = 
  
  product(x => x)(1, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(97); 
  
  def product2 (f: Int => Int)(a: Int, b: Int): Int = mapReduce(1, (x, y) => x * y) (f) (a,b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$2 = 
  
  
  product2(x => x)(1, 5);System.out.println("""res2: Int = """ + $show(res$2))}
  
  
  
}