package week6

object OtherCollections {
  def isPrime(n: Int): Boolean =
  	(2 until n) forall (x => n % x != 0)      //> isPrime: (n: Int)Boolean
  	
  	isPrime(2)                                //> res0: Boolean = true
}