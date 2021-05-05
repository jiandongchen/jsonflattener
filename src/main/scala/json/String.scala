package json

class String(val value: java.lang.String) extends Value {
  override def toString: Predef.String = value
}
