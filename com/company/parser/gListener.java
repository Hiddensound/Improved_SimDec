// Generated from C:/Users/batma/IdeaProjects/demoHello\g.g4 by ANTLR 4.8
package com.company.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(gParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(gParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(gParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(gParser.NameContext ctx);
}