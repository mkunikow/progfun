package week7

object InfiniteSequences {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]

  val naturals = from(0)                          //> naturals  : Stream[Int] = Stream(0, ?)

  val m4s = naturals map (_ * 4)                  //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)

  (m4s take 1000).toList                          //> res0: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108, 112, 116, 120, 12
                                                  //| 4, 128, 132, 136, 140, 144, 148, 152, 156, 160, 164, 168, 172, 176, 180, 184
                                                  //| , 188, 192, 196, 200, 204, 208, 212, 216, 220, 224, 228, 232, 236, 240, 244,
                                                  //|  248, 252, 256, 260, 264, 268, 272, 276, 280, 284, 288, 292, 296, 300, 304, 
                                                  //| 308, 312, 316, 320, 324, 328, 332, 336, 340, 344, 348, 352, 356, 360, 364, 3
                                                  //| 68, 372, 376, 380, 384, 388, 392, 396, 400, 404, 408, 412, 416, 420, 424, 42
                                                  //| 8, 432, 436, 440, 444, 448, 452, 456, 460, 464, 468, 472, 476, 480, 484, 488
                                                  //| , 492, 496, 500, 504, 508, 512, 516, 520, 524, 528, 532, 536, 540, 544, 548,
                                                  //|  552, 556, 560, 564, 568, 572, 576, 580, 584, 588, 592, 596, 600, 604, 608, 
                                                  //| 612, 616, 620, 624, 628, 632, 636, 640, 644, 648, 652, 656, 660, 664, 668, 6
                                                  //| 72, 676, 680, 684, 688, 692, 696, 700, 704, 708, 712, 716, 720, 724, 728, 73
                                                  //| 2, 736, 740, 744, 748, 7
                                                  //| Output exceeds cutoff limit.

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]

  def sieve2(s: Stream[Int]): Stream[Int] = s match {
    case Stream.Empty => s
    case head #:: tail => head #:: sieve2(tail filter (_ % head != 0))
  }                                               //> sieve2: (s: Stream[Int])Stream[Int]

  (sieve(from(2)) take 100).toList                //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 4
                                                  //| 7, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131
                                                  //| , 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211,
                                                  //|  223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 
                                                  //| 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 3
                                                  //| 97, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 48
                                                  //| 7, 491, 499, 503, 509, 521, 523, 541)
  sieve2((2 to 100).toStream).toList              //> res2: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 4
                                                  //| 7, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]

  (sqrtStream(2.0) take 10).toList                //> res3: List[Double] = List(1.0, 1.5, 1.4166666666666665, 1.4142156862745097, 
                                                  //| 1.4142135623746899, 1.414213562373095, 1.414213562373095, 1.414213562373095,
                                                  //|  1.414213562373095, 1.414213562373095)

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001    //> isGoodEnough: (guess: Double, x: Double)Boolean

  ((sqrtStream(4) filter (isGoodEnough(_, 4))) take 10).toList
                                                  //> res4: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 2
                                                  //| .0, 2.0, 2.0, 2.0, 2.0, 2.0)

	val N = 3                                 //> N  : Int = 3

  val xs = from(1) map (_ * N)                    //> xs  : scala.collection.immutable.Stream[Int] = Stream(3, ?)
  val ys = from(1) filter (_ % N == 0)            //> ys  : scala.collection.immutable.Stream[Int] = Stream(3, ?)
  
  (xs take 10).toList                             //> res5: List[Int] = List(3, 6, 9, 12, 15, 18, 21, 24, 27, 30)
  (ys take 10).toList                             //> res6: List[Int] = List(3, 6, 9, 12, 15, 18, 21, 24, 27, 30)
}