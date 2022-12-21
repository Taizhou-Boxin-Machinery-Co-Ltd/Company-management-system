// Generated from java-escape by ANTLR 4.11.1


package org.boxin.utils.algorithm.g4;
/**
 * @author baka4n
 */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ConfigsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MOVE=5, LINE_COMMENT=6, COMMENT=7, WS=8, 
		END=9, FILENAME=10, INT=11, SHEETNAME=12, DOUBLE=13, STRING=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MOVE", "LINE_COMMENT", "COMMENT", "WS", 
			"END", "FILENAME", "INT", "SHEETNAME", "DOUBLE", "STRING"
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


	public ConfigsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Configs.g4"; }

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
		"\u0004\u0000\u000ey\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004,\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u00052\b\u0005\n\u0005\f\u00055\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006?\b\u0006\n\u0006\f\u0006B\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007J\b\u0007\u000b"+
		"\u0007\f\u0007K\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tY\b\t\u000b\t\f\tZ\u0003"+
		"\t]\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\nd\b\n\u000b\n\f"+
		"\ne\u0001\u000b\u0004\u000bi\b\u000b\u000b\u000b\f\u000bj\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\rs\b\r\n\r\f\rv\t\r\u0001\r\u0001"+
		"\r\u00033@t\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u0001\u0000\u0003\u0003\u0000\t\n\r\r  \u0001\u0000"+
		"09\u0004\u000009AZaz\u4e00\u8000\u9fa5\u0081\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003"+
		" \u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007%\u0001"+
		"\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000"+
		"\u0000\r:\u0001\u0000\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011"+
		"O\u0001\u0000\u0000\u0000\u0013Q\u0001\u0000\u0000\u0000\u0015c\u0001"+
		"\u0000\u0000\u0000\u0017h\u0001\u0000\u0000\u0000\u0019l\u0001\u0000\u0000"+
		"\u0000\u001bp\u0001\u0000\u0000\u0000\u001d\u001e\u0005<\u0000\u0000\u001e"+
		"\u001f\u0005<\u0000\u0000\u001f\u0002\u0001\u0000\u0000\u0000 !\u0005"+
		">\u0000\u0000!\"\u0005>\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$"+
		"\u0005+\u0000\u0000$\u0006\u0001\u0000\u0000\u0000%&\u0005*\u0000\u0000"+
		"&\b\u0001\u0000\u0000\u0000\'(\u0005<\u0000\u0000(,\u0005<\u0000\u0000"+
		")*\u0005>\u0000\u0000*,\u0005>\u0000\u0000+\'\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005/\u0000\u0000"+
		"./\u0005/\u0000\u0000/3\u0001\u0000\u0000\u000002\t\u0000\u0000\u0000"+
		"10\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000067\u0005\n\u0000\u000078\u0001\u0000\u0000\u000089\u0006\u0005"+
		"\u0000\u00009\f\u0001\u0000\u0000\u0000:;\u0005/\u0000\u0000;<\u0005*"+
		"\u0000\u0000<@\u0001\u0000\u0000\u0000=?\t\u0000\u0000\u0000>=\u0001\u0000"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"CD\u0005*\u0000\u0000DE\u0005/\u0000\u0000EF\u0001\u0000\u0000\u0000F"+
		"G\u0006\u0006\u0000\u0000G\u000e\u0001\u0000\u0000\u0000HJ\u0007\u0000"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0006\u0007\u0000\u0000N\u0010\u0001\u0000\u0000\u0000OP\u0005;\u0000"+
		"\u0000P\u0012\u0001\u0000\u0000\u0000QR\u0003\u0017\u000b\u0000RS\u0005"+
		":\u0000\u0000S\\\u0005\\\u0000\u0000T]\u0001\u0000\u0000\u0000UV\u0003"+
		"\u0017\u000b\u0000VW\u0005\\\u0000\u0000WY\u0001\u0000\u0000\u0000XU\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\T\u0001\u0000\u0000"+
		"\u0000\\X\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0003\u0017"+
		"\u000b\u0000_`\u0005.\u0000\u0000`a\u0003\u0017\u000b\u0000a\u0014\u0001"+
		"\u0000\u0000\u0000bd\u0007\u0001\u0000\u0000cb\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000f\u0016\u0001\u0000\u0000\u0000gi\u0007\u0002\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000k\u0018\u0001\u0000\u0000\u0000lm\u0003\u0015"+
		"\n\u0000mn\u0005.\u0000\u0000no\u0003\u0015\n\u0000o\u001a\u0001\u0000"+
		"\u0000\u0000pt\u0005\"\u0000\u0000qs\t\u0000\u0000\u0000rq\u0001\u0000"+
		"\u0000\u0000sv\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000"+
		"wx\u0005\"\u0000\u0000x\u001c\u0001\u0000\u0000\u0000\n\u0000+3@KZ\\e"+
		"jt\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}