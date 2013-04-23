package week2

object Currying {
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int
    
  def factorial(n: Int) =  	product(x => x) (1,n)
                                                  //> factorial: (n: Int)Int
	
	def mapReduce (unit: Int, combine: (Int, Int) => Int) (f: Int => Int) (a: Int, b: Int): Int =
		if (a > b) unit else combine(f(a), mapReduce(unit, combine)(f)(a+1,b))
                                                  //> mapReduce: (unit: Int, combine: (Int, Int) => Int)(f: Int => Int)(a: Int, b:
                                                  //|  Int)Int
  
  product(x => x)(1, 5)                           //> res0: Int = 120
  
  factorial(5)                                    //> res1: Int = 120
  
  def product2 (f: Int => Int)(a: Int, b: Int): Int = mapReduce(1, (x, y) => x * y) (f) (a,b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  
  
  product2(x => x)(1, 5)                          //> res2: Int = 120
  
  
  
}