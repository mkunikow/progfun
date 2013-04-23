package week4

object Lists {

  def singleton[T](cons: T) = new Cons[T](cons, new Nil[T])
                                                  //> singleton: [T](cons: T)week4.Cons[T]
  
  def nth[T](position: Int, list: List[T]) : T =
		if(position < 0 || list.isEmpty) throw new IndexOutOfBoundsException;
		else if(position == 0) list.head
		else nth(position - 1, list.tail) //> nth: [T](position: Int, list: week4.List[T])T
  
	nth(1,new Cons(5,new Cons(6,new Nil)))    //> res0: Int = 6
	
	  
  
  
  singleton[Int](1)                               //> res1: week4.Cons[Int] = week4.Cons@73a34b
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  List(1)                                         //> res2: week4.List[Int] = week4.Cons@509ced8e
  
  List(1,2)                                       //> res3: week4.List[Int] = week4.Cons@6eb02efa
}