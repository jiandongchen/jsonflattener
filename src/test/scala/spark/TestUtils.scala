package spark

import antlr.{JsonLexer, JsonParser}
import json.{AntlrToJson, Json, JsonFlattener}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

trait TestUtils {
  val flattenJson: String => String = (jso: String) => {
    def getParser(str: String): JsonParser = {
      var parser: JsonParser = null
      val input = CharStreams.fromString(str)
      val lexer = new JsonLexer(input)
      val tokens = new CommonTokenStream(lexer)
      parser = new JsonParser(tokens)
      parser
    }

    val parser = getParser(jso)
    val antlrAST = parser.json()
    val jsonVisitor = new AntlrToJson()
    val json: Json = jsonVisitor.visit(antlrAST)
    val flattenedJson = JsonFlattener.flattenJson(json)
    flattenedJson.toString
  }

  val flattenJsonUDF: UserDefinedFunction = udf(flattenJson)
}
