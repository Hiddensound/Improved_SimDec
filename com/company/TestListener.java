// Generated from C:/Users/batma/IdeaProjects/demoHello/src/com/company\Test.g4 by ANTLR 4.8
package com.company;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TestParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TestParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(TestParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(TestParser.NameContext ctx);
}