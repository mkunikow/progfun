package week2

import scala.annotation.tailrec

object FactorialNonTailRecursive {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(190); 

  def factorialNonTailRecursive(n: Int): Int =
    if (n == 0) 1 else n * factorialNonTailRecursive(n - 1);System.out.println("""factorialNonTailRecursive: (n: Int)Int""");$skip(32); val res$0 = 

  factorialNonTailRecursive(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(243); 

  def factorialTailRecursive(n: Int): Int = {
		@tailrec
    def factorialTailRecursive(acumulator: Int, n: Int): Int =
      if (n == 0) acumulator else factorialTailRecursive(acumulator * n, n - 1)

    factorialTailRecursive(n, n - 1)
  };System.out.println("""factorialTailRecursive: (n: Int)Int""");$skip(29); val res$1 = 

  factorialTailRecursive(4);System.out.println("""res1: Int = """ + $show(res$1))}

}
