package week4

object PatternMatching {
  val e1 = Sum(Prod(Number(1), Number(2)), Sum(Prod(Number(3), Var("x")), Var("y")))
                                                  //> e1  : week4.Sum = Sum(Prod(Number(1),Number(2)),Sum(Prod(Number(3),Var(x)),V
                                                  //| ar(y)))

  e1.show                                         //> res0: String = (1 * 2 + (3 * x + y))
  
  e1.eval(Map("x"-> 1, "y"-> 2))                  //> res1: Int = 7
  
  
  //En el ejemplo creo esta mal como tiene que dar, porque no tiene sentido, Para mi esta bien como da aca
  Prod(Sum(Number(2), Var("x")), Var("y")).show   //> res2: String = (2 + x) * y
  
  Sum(Prod(Number(2), Var("x")), Var("y")).show   //> res3: String = (2 * x + y)
}