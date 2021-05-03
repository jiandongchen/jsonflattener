package json

class Array extends Value {
  var values: List[Value] = List.empty

  def addValue(v: Value): Unit = {
    this.values = values :+ v
  }
}
