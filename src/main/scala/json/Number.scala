package json

class Number(val value: Int) extends Value {
  override def toString: Predef.String = value.toString
}
