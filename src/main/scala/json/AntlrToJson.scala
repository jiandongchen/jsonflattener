package json

import antlr.{JsonBaseVisitor, JsonParser}

class AntlrToJson extends JsonBaseVisitor[Json] {
  override def visitJson(ctx: JsonParser.JsonContext): Json = {
    val valueVisitor = new AntlrToValue
    Json(valueVisitor.visit(ctx.value()))
  }
}
