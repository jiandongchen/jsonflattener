// Generated from Json.g4 by ANTLR 4.9

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonParser}.
 */
public interface JsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsonParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(JsonParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(JsonParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JsonParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JsonParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(JsonParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(JsonParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(JsonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(JsonParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Object}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterObject(JsonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Object}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitObject(JsonParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterEmptyObject(JsonParser.EmptyObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitEmptyObject(JsonParser.EmptyObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArray(JsonParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArray(JsonParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(JsonParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(JsonParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTrue(JsonParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTrue(JsonParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFalse(JsonParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFalse(JsonParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Null}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNull(JsonParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link JsonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNull(JsonParser.NullContext ctx);
}