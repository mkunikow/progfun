package week4

abstract class IdealBoolean {

  def ifThenElse[T](x: => T, y: => T): T

  def <(t: => IdealBoolean) = ifThenElse(false, t)
}

object True extends IdealBoolean {
  def ifThenElse[T](x: => T, y: => T) = x
}

object False extends IdealBoolean {
  def ifThenElse[T](x: => T, y: => T) = y
}