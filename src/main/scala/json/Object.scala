package json

final case class Object(var pairs: List[Pair] = List.empty) extends Value {
  def addPair(p: Pair): Object = {
    this.pairs = this.pairs :+ p
    this
  }

  override def toString: Predef.String = {
    def pairsToString(pairs: List[Pair]): java.lang.String = {
      pairs match {
        case h :: Nil =>
          h.toString
        case h :: t =>
          h.toString + ",\n" + pairsToString(t)
      }
    }

    "{\n" + pairsToString(this.pairs) + "\n}"
  }
}
