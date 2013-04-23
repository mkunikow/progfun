package week6

object pairs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
  //Sacado de OtherColections
  def isPrime(n: Int): Boolean =
    (2 until n) forall (x => n % x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(212); 

  def combine(n: Int): IndexedSeq[(Int, Int)] = {
    val xss = (1 until n) map (i => (1 until i) map (j => (i, j)))
    //xss.foldRight(IndexedSeq[(Int, Int)]())(_ ++ _)
    //Es lo mismo!!
    xss.flatten
  };System.out.println("""combine: (n: Int)IndexedSeq[(Int, Int)]""");$skip(117); 

  def combine2(n: Int): IndexedSeq[(Int, Int)] = {
    (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
  };System.out.println("""combine2: (n: Int)IndexedSeq[(Int, Int)]""");$skip(156); 

  def combinePrimes(n: Int): IndexedSeq[(Int, Int)] = {
    for {
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)
  };System.out.println("""combinePrimes: (n: Int)IndexedSeq[(Int, Int)]""");$skip(50); val res$0 = 

  combine(10) filter (x => isPrime(x._1 + x._2));System.out.println("""res0: IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(21); val res$1 = 

  combinePrimes(10);System.out.println("""res1: IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(117); 

  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for ((x, y) <- xs zip ys) yield (x * y)).sum;System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""");$skip(48); val res$2 = 
 
  scalarProduct(List(1, 2, 3), List(4, 5, 6));System.out.println("""res2: Double = """ + $show(res$2))}

}