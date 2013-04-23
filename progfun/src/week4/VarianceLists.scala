package week4

trait VList[+T]{
  def isEmpty:Boolean
  def head:T
  def tail:VList[T]
  def prepend[U >: T](elem:U): VList[U] = new VCons(elem, this)
}

class VCons[T](val head: T, val tail: VList[T]) extends VList[T]{
  def isEmpty = false
}

object VNil extends VList[Nothing]{
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException 
  def tail: Nothing = throw new NoSuchElementException
}

