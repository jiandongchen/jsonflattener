package json

class Json(val value: Value) {
  override def toString: Predef.String = value.toString
}
