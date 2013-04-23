package week4

object PatternMatching {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  val e1 = Sum(Prod(Number(1), Number(2)), Sum(Prod(Number(3), Var("x")), Var("y")));System.out.println("""e1  : week4.Sum = """ + $show(e1 ));$skip(11); val res$0 = 

  e1.show;System.out.println("""res0: String = """ + $show(res$0));$skip(36); val res$1 = 
  
  e1.eval(Map("x"-> 1, "y"-> 2));System.out.println("""res1: Int = """ + $show(res$1));$skip(161); val res$2 = 
  
  
  //En el ejemplo creo esta mal como tiene que dar, porque no tiene sentido, Para mi esta bien como da aca
  Prod(Sum(Number(2), Var("x")), Var("y")).show;System.out.println("""res2: String = """ + $show(res$2));$skip(51); val res$3 = 
  
  Sum(Prod(Number(2), Var("x")), Var("y")).show;System.out.println("""res3: String = """ + $show(res$3))}
}