// Generated from Json.g4 by ANTLR 4.9

    package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, STRING=7, NUMBER=8, TRUE=9, 
		FALSE=10, NULL=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "STRING", "ESC", "UNICODE", 
			"HEX", "SAFECODEPOINT", "NUMBER", "INT", "EXP", "TRUE", "FALSE", "NULL", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'{'", "','", "'}'", "'['", "']'", null, null, "'true'", 
			"'false'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "STRING", "NUMBER", "TRUE", 
			"FALSE", "NULL", "WS"
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


	public JsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Json.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\7\b\67\n\b\f\b\16\b:\13\b\3\b\3\b\3\t\3\t\3\t\5\tA\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\5\rN\n\r\3\r\3\r\3\r\6\rS\n\r\r"+
		"\r\16\rT\5\rW\n\r\3\r\5\rZ\n\r\3\16\3\16\3\16\7\16_\n\16\f\16\16\16b\13"+
		"\16\5\16d\n\16\3\17\3\17\5\17h\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\6\23}\n\23"+
		"\r\23\16\23~\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2"+
		"\25\2\27\2\31\n\33\2\35\2\37\13!\f#\r%\16\3\2\n\n\2$$\61\61^^ddhhpptt"+
		"vv\5\2\62;CHch\5\2\2!$$^^\3\2\62;\3\2\63;\4\2GGgg\4\2--//\5\2\13\f\17"+
		"\17\"\"\2\u0086\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\31\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/"+
		"\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21=\3\2\2\2\23B\3\2\2\2\25H\3\2\2"+
		"\2\27J\3\2\2\2\31M\3\2\2\2\33c\3\2\2\2\35e\3\2\2\2\37k\3\2\2\2!p\3\2\2"+
		"\2#v\3\2\2\2%|\3\2\2\2\'(\7<\2\2(\4\3\2\2\2)*\7}\2\2*\6\3\2\2\2+,\7.\2"+
		"\2,\b\3\2\2\2-.\7\177\2\2.\n\3\2\2\2/\60\7]\2\2\60\f\3\2\2\2\61\62\7_"+
		"\2\2\62\16\3\2\2\2\638\7$\2\2\64\67\5\21\t\2\65\67\5\27\f\2\66\64\3\2"+
		"\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2"+
		"\2;<\7$\2\2<\20\3\2\2\2=@\7^\2\2>A\t\2\2\2?A\5\23\n\2@>\3\2\2\2@?\3\2"+
		"\2\2A\22\3\2\2\2BC\7w\2\2CD\5\25\13\2DE\5\25\13\2EF\5\25\13\2FG\5\25\13"+
		"\2G\24\3\2\2\2HI\t\3\2\2I\26\3\2\2\2JK\n\4\2\2K\30\3\2\2\2LN\7/\2\2ML"+
		"\3\2\2\2MN\3\2\2\2NO\3\2\2\2OV\5\33\16\2PR\7\60\2\2QS\t\5\2\2RQ\3\2\2"+
		"\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VP\3\2\2\2VW\3\2\2\2WY\3\2\2"+
		"\2XZ\5\35\17\2YX\3\2\2\2YZ\3\2\2\2Z\32\3\2\2\2[d\7\62\2\2\\`\t\6\2\2]"+
		"_\t\5\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2"+
		"c[\3\2\2\2c\\\3\2\2\2d\34\3\2\2\2eg\t\7\2\2fh\t\b\2\2gf\3\2\2\2gh\3\2"+
		"\2\2hi\3\2\2\2ij\5\33\16\2j\36\3\2\2\2kl\7v\2\2lm\7t\2\2mn\7w\2\2no\7"+
		"g\2\2o \3\2\2\2pq\7h\2\2qr\7c\2\2rs\7n\2\2st\7u\2\2tu\7g\2\2u\"\3\2\2"+
		"\2vw\7p\2\2wx\7w\2\2xy\7n\2\2yz\7n\2\2z$\3\2\2\2{}\t\t\2\2|{\3\2\2\2}"+
		"~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\23\2"+
		"\2\u0081&\3\2\2\2\16\2\668@MTVY`cg~\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}