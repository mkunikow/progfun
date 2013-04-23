package week2

object Rational {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val x = new Rational(1, 2)                      //> x  : week2.Rational = 1/2

  x - x                                           //> res0: week2.Rational = 0/1

  new Rational(1, 3) - new Rational(5, 7) - new Rational(3, 2)
                                                  //> res1: week2.Rational = -79/42

  new Rational(1, 1)                              //> res2: week2.Rational = 1/1

  new Rational(1)                                 //> res3: week2.Rational = 1/1

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