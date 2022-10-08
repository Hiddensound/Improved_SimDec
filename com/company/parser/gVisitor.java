// Generated from C:/Users/batma/IdeaProjects/demoHello\g.g4 by ANTLR 4.8
package com.company.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(gParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(gParser.NameContext ctx);
}