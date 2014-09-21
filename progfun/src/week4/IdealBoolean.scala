package week4

abstract class IdealBoolean {

  def ifThenElse[T](x: => T, y: => T): T

  def <(t: => IdealBoolean) = ifThenElse(false, t)

  def || (x: => Boolean) : Boolean = ifThenElse(true, x)
  def && (x: => Boolean) : Boolean = ifThenElse(x, false)
  def unary_! : Boolean = ifThenElse(false, true)
  def == (x : Boolean) : Boolean = ifThenElse(x, x.unary_!)
  def != (x : Boolean) : Boolean = ifThenElse(x.unary_!, x)
}

object True extends IdealBoolean {
  def ifThenElse[T](x: => T, y: => T) = x
}

object False extends IdealBoolean {
  def ifThenElse[T](x: => T, y: => T) = y
}