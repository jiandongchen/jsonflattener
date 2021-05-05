package json

final case class Array(var values: List[Value] = List.empty) extends Value {

  def addValue(v: Value): Unit = {
    this.values = values :+ v
  }

  override def toString: Predef.String = {
    s"""
       |[
       |${values.mkString(",\n")}
       |]""".stripMargin
  }
}
