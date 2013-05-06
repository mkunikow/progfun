package week6

object MapsStructure {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)

  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)

  capitalOfCountry("US")                          //> res0: String = Washington

  capitalOfCountry get "US"                       //> res1: Option[String] = Some(Washington)

  capitalOfCountry get "Andorra"                  //> res2: Option[String] = None

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "missing data"
  }                                               //> showCapital: (country: String)String

  showCapital("US")                               //> res3: String = Washington

  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit sortWith (_.length < _.length)            //> res4: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res5: List[String] = List(apple, orange, pear, pineapple)
  
  fruit groupBy (_.head)                          //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
}