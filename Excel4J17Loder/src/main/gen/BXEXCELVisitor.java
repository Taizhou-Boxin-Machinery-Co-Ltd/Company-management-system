// Generated from java-escape by ANTLR 4.11.1


package union.xenfork.news;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BXEXCELParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BXEXCELVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(BXEXCELParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#c1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC1(BXEXCELParser.C1Context ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#cc1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCc1(BXEXCELParser.Cc1Context ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#sheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSheet(BXEXCELParser.SheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#xlsx_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXlsx_x(BXEXCELParser.Xlsx_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#xlsx_a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXlsx_a(BXEXCELParser.Xlsx_aContext ctx);
	/**
	 * Visit a parse tree produced by {@link BXEXCELParser#xlxs_xa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXlxs_xa(BXEXCELParser.Xlxs_xaContext ctx);
}