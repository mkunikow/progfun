//package week1

object Newton {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)           //> sqrtIter: (guess: Double, x: Double)Double
  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < (0.01 * x)           //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def abs(x: Double) =
    if (x > 0) x else -x                          //> abs: (x: Double)Double

  def sqrt(x: Double) =
    sqrtIter(1.0, x)                              //> sqrt: (x: Double)Double

  def sqrt2(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < (0.01 * x)
    def improve(guess: Double) =
      (guess + x / guess) / 2

    def abs(x: Double) =
      if (x > 0) x else -x

    sqrtIter(1.0)
  }                                               //> sqrt2: (x: Double)Double

  val x = 1e60                                    //> x  : Double = 1.0E60
  val res0 = sqrt2(x)                             //> res0  : Double = 1.0000788456669446E30
  val res1 = math.sqrt(x)                         //> res1  : Double = 1.0E30
//  abs(res0 - res1) / 2                            //> res0: Double = 3.942283347226778E25
}