// Generated from java-escape by ANTLR 4.11.1


package org.boxin.utils.algorithm.g4;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConfigsParser}.
 */
public interface ConfigsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#all}.
	 * @param ctx the parse tree
	 */
	void enterAll(ConfigsParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#all}.
	 * @param ctx the parse tree
	 */
	void exitAll(ConfigsParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#sy}.
	 * @param ctx the parse tree
	 */
	void enterSy(ConfigsParser.SyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#sy}.
	 * @param ctx the parse tree
	 */
	void exitSy(ConfigsParser.SyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#moveL}.
	 * @param ctx the parse tree
	 */
	void enterMoveL(ConfigsParser.MoveLContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#moveL}.
	 * @param ctx the parse tree
	 */
	void exitMoveL(ConfigsParser.MoveLContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#moveR}.
	 * @param ctx the parse tree
	 */
	void enterMoveR(ConfigsParser.MoveRContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#moveR}.
	 * @param ctx the parse tree
	 */
	void exitMoveR(ConfigsParser.MoveRContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#plus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(ConfigsParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#plus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(ConfigsParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigsParser#ride}.
	 * @param ctx the parse tree
	 */
	void enterRide(ConfigsParser.RideContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigsParser#ride}.
	 * @param ctx the parse tree
	 */
	void exitRide(ConfigsParser.RideContext ctx);
}