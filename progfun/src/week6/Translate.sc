package week6

import scala.io.Source

object Translate {
  val file = Source.fromURL("file:///home/ger/develop/progfun-workspace/progfun/src/week6/linuxwords.txt", "UTF-8")
                                                  //> file  : scala.io.BufferedSource = non-empty iterator

  val words = file.getLines.toList.filter(word => word.forall(chr => chr.isLetter))
                                                  //> words  : List[String] = List(Aarhus, Aaron, Ababa, aback, abaft, abandon, ab
                                                  //| andoned, abandoning, abandonment, abandons, abase, abased, abasement, abasem
                                                  //| ents, abases, abash, abashed, abashes, abashing, abasing, abate, abated, aba
                                                  //| tement, abatements, abater, abates, abating, Abba, abbe, abbey, abbeys, abbo
                                                  //| t, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbreviating, abbre
                                                  //| viation, abbreviations, Abby, abdomen, abdomens, abdominal, abduct, abducted
                                                  //| , abduction, abductions, abductor, abductors, abducts, Abe, abed, Abel, Abel
                                                  //| ian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberrations, abet, 
                                                  //| abets, abetted, abetter, abetting, abeyance, abhor, abhorred, abhorrent, abh
                                                  //| orrer, abhorring, abhors, abide, abided, abides, abiding, Abidjan, Abigail, 
                                                  //| Abilene, abilities, ability, abject, abjection, abjections, abjectly, abject
                                                  //| ness, abjure, abjured, abjures, abjuring, ablate, ablated, ablates, ablating
                                                  //| , ablation, ablative, ab
                                                  //| Output exceeds cutoff limit.

  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
                                                  //> mnem  : scala.collection.immutable.Map[Char,java.lang.String] = Map(8 -> TUV
                                                  //| , 4 -> GHI, 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)

  val charCode: Map[Char, Char] =
    (for ((num, letters) <- mnem; char <- letters) yield (char, num)).toMap
                                                  //> charCode  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J -
                                                  //| > 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5,
                                                  //|  B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z -
                                                  //| > 9, S -> 7)
  //mnem.flatMap( value => value._2.map(char => (value._1, char))).toMap

  def wordCode(word: String): String =
    word.toUpperCase() map charCode               //> wordCode: (word: String)String

  wordCode("GERMAN")                              //> res0: String = 437626

  def wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue Seq() //> wordsForNum: => Map[String,Seq[String]]

  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else
      {
        for {
          split <- 1 to number.length
          word <- wordsForNum(number take split)
          rest <- encode(number drop split)
        } yield word :: rest
      }.toSet                                     //> encode: (number: String)Set[List[String]]

  encode("7225247386")                            //> res1: Set[List[String]] = Set(List(sack, ah, re, to), List(rack, bird, to),
                                                  //|  List(sack, air, fun), List(rack, ah, re, to), List(pack, bird, to), List(s
                                                  //| ack, bird, to), List(pack, air, fun), List(Scala, ire, to), List(Scala, is,
                                                  //|  fun), List(pack, ah, re, to), List(rack, air, fun))

  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")
                                                  //> translate: (number: String)Set[String]

  translate("7225247386")                         //> res2: Set[String] = Set(sack air fun, pack ah re to, pack bird to, Scala ir
                                                  //| e to, Scala is fun, rack ah re to, pack air fun, sack bird to, rack bird to
                                                  //| , sack ah re to, rack air fun)
}