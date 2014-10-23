//package week2

object HigerOrderFunctions {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a)+acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x)(1, 3)                               //> res0: Int = 6

  def id (x: Int) :Int = x
  def cube (x: Int) : Int = x * x * x
  def fact (x :Int) : Int = if (x == 0) 1 else fact(x - 1)
  fact(4)

  def sumInts(a: Int, b: Int): Int = sum(id)(a, b)
  def sumCubes(a: Int, b:Int): Int = sum(cube)(a, b)
  def sumFactorials(a: Int, b:Int): Int = sum(fact)(a, b)

  def sumInts2(a: Int, b: Int): Int = sum((x: Int) => x)(a, b)
  def sumInts4(a: Int, b: Int): Int = sum(x => x)(a, b)
  def sumInts3(a: Int, b: Int): Int = sum(identity)(a, b)
}