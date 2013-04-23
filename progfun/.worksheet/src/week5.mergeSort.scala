package week5

import scala.math.Ordering

object mergeSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(525); 

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  };System.out.println("""msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]""");$skip(33); val res$0 = 

  msort(List(2, 1, 4, 3, 6, 5));System.out.println("""res0: List[Int] = """ + $show(res$0))}

}