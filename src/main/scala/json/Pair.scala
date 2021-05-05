package json

class Pair(val key: java.lang.String, val value: Value) {
  override def toString: Predef.String = {
    key + " : " + value.toString
  }
}
