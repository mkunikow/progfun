//package week5

object ReductionsOnList {
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)           //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, y) => y + 1)             //> lengthFun: [T](xs: List[T])Int
    
  mapFun(List(1,2,3), ((x:Int) => x*2))           //> res0: List[Int] = List(2, 4, 6)
  
  mapFun(List(), ((x:Int) => x*2))                //> res1: List[Int] = List()
  
  lengthFun(List(1,2,3))                          //> res2: Int = 3
  
  lengthFun(List())                               //> res3: Int = 0
}