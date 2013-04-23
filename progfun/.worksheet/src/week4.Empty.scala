package week4

class IntSet[T<:Any]{
}

class NonEmpty[T](x: T, y: IntSet[T], z:IntSet[T]) extends IntSet[T]{
	
}

class Empty[T] extends IntSet[T]{
}

object Empty extends IntSet{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(203); 
	def apply = new Empty;System.out.println("""apply: => week4.Empty[Nothing]""")}
}

object Subtyping {
  val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
  val b: Array[IntSet] = a
  b(0) = Empty
  val s: NonEmpty = a(0)
}