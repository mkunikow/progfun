package week2

object Rational {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(30); 

  val x = new Rational(1, 2);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(9); val res$0 = 

  x - x;System.out.println("""res0: week2.Rational = """ + $show(res$0));$skip(64); val res$1 = 

  new Rational(1, 3) - new Rational(5, 7) - new Rational(3, 2);System.out.println("""res1: week2.Rational = """ + $show(res$1));$skip(22); val res$2 = 

  new Rational(1, 1);System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(19); val res$3 = 

  new Rational(1);System.out.println("""res3: week2.Rational = """ + $show(res$3))}

}

class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  require(y != 0, "the denominator must not be 0")

  def this(x: Int) = this(x, 1)

  val numer = x
  val denom = y

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- = new Rational(-numer, denom)

  def -(that: Rational) = this + -that
  
  def neg = -this

  override def toString = {
  	val g = gcd(numer,denom)
  	(numer / g) + "/" + (denom / g)
  }

}
