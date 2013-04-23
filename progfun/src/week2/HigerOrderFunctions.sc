package week2

object HigerOrderFunctions {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a)+acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x)(1, 3)                               //> res0: Int = 6
}