
object books {
  case class Book(title: String, authors: List[String])

  val books = List(
    Book(
      title = "t1",
      authors = List("a1", "a2")),
    Book(
      title = "t2",
      authors = List("a1", "a3")),
    Book(
      title = "t3",
      authors = List("a1", "a4"))
  )

  val booksSet = Set(
    Book(
      title = "t1",
      authors = List("a1", "a2")),
    Book(
      title = "t2",
      authors = List("a1", "a3")),
    Book(
      title = "t3",
      authors = List("a1", "a4"))
  )

  for (b <- books if b.title.indexOf("t2") >= 0)
    yield b.title

  for {
    b1 <- books
    b2 <- books
    if b1 != b2
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield  a1

  for {
    b1 <- booksSet
    b2 <- booksSet
    if b1 != b2
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield  a1

  for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield  a1

  {
    for {
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1
  }.distinct
}