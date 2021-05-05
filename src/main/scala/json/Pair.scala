package json

case class Pair(key: java.lang.String, value: Value) {
  override def toString: Predef.String = {
    key + " : " + value.toString
  }
}
