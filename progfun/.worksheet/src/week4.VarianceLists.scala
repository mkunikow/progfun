package week4

object VarianceLists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  def f(xs: VList[NonEmpty], x:Empty) = xs prepend x;System.out.println("""f: (xs: week4.VList[week4.NonEmpty], x: week4.Empty)week4.VList[week4.IntSet]""")}
}