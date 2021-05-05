package json

final case class String(value: java.lang.String) extends Value {
  override def toString: Predef.String = value
}
