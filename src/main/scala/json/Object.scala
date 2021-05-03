package json

class Object extends Value {
  var pairs: List[Pair] = List.empty

  def addPair(p: Pair): Unit = {
    this.pairs = this.pairs :+ p
  }
}
