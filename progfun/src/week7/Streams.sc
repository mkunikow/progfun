package week7

import com.sun.org.apache.xml.internal.serializer.ToStream

object Streams {
  def isPrime(n: Int): Boolean =
    (2 until n) forall (x => n % x != 0)          //> isPrime: (n: Int)Boolean

  (10 to 10000).toStream                          //> res0: scala.collection.immutable.Stream[Int] = Stream(10, ?)

  ((1000 to 10000).toStream filter isPrime)(1)    //> res1: Int = 1013
  
  10 #:: ( (10 to 10000).toStream)                //> res2: scala.collection.immutable.Stream[Int] = Stream(10, ?)
}