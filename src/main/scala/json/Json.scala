package json

case class Json(value: Value) {
  override def toString: Predef.String = value.toString
}
