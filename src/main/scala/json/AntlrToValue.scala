package json

import antlr.{JsonBaseVisitor, JsonParser}

class AntlrToValue extends JsonBaseVisitor[Value] {
  override def visitString(ctx: JsonParser.StringContext): Value = {
    val strText = ctx.STRING().getText
    json.String(strText)
  }

  override def visitNumber(ctx: JsonParser.NumberContext): Value = {
    val numText = ctx.NUMBER().getText
    Number(numText.toInt)
  }

  override def visitObject(ctx: JsonParser.ObjectContext): Value = {
    val obj = new Object
    val pairVisitor = new AntlrToPair
    for (i <- 1 until ctx.getChildCount by 2) {
      obj.addPair(pairVisitor.visit(ctx.getChild(i)))
    }
    obj
  }

  override def visitArray(ctx: JsonParser.ArrayContext): Value = {
    val arr = Array()
    for (i <- 1 until ctx.getChildCount by 2) {
      arr.addValue(this.visit(ctx.getChild(i)))
    }
    arr
  }

  override def visitTrue(ctx: JsonParser.TrueContext): Value = True

  override def visitFalse(ctx: JsonParser.FalseContext): Value = False

  override def visitNull(ctx: JsonParser.NullContext): Value = Null

  override def visitEmptyObject(ctx: JsonParser.EmptyObjectContext): Value = Object()

  override def visitEmptyArray(ctx: JsonParser.EmptyArrayContext): Value = Array()
}
