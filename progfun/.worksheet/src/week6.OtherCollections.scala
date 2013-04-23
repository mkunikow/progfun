package week6

object OtherCollections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  def isPrime(n: Int): Boolean =
  	(2 until n) forall (x => n % x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(18); val res$0 = 
  	
  	isPrime(2);System.out.println("""res0: Boolean = """ + $show(res$0))}
}