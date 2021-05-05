package app

import java.io.IOException

import antlr.{JsonLexer, JsonParser}
import json.{AntlrToJson, Json}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object JsonApp {
  def main(args: Array[String]): Unit = {
    val fileName = "F:\\Idea Projects\\jsonflatter\\src\\main\\java\\tests\\test1.json"
    val parser = getParser(fileName)
    val antlrAST = parser.json()
    val jsonVisitor = new AntlrToJson()
    val json: Json = jsonVisitor.visit(antlrAST)
    println(json.toString)
  }

  private def getParser(fileName: String): JsonParser = {
    var parser: JsonParser = null

    try {
      val input = CharStreams.fromFileName(fileName)
      val lexer = new JsonLexer(input)
      val tokens = new CommonTokenStream(lexer)
      parser = new JsonParser(tokens)
    }
    catch {
      case e: IOException => e.printStackTrace()
    }

    parser
  }
}
