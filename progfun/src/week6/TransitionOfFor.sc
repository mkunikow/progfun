
object transitionoffor {
  def mapFun[T,U] (xs: List[T], f: T=>U): List[U] =
    for (x <- xs) yield f(x)

  def flatMap[T,U] (xs: List[T], f: T=>Iterable[U]): List[U] =
    for (x <- xs; y <- f(x)) yield y

  def filter[T] (xs: List[T], p: T=>Boolean): List[T] =
    for (x <- xs if p(x)) yield x


}

/*
  1. Simple for expression

  for (x <- e1) yield e2 --> e1.map(x => e2)

  2. For expression

  for (x <- e1 if f; s) --> for ( x <- e1.withFilter(x ==> f); s)  yield e2

  3. A for-expression

  for (x <- e1; y <- e2; s) yield e3
      --> e1.flatMap(x => for (y <- e2;s) yield e3)


  val n = 10
  val i = 5

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)


(1 until n).flatMap( i =>
  (1 until i).withFilter(j => isPrime(i+j))
  .map(j =>(i,j)))



Transform

for (b <- books; a <- b.authors if a startsWith "Bird")
  yield b.tile


books.flatMap(b =>
   for (a <= b.authors if a startsWith "Bird") yield b.tile )
   ...

   for (a <= b.authors withFilter(x => x startsWith "Bird")) yield b.tile )

   ....

   b.authors withFilter(x => x startsWith "Bird") map (y => y.title))

 */

