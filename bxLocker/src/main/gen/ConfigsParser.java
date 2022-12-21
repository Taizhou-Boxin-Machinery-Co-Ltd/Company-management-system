// Generated from java-escape by ANTLR 4.11.1


package org.boxin;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ConfigsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MOVE=5, LINE_COMMENT=6, COMMENT=7, WS=8, 
		END=9, FILENAME=10, INT=11, SHEETNAME=12, DOUBLE=13, STRING=14;
	public static final int
		RULE_all = 0, RULE_sy = 1, RULE_moveL = 2, RULE_moveR = 3, RULE_plus = 4, 
		RULE_ride = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"all", "sy", "moveL", "moveR", "plus", "ride"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<<'", "'>>'", "'+'", "'*'", null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MOVE", "LINE_COMMENT", "COMMENT", "WS", 
			"END", "FILENAME", "INT", "SHEETNAME", "DOUBLE", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConfigsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllContext extends ParserRuleContext {
		public List<SyContext> sy() {
			return getRuleContexts(SyContext.class);
		}
		public SyContext sy(int i) {
			return getRuleContext(SyContext.class,i);
		}
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_all);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				sy();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyContext extends ParserRuleContext {
		public MoveLContext moveL() {
			return getRuleContext(MoveLContext.class,0);
		}
		public MoveRContext moveR() {
			return getRuleContext(MoveRContext.class,0);
		}
		public PlusContext plus() {
			return getRuleContext(PlusContext.class,0);
		}
		public RideContext ride() {
			return getRuleContext(RideContext.class,0);
		}
		public SyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterSy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitSy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitSy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyContext sy() throws RecognitionException {
		SyContext _localctx = new SyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sy);
		try {
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				moveL();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				moveR();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(19);
				plus();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(20);
				ride();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoveLContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode END() { return getToken(ConfigsParser.END, 0); }
		public TerminalNode INT() { return getToken(ConfigsParser.INT, 0); }
		public MoveLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterMoveL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitMoveL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitMoveL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveLContext moveL() throws RecognitionException {
		MoveLContext _localctx = new MoveLContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_moveL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((MoveLContext)_localctx).a = match(T__0);
			setState(24);
			((MoveLContext)_localctx).b = match(INT);
			setState(25);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoveRContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode END() { return getToken(ConfigsParser.END, 0); }
		public TerminalNode INT() { return getToken(ConfigsParser.INT, 0); }
		public MoveRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterMoveR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitMoveR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitMoveR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveRContext moveR() throws RecognitionException {
		MoveRContext _localctx = new MoveRContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_moveR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			((MoveRContext)_localctx).a = match(T__1);
			setState(28);
			((MoveRContext)_localctx).b = match(INT);
			setState(29);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode END() { return getToken(ConfigsParser.END, 0); }
		public TerminalNode INT() { return getToken(ConfigsParser.INT, 0); }
		public PlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusContext plus() throws RecognitionException {
		PlusContext _localctx = new PlusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			((PlusContext)_localctx).a = match(T__2);
			setState(32);
			((PlusContext)_localctx).b = match(INT);
			setState(33);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RideContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public TerminalNode END() { return getToken(ConfigsParser.END, 0); }
		public TerminalNode INT() { return getToken(ConfigsParser.INT, 0); }
		public RideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ride; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).enterRide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigsListener ) ((ConfigsListener)listener).exitRide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigsVisitor ) return ((ConfigsVisitor<? extends T>)visitor).visitRide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RideContext ride() throws RecognitionException {
		RideContext _localctx = new RideContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ride);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((RideContext)_localctx).a = match(T__3);
			setState(36);
			((RideContext)_localctx).b = match(INT);
			setState(37);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000e(\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0016\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0000%\u0000\r\u0001"+
		"\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004\u0017\u0001"+
		"\u0000\u0000\u0000\u0006\u001b\u0001\u0000\u0000\u0000\b\u001f\u0001\u0000"+
		"\u0000\u0000\n#\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000"+
		"\r\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f"+
		"\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0001"+
		"\u0001\u0000\u0000\u0000\u0011\u0016\u0003\u0004\u0002\u0000\u0012\u0016"+
		"\u0003\u0006\u0003\u0000\u0013\u0016\u0003\b\u0004\u0000\u0014\u0016\u0003"+
		"\n\u0005\u0000\u0015\u0011\u0001\u0000\u0000\u0000\u0015\u0012\u0001\u0000"+
		"\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0014\u0001\u0000"+
		"\u0000\u0000\u0016\u0003\u0001\u0000\u0000\u0000\u0017\u0018\u0005\u0001"+
		"\u0000\u0000\u0018\u0019\u0005\u000b\u0000\u0000\u0019\u001a\u0005\t\u0000"+
		"\u0000\u001a\u0005\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0002\u0000"+
		"\u0000\u001c\u001d\u0005\u000b\u0000\u0000\u001d\u001e\u0005\t\u0000\u0000"+
		"\u001e\u0007\u0001\u0000\u0000\u0000\u001f \u0005\u0003\u0000\u0000 !"+
		"\u0005\u000b\u0000\u0000!\"\u0005\t\u0000\u0000\"\t\u0001\u0000\u0000"+
		"\u0000#$\u0005\u0004\u0000\u0000$%\u0005\u000b\u0000\u0000%&\u0005\t\u0000"+
		"\u0000&\u000b\u0001\u0000\u0000\u0000\u0002\u000f\u0015";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}