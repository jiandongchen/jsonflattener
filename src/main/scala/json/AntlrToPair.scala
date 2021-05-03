package json

import antlr.{JsonBaseVisitor, JsonParser}

class AntlrToPair extends JsonBaseVisitor[Pair] {
  override def visitPair(ctx: JsonParser.PairContext): Pair = {
    val keyText = ctx.getChild(0).getText
    val value = ctx.getChild(2)
    val valueVisitor = new AntlrToValue
    new Pair(keyText, valueVisitor.visit(value))
  }
}
