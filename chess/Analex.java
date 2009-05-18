// $ANTLR : "Analex.g" -> "Analex.java"$

	package chess;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class Analex extends antlr.CharScanner implements AnalexVocabTokenTypes, TokenStream
 {
public Analex(InputStream in) {
	this(new ByteBuffer(in));
}
public Analex(Reader in) {
	this(new CharBuffer(in));
}
public Analex(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public Analex(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("F_D_LAST_MOVE", this), new Integer(113));
	literals.put(new ANTLRHashString("C_O_LAST_MOVE", this), new Integer(110));
	literals.put(new ANTLRHashString("RATIO_WB", this), new Integer(114));
	literals.put(new ANTLRHashString("...", this), new Integer(100));
	literals.put(new ANTLRHashString("MOVE_RANDOMLY_W", this), new Integer(56));
	literals.put(new ANTLRHashString("end_board", this), new Integer(5));
	literals.put(new ANTLRHashString("CAPTURED_PIECE_TYPE", this), new Integer(116));
	literals.put(new ANTLRHashString("begin_board", this), new Integer(4));
	literals.put(new ANTLRHashString("begin_variables", this), new Integer(9));
	literals.put(new ANTLRHashString("CHECKMATE", this), new Integer(105));
	literals.put(new ANTLRHashString("READ_CHR", this), new Integer(121));
	literals.put(new ANTLRHashString("MOD", this), new Integer(124));
	literals.put(new ANTLRHashString("WAIT", this), new Integer(123));
	literals.put(new ANTLRHashString("MOVEMENTS_LIST", this), new Integer(59));
	literals.put(new ANTLRHashString("READ_NUMBER", this), new Integer(119));
	literals.put(new ANTLRHashString("From", this), new Integer(99));
	literals.put(new ANTLRHashString("Play", this), new Integer(96));
	literals.put(new ANTLRHashString("F_O_LAST_MOVE", this), new Integer(111));
	literals.put(new ANTLRHashString("MOVE_PLAYER_B", this), new Integer(55));
	literals.put(new ANTLRHashString("RANDOM_BOARD", this), new Integer(49));
	literals.put(new ANTLRHashString("CASTLING", this), new Integer(118));
	literals.put(new ANTLRHashString("FLO", this), new Integer(91));
	literals.put(new ANTLRHashString("STATE_3D", this), new Integer(103));
	literals.put(new ANTLRHashString("begin_game", this), new Integer(6));
	literals.put(new ANTLRHashString("CHR", this), new Integer(89));
	literals.put(new ANTLRHashString("GENERATE_3D_BOARD", this), new Integer(53));
	literals.put(new ANTLRHashString("POINTS", this), new Integer(109));
	literals.put(new ANTLRHashString("PIECE_COLOR", this), new Integer(108));
	literals.put(new ANTLRHashString("STATE", this), new Integer(58));
	literals.put(new ANTLRHashString("end_variables", this), new Integer(10));
	literals.put(new ANTLRHashString("REMOVE_PIECE", this), new Integer(52));
	literals.put(new ANTLRHashString("If_Chess", this), new Integer(93));
	literals.put(new ANTLRHashString("WRT", this), new Integer(122));
	literals.put(new ANTLRHashString("INT", this), new Integer(88));
	literals.put(new ANTLRHashString("While_Chess", this), new Integer(101));
	literals.put(new ANTLRHashString("READ_STR", this), new Integer(120));
	literals.put(new ANTLRHashString("Play_If", this), new Integer(95));
	literals.put(new ANTLRHashString("End_If_Chess", this), new Integer(94));
	literals.put(new ANTLRHashString("End_While_Chess", this), new Integer(102));
	literals.put(new ANTLRHashString("MOVE_PLAYER_W", this), new Integer(54));
	literals.put(new ANTLRHashString("cnst", this), new Integer(20));
	literals.put(new ANTLRHashString("PIECE_TYPE", this), new Integer(107));
	literals.put(new ANTLRHashString("C_D_LAST_MOVE", this), new Integer(112));
	literals.put(new ANTLRHashString("For_Chess", this), new Integer(98));
	literals.put(new ANTLRHashString("STALEMATE", this), new Integer(106));
	literals.put(new ANTLRHashString("ADD_PIECE", this), new Integer(50));
	literals.put(new ANTLRHashString("SETUP_PIECE", this), new Integer(51));
	literals.put(new ANTLRHashString("CAPTURED_PIECE_COLOR", this), new Integer(117));
	literals.put(new ANTLRHashString("LOG", this), new Integer(92));
	literals.put(new ANTLRHashString("end_game", this), new Integer(7));
	literals.put(new ANTLRHashString("Play_If_Not", this), new Integer(97));
	literals.put(new ANTLRHashString("MOVE_RANDOMLY_B", this), new Integer(57));
	literals.put(new ANTLRHashString("STR", this), new Integer(90));
	literals.put(new ANTLRHashString("RATIO_POINTS_WB", this), new Integer(115));
	literals.put(new ANTLRHashString("CHECK", this), new Integer(104));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mBLANCO(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mLIT_NUMERO(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mLIT_CADENA(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mCOMEN_LINEA(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mCOMEN_VARIAS(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mOP_DELI(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mOP_SEPA(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mOP_PAR_I(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mOP_PAR_D(true);
					theRetToken=_returnToken;
					break;
				}
				case '@':
				{
					mOP_FIN(true);
					theRetToken=_returnToken;
					break;
				}
				case '-':
				{
					mOP_REST(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mOP_MULT(true);
					theRetToken=_returnToken;
					break;
				}
				case '/':
				{
					mOP_DIVI(true);
					theRetToken=_returnToken;
					break;
				}
				case '^':
				{
					mOP_EXPO(true);
					theRetToken=_returnToken;
					break;
				}
				case '&':
				{
					mOP_AND(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mOP_OR(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mOP_IGUA(true);
					theRetToken=_returnToken;
					break;
				}
				case '>':
				{
					mOP_MAYO(true);
					theRetToken=_returnToken;
					break;
				}
				case '<':
				{
					mOP_MENO(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='f'||LA(1)=='t') && (LA(2)=='a'||LA(2)=='r') && (LA(3)=='l'||LA(3)=='u')) {
						mLIT_BOOL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (LA(2)=='=')) {
						mOP_ASIG(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (LA(2)=='=')) {
						mOP_DESI(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (LA(2)=='+')) {
						mOP_CONCAT(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (true) && (true)) {
						mIDENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (true)) {
						mOP_DECL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='+') && (true)) {
						mOP_SUMA(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (true)) {
						mOP_NOT(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mBLANCO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANCO;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\n':
		{
			match('\n');
			break;
		}
		default:
			if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match("\r\n");
			}
			else if ((LA(1)=='\r') && (true)) {
				match('\r');
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGITO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGITO;
		int _saveIndex;
		
		{
		matchRange('0','9');
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLETRA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LETRA;
		int _saveIndex;
		
		{
		matchRange('a','z');
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDENT;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			mLETRA(false);
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop167:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				mLETRA(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGITO(false);
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			default:
			{
				break _loop167;
			}
			}
		} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLIT_NUMERO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LIT_NUMERO;
		int _saveIndex;
		
		boolean synPredMatched172 = false;
		if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_1.member(LA(2))) && (true))) {
			int _m172 = mark();
			synPredMatched172 = true;
			inputState.guessing++;
			try {
				{
				{
				int _cnt171=0;
				_loop171:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						mDIGITO(false);
					}
					else {
						if ( _cnt171>=1 ) { break _loop171; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt171++;
				} while (true);
				}
				match('.');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched172 = false;
			}
			rewind(_m172);
inputState.guessing--;
		}
		if ( synPredMatched172 ) {
			{
			int _cnt174=0;
			_loop174:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mDIGITO(false);
				}
				else {
					if ( _cnt174>=1 ) { break _loop174; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt174++;
			} while (true);
			}
			match('.');
			{
			_loop176:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mDIGITO(false);
				}
				else {
					break _loop176;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				_ttype = LIT_REAL;
			}
		}
		else if (((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true)) {
			{
			int _cnt178=0;
			_loop178:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mDIGITO(false);
				}
				else {
					if ( _cnt178>=1 ) { break _loop178; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt178++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				_ttype = LIT_ENTERO;
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLIT_CADENA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LIT_CADENA;
		int _saveIndex;
		
		_saveIndex=text.length();
		match('"');
		text.setLength(_saveIndex);
		{
		_loop182:
		do {
			if ((_tokenSet_2.member(LA(1)))) {
				{
				match(_tokenSet_2);
				}
			}
			else {
				break _loop182;
			}
			
		} while (true);
		}
		_saveIndex=text.length();
		match('"');
		text.setLength(_saveIndex);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLIT_BOOL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LIT_BOOL;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 't':
		{
			match("true");
			break;
		}
		case 'f':
		{
			match("false");
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMEN_LINEA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMEN_LINEA;
		int _saveIndex;
		
		match("%");
		{
		_loop187:
		do {
			if ((_tokenSet_3.member(LA(1)))) {
				{
				match(_tokenSet_3);
				}
			}
			else {
				break _loop187;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( inputState.guessing==0 ) {
			System.out.println("comentario de una linea");
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMEN_VARIAS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMEN_VARIAS;
		int _saveIndex;
		
		match('[');
		{
		_loop191:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				{
				match(_tokenSet_4);
				}
			}
			else {
				break _loop191;
			}
			
		} while (true);
		}
		match(']');
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( inputState.guessing==0 ) {
			System.out.println("comentario de varias lineas");
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_ASIG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_ASIG;
		int _saveIndex;
		
		match(":=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_DECL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_DECL;
		int _saveIndex;
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_DELI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_DELI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_SEPA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_SEPA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_PAR_I(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_PAR_I;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_PAR_D(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_PAR_D;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_FIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_FIN;
		int _saveIndex;
		
		match('@');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_SUMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_SUMA;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_REST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_REST;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MULT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MULT;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_DIVI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_DIVI;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_EXPO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_EXPO;
		int _saveIndex;
		
		match('^');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_AND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_AND;
		int _saveIndex;
		
		match("&&");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_OR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_OR;
		int _saveIndex;
		
		if ((LA(1)=='|') && (LA(2)=='|') && (LA(3)==' ')) {
			match("|| ");
		}
		else if ((LA(1)=='|') && (LA(2)=='|') && (LA(3)=='(')) {
			match("||(");
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_NOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_NOT;
		int _saveIndex;
		
		match("!");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_IGUA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_IGUA;
		int _saveIndex;
		
		match("==");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_DESI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_DESI;
		int _saveIndex;
		
		match("!=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MAYO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MAYO;
		int _saveIndex;
		
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MENO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MENO;
		int _saveIndex;
		
		match('<');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_CONCAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_CONCAT;
		int _saveIndex;
		
		match("++");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 0L, 576460745860972544L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 288019269919178752L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=-17179878408L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-9224L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=-8L;
		data[1]=-536870913L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	
	}
