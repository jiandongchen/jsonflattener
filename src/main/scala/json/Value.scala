package json

abstract class Value extends Product {
  def toString: Predef.String
}

case object Null extends Value {
  override def toString: Predef.String = "null"
}

sealed abstract class Boolean extends Value

case object True extends Boolean {
  override def toString: Predef.String = "true"
}

case object False extends Boolean {
  override def toString: Predef.String = "false"
}



