package week3

object insets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(36); val res$0 = 

  (((Empty incl 2) incl 1) incl 3);System.out.println("""res0: week3.IntSet = """ + $show(res$0));$skip(43); 
  
  val a = new NonEmpty(1, Empty, Empty);System.out.println("""a  : week3.NonEmpty = """ + $show(a ));$skip(40); 
  val b = new NonEmpty(2, Empty, Empty);System.out.println("""b  : week3.NonEmpty = """ + $show(b ));$skip(40); 
  val c = new NonEmpty(3, Empty, Empty);System.out.println("""c  : week3.NonEmpty = """ + $show(c ));$skip(25); val res$1 = 
  
  a.union(b).union(c);System.out.println("""res1: week3.IntSet = """ + $show(res$1))}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

}

object Empty extends IntSet {
  def incl(x: Int) = new NonEmpty(x, Empty, Empty)
  def contains(x: Int) = false
  def union(other: IntSet) = other

  override def toString = "."
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