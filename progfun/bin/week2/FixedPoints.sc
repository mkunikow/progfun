package week2

object FixedPoints {
  val tolerance = 0.00001                         //> tolerance  : Double = 1.0E-5

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) < tolerance                  //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(seed: Double) = {
    def iterate(guess: Double): Double = {

      val next = f(guess)

      if (isCloseEnough(guess, next)) next
      else
        iterate(next)
    }

    iterate(seed)
  }                                               //> fixedPoint: (f: Double => Double)(seed: Double)Double
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
                                                  
	def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y)) (1.0)
                                                  //> sqrt: (x: Double)Double

  
  fixedPoint ( x => 1 + x/2) (1)                  //> res0: Double = 1.9999847412109375
  
  sqrt(2)                                         //> res1: Double = 1.4142135623746899

  
  
}