// Generated from java-escape by ANTLR 4.11.1


package org.boxin;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConfigsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConfigsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(ConfigsParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#sy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSy(ConfigsParser.SyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#moveL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveL(ConfigsParser.MoveLContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#moveR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveR(ConfigsParser.MoveRContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(ConfigsParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigsParser#ride}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRide(ConfigsParser.RideContext ctx);
}