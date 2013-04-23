package week4

trait Expr {
  //En el curso no lo hace con un mapa, pero me copo hacerlo asi para hacerla completita
  def eval(variables: Map[String, Int]): Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval(variables) + e2.eval(variables)
    case Prod(e1, e2) => e1.eval(variables) * e2.eval(variables)
    case Var(name) => variables.get(name).get
  }

  def show(): String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => "(" + e1.show + " + " + e2.show + ")"
    case Prod(e1, e2) => e1.show + " * " + e2.show
    case Var(name) => name

  }

}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(name: String) extends Expr
