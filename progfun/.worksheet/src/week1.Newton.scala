package week1

object Newton {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(160); 

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(88); 

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < (0.01 * x);System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(71); 

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(49); 

  def abs(x: Double) =
    if (x > 0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(46); 

  def sqrt(x: Double) =
    sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(364); 

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
  };System.out.println("""sqrt2: (x: Double)Double""");$skip(16); 

  val x = 1e60;System.out.println("""x  : Double = """ + $show(x ));$skip(22); 
  val res0 = sqrt2(x);System.out.println("""res0  : Double = """ + $show(res0 ));$skip(26); 
  val res1 = math.sqrt(x);System.out.println("""res1  : Double = """ + $show(res1 ));$skip(23); val res$0 = 
  abs(res0 - res1) / 2;System.out.println("""res0: Double = """ + $show(res$0))}
}
