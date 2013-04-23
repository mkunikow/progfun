package week2

import scala.annotation.tailrec

object FactorialNonTailRecursive {

  def factorialNonTailRecursive(n: Int): Int =
    if (n == 0) 1 else n * factorialNonTailRecursive(n - 1)
                                                  //> factorialNonTailRecursive: (n: Int)Int

  factorialNonTailRecursive(4)                    //> res0: Int = 24

  def factorialTailRecursive(n: Int): Int = {
		@tailrec
    def factorialTailRecursive(acumulator: Int, n: Int): Int =
      if (n == 0) acumulator else factorialTailRecursive(acumulator * n, n - 1)

    factorialTailRecursive(n, n - 1)
  }                                               //> factorialTailRecursive: (n: Int)Int

  factorialTailRecursive(4)                       //> res1: Int = 24

}