package json

abstract class Value {

}

case object Null extends Value

sealed abstract class Boolean extends Value
case object True extends Boolean
case object False extends Boolean



