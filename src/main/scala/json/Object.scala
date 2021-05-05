package json

class Object extends Value {
  var pairs: List[Pair] = List.empty

  def addPair(p: Pair): Unit = {
    this.pairs = this.pairs :+ p
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
