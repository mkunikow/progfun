package week6

object polynomials {
  class Poly(val terms0: Map[Int, Double]) {
    val terms = terms0.withDefaultValue(0.0)

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    def +(other: Poly): Poly = new Poly(terms ++ (other.terms map adjust))

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coef) = term
      /* primera forma, mas larga
      terms.get(exp) match {
        case None => exp -> coef
        case Some(value) => exp -> (coef + value)
      }
      */
      exp -> (coef + terms(exp))
    }

    def otherPlus(other: Poly) =
      new Poly((other.terms foldLeft terms)(addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
      val (exp, coef) = term
      terms + (exp -> (coef + terms(exp)))

    }

    override def toString =
      (for ((exp, coef) <- terms.toList.sorted.reverse) yield coef + "X^" + exp) mkString " + "

  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(971); 

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : week6.polynomials.Poly = """ + $show(p1 ));$skip(40); 
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : week6.polynomials.Poly = """ + $show(p2 ));$skip(11); val res$0 = 

  p1 + p2;System.out.println("""res0: week6.polynomials.Poly = """ + $show(res$0));$skip(19); val res$1 = 

  p1 otherPlus p2;System.out.println("""res1: week6.polynomials.Poly = """ + $show(res$1))}
}