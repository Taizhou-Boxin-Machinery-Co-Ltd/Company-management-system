// Generated from java-escape by ANTLR 4.11.1


package org.boxin.g4;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BXEXCELLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LINE_COMMENT=4, COMMENT=5, WS=6, END=7, FILENAME=8, 
		INT=9, SHEETNAME=10, DOUBLE=11, STRING=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LINE_COMMENT", "COMMENT", "WS", "END", "FILENAME", 
			"INT", "SHEETNAME", "DOUBLE", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LINE_COMMENT", "COMMENT", "WS", "END", "FILENAME", 
			"INT", "SHEETNAME", "DOUBLE", "STRING"
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


	public BXEXCELLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BXEXCEL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\fk\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"$\b\u0003\n\u0003\f\u0003\'\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"1\b\u0004\n\u0004\f\u00044\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005<\b\u0005\u000b\u0005"+
		"\f\u0005=\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0004\u0007K\b\u0007\u000b\u0007\f\u0007L\u0003\u0007O\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\bV\b\b\u000b"+
		"\b\f\bW\u0001\t\u0004\t[\b\t\u000b\t\f\t\\\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0005\u000be\b\u000b\n\u000b\f\u000bh\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0003%2f\u0000\f\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0001\u0000\u0003\u0003\u0000\t\n\r\r  \u0001\u0000"+
		"09\u0004\u000009AZaz\u4e00\u8000\u9fa5r\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003"+
		"\u001b\u0001\u0000\u0000\u0000\u0005\u001d\u0001\u0000\u0000\u0000\u0007"+
		"\u001f\u0001\u0000\u0000\u0000\t,\u0001\u0000\u0000\u0000\u000b;\u0001"+
		"\u0000\u0000\u0000\rA\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000"+
		"\u0000\u0011U\u0001\u0000\u0000\u0000\u0013Z\u0001\u0000\u0000\u0000\u0015"+
		"^\u0001\u0000\u0000\u0000\u0017b\u0001\u0000\u0000\u0000\u0019\u001a\u0005"+
		"{\u0000\u0000\u001a\u0002\u0001\u0000\u0000\u0000\u001b\u001c\u0005,\u0000"+
		"\u0000\u001c\u0004\u0001\u0000\u0000\u0000\u001d\u001e\u0005}\u0000\u0000"+
		"\u001e\u0006\u0001\u0000\u0000\u0000\u001f \u0005/\u0000\u0000 !\u0005"+
		"/\u0000\u0000!%\u0001\u0000\u0000\u0000\"$\t\u0000\u0000\u0000#\"\u0001"+
		"\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000()\u0005\n\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0006\u0003\u0000"+
		"\u0000+\b\u0001\u0000\u0000\u0000,-\u0005/\u0000\u0000-.\u0005*\u0000"+
		"\u0000.2\u0001\u0000\u0000\u0000/1\t\u0000\u0000\u00000/\u0001\u0000\u0000"+
		"\u000014\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0005"+
		"*\u0000\u000067\u0005/\u0000\u000078\u0001\u0000\u0000\u000089\u0006\u0004"+
		"\u0000\u00009\n\u0001\u0000\u0000\u0000:<\u0007\u0000\u0000\u0000;:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0005\u0000"+
		"\u0000@\f\u0001\u0000\u0000\u0000AB\u0005;\u0000\u0000B\u000e\u0001\u0000"+
		"\u0000\u0000CD\u0003\u0013\t\u0000DE\u0005:\u0000\u0000EN\u0005\\\u0000"+
		"\u0000FO\u0001\u0000\u0000\u0000GH\u0003\u0013\t\u0000HI\u0005\\\u0000"+
		"\u0000IK\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001"+
		"\u0000\u0000\u0000NF\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0003\u0013\t\u0000QR\u0005.\u0000\u0000"+
		"RS\u0003\u0013\t\u0000S\u0010\u0001\u0000\u0000\u0000TV\u0007\u0001\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000X\u0012\u0001\u0000\u0000\u0000"+
		"Y[\u0007\u0002\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0014\u0001"+
		"\u0000\u0000\u0000^_\u0003\u0011\b\u0000_`\u0005.\u0000\u0000`a\u0003"+
		"\u0011\b\u0000a\u0016\u0001\u0000\u0000\u0000bf\u0005\"\u0000\u0000ce"+
		"\t\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ij\u0005\"\u0000\u0000j\u0018\u0001\u0000"+
		"\u0000\u0000\t\u0000%2=LNW\\f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}