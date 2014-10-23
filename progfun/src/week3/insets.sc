//package week3
object insets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  (((Empty incl 2) incl 1) incl 3)                //> res0: week3.IntSet = {{.1.}2{.3.}}

  val a = new NonEmpty(1, Empty, Empty)           //> a  : week3.NonEmpty = {.1.}
  val b = new NonEmpty(2, Empty, Empty)           //> b  : week3.NonEmpty = {.2.}
  val c = new NonEmpty(3, Empty, Empty)           //> c  : week3.NonEmpty = {.3.}

  a.union(b).union(c)                             //> res1: week3.IntSet = {{.1{.2.}}3.}
  a.contains(2)

}


abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int) =
    if (x > elem) right contains x
    else if (x < elem) left contains x
    else true

  def incl(x: Int) =
    if (x < elem)
      new NonEmpty(elem, left incl x, right)
    else if (x > elem)
      new NonEmpty(elem, left, right incl x)
    else this

	def union(other: IntSet) =

	  ((left union right) union other) incl elem


  override def toString = "{" + left + elem + right + "}"


}

object Empty extends IntSet {
  def incl(x: Int) = new NonEmpty(x, Empty, Empty)
  def contains(x: Int) = false
  def union(other: IntSet) = other

  override def toString = "."
}



