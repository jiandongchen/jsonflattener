package json

final case class Number(value: Int) extends Value {
  override def toString: Predef.String = value.toString
}
