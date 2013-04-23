package week6

import scala.io.Source

object Translate {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(173); 
  val file = Source.fromURL("file:///home/ger/develop/progfun-workspace/progfun/src/week6/linuxwords.txt", "UTF-8");System.out.println("""file  : scala.io.BufferedSource = """ + $show(file ));$skip(85); 

  val words = file.getLines.toList.filter(word => word.forall(chr => chr.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(132); 

  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,java.lang.String] = """ + $show(mnem ));$skip(111); 

  val charCode: Map[Char, Char] =
    (for ((num, letters) <- mnem; char <- letters) yield (char, num)).toMap;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(149); 
  //mnem.flatMap( value => value._2.map(char => (value._1, char))).toMap

  def wordCode(word: String): String =
    word.toUpperCase() map charCode;System.out.println("""wordCode: (word: String)String""");$skip(22); val res$0 = 

  wordCode("GERMAN");System.out.println("""res0: String = """ + $show(res$0));$skip(97); 

  def wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue Seq();System.out.println("""wordsForNum: => Map[String,Seq[String]]""");$skip(292); 

  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else
      {
        for {
          split <- 1 to number.length
          word <- wordsForNum(number take split)
          rest <- encode(number drop split)
        } yield word :: rest
      }.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(24); val res$1 = 

  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(84); 

  def translate(number: String): Set[String] = encode(number) map (_ mkString " ");System.out.println("""translate: (number: String)Set[String]""");$skip(27); val res$2 = 

  translate("7225247386");System.out.println("""res2: Set[String] = """ + $show(res$2))}
}