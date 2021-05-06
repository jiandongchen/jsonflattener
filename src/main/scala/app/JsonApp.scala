package app

import java.io.IOException

import antlr.{JsonLexer, JsonParser}
import json.{AntlrToJson, Json, JsonFlattener}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object JsonApp {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      System.err.println("Usage: file name")
    }
    else {
      val fileName = args(0)
      val parser = getParser(fileName)
      val antlrAST = parser.json()
      val jsonVisitor = new AntlrToJson()
      val json: Json = jsonVisitor.visit(antlrAST)
      val flattenedJson = JsonFlattener.flattenJson(json)
      println(flattenedJson.toString)
    }
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
