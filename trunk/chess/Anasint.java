// $ANTLR : "Anasint.g" -> "Anasint.java"$

	package chess;
	import java.util.*;
	import java.lang.*;
	import java.io.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

/** Clase Anasint
* realiza el analisis sintactico y semantico
* @author Manuel Cruz Ramrez - Marta Lpez Cceres
*/
public class Anasint extends antlr.LLkParser       implements AnasintTokenTypes
 {

  //zona de declaracion nuestra
  ArrayList listaRes = new ArrayList();
  int contRes = 0; 
  ArrayList<Variable> listaVars = new ArrayList<Variable>();
  int contId = 0;
  ArrayList listaNombres = new ArrayList();
  boolean dentroBucle=false;
  int salirBucle = -1 ;
  Game partida;
  boolean ejecucion;
  int bloqueo;

protected Anasint(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected Anasint(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenStream lexer) {
  this(lexer,3);
}

public Anasint(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

/** regla inicial
* @ -> indica el fin de la ejecucion
*/
	public final void instrucciones() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST instrucciones_AST = null;
		
		try {      // for error handling
			{
			_loop5083:
			do {
				if ((LA(1)==BEGIN_BOARD)) {
					AST tmp1_AST = null;
					tmp1_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp1_AST);
					match(BEGIN_BOARD);
					if ( inputState.guessing==0 ) {
						partida = new Game(); ejecucion = true; bloqueo = 0;
					}
					board_zone();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp2_AST = null;
					tmp2_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp2_AST);
					match(END_BOARD);
					AST tmp3_AST = null;
					tmp3_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp3_AST);
					match(BEGIN_GAME);
					game_zone();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp4_AST = null;
					tmp4_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp4_AST);
					match(END_GAME);
				}
				else {
					break _loop5083;
				}
				
			} while (true);
			}
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(OP_FIN);
			instrucciones_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = instrucciones_AST;
	}
	
	public final void board_zone() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST board_zone_AST = null;
		
		try {      // for error handling
			{
			_loop5087:
			do {
				switch ( LA(1)) {
				case BEGIN_VARIABLES:
				{
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp6_AST);
					match(BEGIN_VARIABLES);
					zona_decl();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp7_AST);
					match(END_VARIABLES);
					break;
				}
				case IDENT:
				case WRT:
				case WAIT:
				case IF:
				case RANDOM_BOARD:
				case ADD_PIECE:
				case SETUP_PIECE:
				case REMOVE_PIECE:
				case GENERATE_3D_BOARD:
				case INIT_FOR:
				case WHILE:
				{
					board_expr();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					break _loop5087;
				}
				}
			} while (true);
			}
			board_zone_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		returnAST = board_zone_AST;
	}
	
	public final void game_zone() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST game_zone_AST = null;
		
		try {      // for error handling
			{
			_loop5091:
			do {
				switch ( LA(1)) {
				case BEGIN_VARIABLES:
				{
					AST tmp8_AST = null;
					tmp8_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp8_AST);
					match(BEGIN_VARIABLES);
					zona_decl();
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp9_AST = null;
					tmp9_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp9_AST);
					match(END_VARIABLES);
					break;
				}
				case IDENT:
				case WRT:
				case WAIT:
				case IF:
				case MOVE_PLAYER_W:
				case MOVE_PLAYER_B:
				case MOVE_RANDOMLY_W:
				case MOVE_RANDOMLY_B:
				case STATE:
				case MOVEMENTS_LIST:
				case STATE_3D:
				case INIT_FOR:
				case WHILE:
				{
					game_expr();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					break _loop5091;
				}
				}
			} while (true);
			}
			game_zone_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = game_zone_AST;
	}
	
/** zona sketch
*/
	public final void board_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST board_expr_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			case WRT:
			case WAIT:
			{
				common_fun();
				astFactory.addASTChild(currentAST, returnAST);
				board_expr_AST = (AST)currentAST.root;
				break;
			}
			case RANDOM_BOARD:
			case ADD_PIECE:
			case SETUP_PIECE:
			case REMOVE_PIECE:
			case GENERATE_3D_BOARD:
			{
				board_fun();
				astFactory.addASTChild(currentAST, returnAST);
				board_expr_AST = (AST)currentAST.root;
				break;
			}
			case INIT_FOR:
			case WHILE:
			{
				buc_ske();
				astFactory.addASTChild(currentAST, returnAST);
				board_expr_AST = (AST)currentAST.root;
				break;
			}
			case IF:
			{
				board_cond();
				astFactory.addASTChild(currentAST, returnAST);
				board_expr_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = board_expr_AST;
	}
	
	public final void common_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST common_fun_AST = null;
		String s1="";
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case WRT:
			{
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(WRT);
				fun_wri();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case WAIT:
			{
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(WAIT);
				if ( inputState.guessing==0 ) {
					
						if (ejecucion) {
						InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br = new BufferedReader (isr);
						try{
					System.out.println("  En PAUSE hasta que pulse ENTER.");
					String texto = br.readLine();
					}catch(Exception e){ e.printStackTrace();}
						}
					
				}
				break;
			}
			default:
				if ((LA(1)==IDENT) && (LA(2)==OP_ASIG) && (_tokenSet_4.member(LA(3)))) {
					asig_entero();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==IDENT) && (LA(2)==OP_ASIG) && (_tokenSet_5.member(LA(3)))) {
					asig_str();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==IDENT) && (LA(2)==OP_ASIG) && (_tokenSet_6.member(LA(3)))) {
					asig_log();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==IDENT) && (LA(2)==OP_ASIG) && (_tokenSet_7.member(LA(3)))) {
					asig_real();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp12_AST = null;
			tmp12_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp12_AST);
			match(OP_DELI);
			common_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = common_fun_AST;
	}
	
	public final void board_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST board_fun_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case RANDOM_BOARD:
			{
				AST tmp13_AST = null;
				tmp13_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp13_AST);
				match(RANDOM_BOARD);
				r_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ADD_PIECE:
			{
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp14_AST);
				match(ADD_PIECE);
				a_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SETUP_PIECE:
			{
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(SETUP_PIECE);
				s_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case REMOVE_PIECE:
			{
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(REMOVE_PIECE);
				r_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case GENERATE_3D_BOARD:
			{
				AST tmp17_AST = null;
				tmp17_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp17_AST);
				match(GENERATE_3D_BOARD);
				g_3_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp18_AST = null;
			tmp18_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp18_AST);
			match(OP_DELI);
			board_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = board_fun_AST;
	}
	
/**bucles zona sketch
*/
	public final void buc_ske() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_ske_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case INIT_FOR:
			{
				buc_for_s();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case WHILE:
			{
				buc_while_s();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			buc_ske_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_ske_AST;
	}
	
/**funciones de la zona sketch
*/
	public final void board_cond() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST board_cond_AST = null;
		boolean b1;
		
		try {      // for error handling
			AST tmp19_AST = null;
			tmp19_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp19_AST);
			match(IF);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
										
			}
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp20_AST);
			match(THEN);
			board_zone();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case ELSE:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(ELSE);
				if ( inputState.guessing==0 ) {
					if (bloqueo == 0) {ejecucion = !ejecucion;}
				}
				board_zone();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case END_IF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp22_AST = null;
			tmp22_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp22_AST);
			match(END_IF);
			if ( inputState.guessing==0 ) {
				if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}
			}
			AST tmp23_AST = null;
			tmp23_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp23_AST);
			match(OP_DELI);
			board_cond_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = board_cond_AST;
	}
	
/**declaraciones en la zona declare
*/
	public final void zona_decl() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST zona_decl_AST = null;
		
		try {      // for error handling
			{
			_loop5094:
			do {
				switch ( LA(1)) {
				case INT:
				{
					declaracion_int();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LOG:
				{
					declaracion_log();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case STR:
				{
					declaracion_str();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case FLO:
				{
					declaracion_flo();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					break _loop5094;
				}
				}
			} while (true);
			}
			zona_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = zona_decl_AST;
	}
	
/** zona transform
*/
	public final void game_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST game_expr_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			case WRT:
			case WAIT:
			{
				common_fun();
				astFactory.addASTChild(currentAST, returnAST);
				game_expr_AST = (AST)currentAST.root;
				break;
			}
			case MOVE_PLAYER_W:
			case MOVE_PLAYER_B:
			case MOVE_RANDOMLY_W:
			case MOVE_RANDOMLY_B:
			case STATE:
			case MOVEMENTS_LIST:
			case STATE_3D:
			{
				game_fun();
				astFactory.addASTChild(currentAST, returnAST);
				game_expr_AST = (AST)currentAST.root;
				break;
			}
			case INIT_FOR:
			case WHILE:
			{
				buc_tran();
				astFactory.addASTChild(currentAST, returnAST);
				game_expr_AST = (AST)currentAST.root;
				break;
			}
			case IF:
			{
				game_cond();
				astFactory.addASTChild(currentAST, returnAST);
				game_expr_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = game_expr_AST;
	}
	
	public final void game_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST game_fun_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case MOVE_PLAYER_W:
			{
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(MOVE_PLAYER_W);
				m_p_w_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_PLAYER_B:
			{
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(MOVE_PLAYER_B);
				m_p_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_RANDOMLY_W:
			{
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(MOVE_RANDOMLY_W);
				m_r_w_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_RANDOMLY_B:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(MOVE_RANDOMLY_B);
				m_r_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STATE:
			{
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(STATE);
				s_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVEMENTS_LIST:
			{
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(MOVEMENTS_LIST);
				m_l_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STATE_3D:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(STATE_3D);
				s_3_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(OP_DELI);
			game_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = game_fun_AST;
	}
	
/**bucles zona transform
*/
	public final void buc_tran() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_tran_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case INIT_FOR:
			{
				buc_for_t();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case WHILE:
			{
				buc_while_t();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			buc_tran_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_tran_AST;
	}
	
/**funciones de la zona de transform
*/
	public final void game_cond() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST game_cond_AST = null;
		boolean b1;
		
		try {      // for error handling
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(IF);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
										
			}
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(THEN);
			game_zone();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case ELSE:
			{
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp34_AST);
				match(ELSE);
				if ( inputState.guessing==0 ) {
					if (bloqueo == 0) {ejecucion = !ejecucion;}
				}
				game_zone();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case END_IF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(END_IF);
			if ( inputState.guessing==0 ) {
				if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}
			}
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(OP_DELI);
			game_cond_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = game_cond_AST;
	}
	
/** declaracion de variables
*/
	public final void declaracion_int() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_int_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		int val = 0, val2 = 0; boolean cons = false, cons2 = false;
		
		try {      // for error handling
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(INT);
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(IDENT);
			{
			switch ( LA(1)) {
			case CNST:
			{
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(CNST);
				if ( inputState.guessing==0 ) {
					cons = true;
				}
				break;
			}
			case OP_ASIG:
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case OP_ASIG:
			{
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp39_AST);
				match(OP_ASIG);
				val=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
						boolean existent = false;
					for (int i = 0; i < listaVars.size(); i++) {
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
							existent = true;
						}
					}
					if (!existent) {
						Variable var = new Variable(Variable.Kind.INT, n1.getText());
						var.setConstant(cons);
						var.setValue("" + val);
						listaVars.add(var);	
					}
				
			}
			{
			_loop5101:
			do {
				if ((LA(1)==OP_SEPA)) {
					AST tmp40_AST = null;
					tmp40_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp40_AST);
					match(OP_SEPA);
					if ( inputState.guessing==0 ) {
						cons2 = false;
					}
					{
					switch ( LA(1)) {
					case CNST:
					{
						AST tmp41_AST = null;
						tmp41_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp41_AST);
						match(CNST);
						if ( inputState.guessing==0 ) {
							cons2 = true;
						}
						break;
					}
					case IDENT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					astFactory.addASTChild(currentAST, n2_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case OP_ASIG:
					{
						AST tmp42_AST = null;
						tmp42_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp42_AST);
						match(OP_ASIG);
						val2=expr_entero();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case OP_SEPA:
					case OP_DELI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						
							boolean existent = false;
							for (int i = 0; i < listaVars.size(); i++) {
								if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
									existent = true;
								}
							}
							if (!existent) {
								Variable var2 = new Variable(Variable.Kind.INT, n2.getText());
								var2.setConstant(cons2);
								var2.setValue("" + val2);
								listaVars.add(var2);	
							}
						
					}
				}
				else {
					break _loop5101;
				}
				
			} while (true);
			}
			AST tmp43_AST = null;
			tmp43_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp43_AST);
			match(OP_DELI);
			declaracion_int_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = declaracion_int_AST;
	}
	
	public final void declaracion_log() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_log_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		boolean val = false, val2 = false; boolean cons = false, cons2 = false;
		
		try {      // for error handling
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(LOG);
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(IDENT);
			{
			switch ( LA(1)) {
			case CNST:
			{
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(CNST);
				if ( inputState.guessing==0 ) {
					cons = true;
				}
				break;
			}
			case OP_ASIG:
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case OP_ASIG:
			{
				AST tmp46_AST = null;
				tmp46_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp46_AST);
				match(OP_ASIG);
				val=expr_logica();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
						boolean existent = false;
					for (int i = 0; i < listaVars.size(); i++) {
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
							existent = true;
						}
					}
					if (!existent) {
						Variable var = new Variable(Variable.Kind.LOG, n1.getText());
						var.setConstant(cons);
						var.setValue("" + val);
						listaVars.add(var);	
					}
				
			}
			{
			_loop5122:
			do {
				if ((LA(1)==OP_SEPA)) {
					AST tmp47_AST = null;
					tmp47_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp47_AST);
					match(OP_SEPA);
					if ( inputState.guessing==0 ) {
						cons2 = false;
					}
					{
					switch ( LA(1)) {
					case CNST:
					{
						AST tmp48_AST = null;
						tmp48_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp48_AST);
						match(CNST);
						if ( inputState.guessing==0 ) {
							cons2 = true;
						}
						break;
					}
					case IDENT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					astFactory.addASTChild(currentAST, n2_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case OP_ASIG:
					{
						AST tmp49_AST = null;
						tmp49_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp49_AST);
						match(OP_ASIG);
						val2=expr_logica();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case OP_SEPA:
					case OP_DELI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						
							boolean existent = false;
							for (int i = 0; i < listaVars.size(); i++) {
								if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
									existent = true;
								}
							}
							if (!existent) {
								Variable var2 = new Variable(Variable.Kind.LOG, n2.getText());
								var2.setConstant(cons2);
								var2.setValue("" + val2);
								listaVars.add(var2);	
							}
						
					}
				}
				else {
					break _loop5122;
				}
				
			} while (true);
			}
			AST tmp50_AST = null;
			tmp50_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp50_AST);
			match(OP_DELI);
			declaracion_log_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = declaracion_log_AST;
	}
	
	public final void declaracion_str() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_str_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		String val = "", val2 = ""; boolean cons = false, cons2 = false;
		
		try {      // for error handling
			AST tmp51_AST = null;
			tmp51_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp51_AST);
			match(STR);
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(IDENT);
			{
			switch ( LA(1)) {
			case CNST:
			{
				AST tmp52_AST = null;
				tmp52_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp52_AST);
				match(CNST);
				if ( inputState.guessing==0 ) {
					cons = true;
				}
				break;
			}
			case OP_ASIG:
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case OP_ASIG:
			{
				AST tmp53_AST = null;
				tmp53_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp53_AST);
				match(OP_ASIG);
				val=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
						boolean existent = false;
					for (int i = 0; i < listaVars.size(); i++) {
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
							existent = true;
						}
					}
					if (!existent) {
						Variable var = new Variable(Variable.Kind.STR, n1.getText());
						var.setConstant(cons);
						var.setValue(val);
						listaVars.add(var);	
					}
				
			}
			{
			_loop5108:
			do {
				if ((LA(1)==OP_SEPA)) {
					AST tmp54_AST = null;
					tmp54_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp54_AST);
					match(OP_SEPA);
					if ( inputState.guessing==0 ) {
						cons2 = false;
					}
					{
					switch ( LA(1)) {
					case CNST:
					{
						AST tmp55_AST = null;
						tmp55_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp55_AST);
						match(CNST);
						if ( inputState.guessing==0 ) {
							cons2 = true;
						}
						break;
					}
					case IDENT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					astFactory.addASTChild(currentAST, n2_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case OP_ASIG:
					{
						AST tmp56_AST = null;
						tmp56_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp56_AST);
						match(OP_ASIG);
						val2=expr_cadena();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case OP_SEPA:
					case OP_DELI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						
							boolean existent = false;
							for (int i = 0; i < listaVars.size(); i++) {
								if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
									existent = true;
								}
							}
							if (!existent) {
								Variable var2 = new Variable(Variable.Kind.STR, n2.getText());
								var2.setConstant(cons2);
								var2.setValue(val2);
								listaVars.add(var2);	
							}
						
					}
				}
				else {
					break _loop5108;
				}
				
			} while (true);
			}
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(OP_DELI);
			declaracion_str_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = declaracion_str_AST;
	}
	
	public final void declaracion_flo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_flo_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		double val = 0, val2 = 0; boolean cons = false, cons2 = false;
		
		try {      // for error handling
			AST tmp58_AST = null;
			tmp58_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp58_AST);
			match(FLO);
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(IDENT);
			{
			switch ( LA(1)) {
			case CNST:
			{
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(CNST);
				if ( inputState.guessing==0 ) {
					cons = true;
				}
				break;
			}
			case OP_ASIG:
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case OP_ASIG:
			{
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(OP_ASIG);
				val=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
						boolean existent = false;
					for (int i = 0; i < listaVars.size(); i++) {
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
							existent = true;
						}
					}
					if (!existent) {
						Variable var = new Variable(Variable.Kind.FLO, n1.getText());
						var.setConstant(cons);
						var.setValue("" + val);
						listaVars.add(var);	
					}
				
			}
			{
			_loop5115:
			do {
				if ((LA(1)==OP_SEPA)) {
					AST tmp61_AST = null;
					tmp61_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp61_AST);
					match(OP_SEPA);
					if ( inputState.guessing==0 ) {
						cons2 = false;
					}
					{
					switch ( LA(1)) {
					case CNST:
					{
						AST tmp62_AST = null;
						tmp62_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp62_AST);
						match(CNST);
						if ( inputState.guessing==0 ) {
							cons2 = true;
						}
						break;
					}
					case IDENT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					astFactory.addASTChild(currentAST, n2_AST);
					match(IDENT);
					if ( inputState.guessing==0 ) {
						val2 = 0;
					}
					{
					switch ( LA(1)) {
					case OP_ASIG:
					{
						AST tmp63_AST = null;
						tmp63_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp63_AST);
						match(OP_ASIG);
						val2=expr_real();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case OP_SEPA:
					case OP_DELI:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						
							boolean existent = false;
							for (int i = 0; i < listaVars.size(); i++) {
								if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
									existent = true;
								}
							}
							if (!existent) {
								Variable var2 = new Variable(Variable.Kind.FLO, n2.getText());
								var2.setConstant(cons2);
								var2.setValue("" + val2);
								listaVars.add(var2);	
							}
						
					}
				}
				else {
					break _loop5115;
				}
				
			} while (true);
			}
			AST tmp64_AST = null;
			tmp64_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp64_AST);
			match(OP_DELI);
			declaracion_flo_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = declaracion_flo_AST;
	}
	
/**expresion para enteros.
* suma
*/
	public final int  expr_entero() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_entero_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			{
			if ((_tokenSet_12.member(LA(1))) && (_tokenSet_13.member(LA(2))) && (_tokenSet_14.member(LA(3)))) {
				i1=expr_e_resta();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = i1;
				}
			}
			else if ((_tokenSet_15.member(LA(1))) && (_tokenSet_13.member(LA(2))) && (_tokenSet_14.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop5177:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp65_AST = null;
					tmp65_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp65_AST);
					match(OP_SUMA);
					i2=expr_e_resta();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+i2;
					}
				}
				else {
					break _loop5177;
				}
				
			} while (true);
			}
			expr_entero_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_16);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_entero_AST;
		return res;
	}
	
/**expresion para cadenas
* concatenacion
*/
	public final String  expr_cadena() throws RecognitionException, TokenStreamException {
		String res="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_cadena_AST = null;
		String s1="", s2="";
		
		try {      // for error handling
			s1=exp_c_conca();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res=s1;
			}
			{
			_loop5235:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp66_AST = null;
					tmp66_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp66_AST);
					match(OP_SUMA);
					s2=exp_c_conca();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+s2;
					}
				}
				else {
					break _loop5235;
				}
				
			} while (true);
			}
			expr_cadena_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_17);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_cadena_AST;
		return res;
	}
	
/**expresion para reales
* suma
*/
	public final double  expr_real() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_real_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			{
			if ((_tokenSet_18.member(LA(1))) && (_tokenSet_19.member(LA(2))) && (_tokenSet_20.member(LA(3)))) {
				e1=expr_r_resta();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res=e1;
				}
			}
			else if ((_tokenSet_21.member(LA(1))) && (_tokenSet_19.member(LA(2))) && (_tokenSet_20.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop5198:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp67_AST = null;
					tmp67_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp67_AST);
					match(OP_SUMA);
					e2=expr_r_resta();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+e2;
					}
				}
				else {
					break _loop5198;
				}
				
			} while (true);
			}
			expr_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_17);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_real_AST;
		return res;
	}
	
/**expresiones logicas
* AND
*/
	public final boolean  expr_logica() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_logica_AST = null;
		boolean b1=false, b2=false;
		
		try {      // for error handling
			b1=expr_b_or();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = b1;
			}
			{
			_loop5217:
			do {
				if ((LA(1)==OP_AND)) {
					AST tmp68_AST = null;
					tmp68_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp68_AST);
					match(OP_AND);
					b2=expr_b_or();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res && b2;
					}
				}
				else {
					break _loop5217;
				}
				
			} while (true);
			}
			expr_logica_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_22);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_logica_AST;
		return res;
	}
	
	public final void asig_entero() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asig_entero_AST = null;
		Token  n = null;
		AST n_AST = null;
		int i1 = 0;
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp69_AST);
			match(OP_ASIG);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
				Variable var = null;
				for(int i=0;i<listaVars.size();i++) 
				{
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
							var = listaVars.get(i);
							break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.INT)
				{
					var.setValue("" + i1);
				}
					}
				
			}
			asig_entero_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = asig_entero_AST;
	}
	
	public final void asig_real() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asig_real_AST = null;
		Token  n = null;
		AST n_AST = null;
		double i1 = 0;
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp70_AST = null;
			tmp70_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp70_AST);
			match(OP_ASIG);
			i1=expr_real();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
				Variable var = null;
				for(int i=0;i<listaVars.size();i++) 
				{
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
							var = listaVars.get(i);
							break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.FLO)
				{
					var.setValue("" + i1);
				}
					}
				
			}
			asig_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = asig_real_AST;
	}
	
	public final void asig_log() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asig_log_AST = null;
		Token  n = null;
		AST n_AST = null;
		boolean i1 = false;
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp71_AST);
			match(OP_ASIG);
			i1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
				Variable var = null;
				for(int i=0;i<listaVars.size();i++) 
				{
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
							var = listaVars.get(i);
							break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.LOG)
				{
					var.setValue("" + i1);
				}
					}
				
			}
			asig_log_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = asig_log_AST;
	}
	
/**expresion para bool
*/
	public final boolean  expr_bool() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_bool_AST = null;
		boolean b1=false;
		
		try {      // for error handling
			{
			if ((_tokenSet_24.member(LA(1))) && (_tokenSet_25.member(LA(2))) && (_tokenSet_26.member(LA(3)))) {
				b1=expr_logica();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_27.member(LA(1))) && (_tokenSet_28.member(LA(2))) && (_tokenSet_29.member(LA(3)))) {
				b1=expr_relac();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expr_bool_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_bool_AST;
		return res;
	}
	
	public final void asig_str() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asig_str_AST = null;
		Token  n = null;
		AST n_AST = null;
		String i1 = "";
		
		try {      // for error handling
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp72_AST);
			match(OP_ASIG);
			i1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
				Variable var = null;
				for(int i=0;i<listaVars.size();i++) 
				{
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
							var = listaVars.get(i);
							break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.STR)
				{
					var.setValue(i1);
				}
					}
				
			}
			asig_str_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = asig_str_AST;
	}
	
/**funcion WRITE (expresion)
* Escribe el valor de la expresin expresion en pantalla en
* una nueva lnea.
*/
	public final void fun_wri() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fun_wri_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp73_AST = null;
			tmp73_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp73_AST);
			match(OP_PAR_I);
			s1=expresion();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp74_AST = null;
			tmp74_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp74_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					  	  		 System.out.println("  WRITE -> " + s1);
					  	  	}
				
			}
			fun_wri_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_wri_AST;
	}
	
/**funcion SKETCH_WIDTH()
* Devuelve un flotante indicando la dimensin en X del croquis.
*/
	public final boolean  check_fun() throws RecognitionException, TokenStreamException {
		boolean valor=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST check_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp75_AST = null;
			tmp75_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp75_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp76_AST = null;
			tmp76_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp76_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
						valor = partida.check(s1);
					}
				
			}
			check_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = check_fun_AST;
		return valor;
	}
	
	public final boolean  checkmate_fun() throws RecognitionException, TokenStreamException {
		boolean valor=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST checkmate_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
					valor = partida.checkMate(s1);
					}
				
			}
			checkmate_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = checkmate_fun_AST;
		return valor;
	}
	
/**funcion SKETCH_DEPTH()
* Devuelve un flotante indicando la dimensin en Z del croquis.
*/
	public final boolean  stalemate_fun() throws RecognitionException, TokenStreamException {
		boolean valor=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stalemate_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					valor = partida.staleMate(s1);
					}
				
			}
			stalemate_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = stalemate_fun_AST;
		return valor;
	}
	
/**funcion EXIST(expr_ent)
* Devuelve TRUE si existe la instancia de identidad especificada
* por la expresin entera expr_ent y FALSE en caso contrario.
*/
	public final String  piece_type_fun() throws RecognitionException, TokenStreamException {
		String res = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST piece_type_fun_AST = null;
		int i1; String s1;
		
		try {      // for error handling
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp81_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					res = partida.pieceType(s1,i1);
					  	}
				
			}
			piece_type_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = piece_type_fun_AST;
		return res;
	}
	
/**funcion GET_NAME(expr_ent)
* Devuelve el nombre del objeto 3D correspondiente a la instancia
* cuya identidad es especificada en la expresin entera expr_ent.
* En caso de no existir tal objeto, devuelve la CADENA NULA.
*/
	public final String  piece_color_fun() throws RecognitionException, TokenStreamException {
		String res = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST piece_color_fun_AST = null;
		int i1; String s1;
		
		try {      // for error handling
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					res = partida.pieceColor(s1,i1);
					  	  	}
				
			}
			piece_color_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = piece_color_fun_AST;
		return res;
	}
	
/** funcion GET_3DFILE(expr_cad)
* Devuelve la cadena de caracteres correspondiente al fichero
* X3D/VRML asociado al objeto 3D cuyo nombre es especificado
* en la expresin de cadena de caracteres expr_cad. En caso de no
* existir tal objeto, devuelve la CADENA NULA.
*/
	public final int  points_fun() throws RecognitionException, TokenStreamException {
		int ret = 0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST points_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
				ret = partida.points(s1);
					  	  	}
				
			}
			points_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		returnAST = points_fun_AST;
		return ret;
	}
	
/**funcion GET_2DTYPE(expr_cad)
* Devuelve la cadena de caracteres correspondiente al tipo de
* representante 2D (P: punto, S: segmento y C: crculo)
* asociado al objeto 3D cuyo nombre es especificado en la
* expresin de cadena de caracteres expr_cad. En caso de no existir
* tal objeto, devuelve la CADENA NULA.
*/
	public final String  c_o_last_mov_fun() throws RecognitionException, TokenStreamException {
		String c = "";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST c_o_last_mov_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					c = partida.cOLastMov(s1);
					  	  	}
				
			}
			c_o_last_mov_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = c_o_last_mov_fun_AST;
		return c;
	}
	
/** funcion X_P_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del punto representante 2D de la instancia 3D cuya
* identidad queda especificada por la expresin entera expr_ent.
*/
	public final int  f_o_last_mov_fun() throws RecognitionException, TokenStreamException {
		int valor = 0;;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST f_o_last_mov_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					valor = partida.fOLastMov(s1);
					  	  	}
				
			}
			f_o_last_mov_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		returnAST = f_o_last_mov_fun_AST;
		return valor;
	}
	
/**funcion GET_2DTYPE(expr_cad)
* Devuelve la cadena de caracteres correspondiente al tipo de
* representante 2D (P: punto, S: segmento y C: crculo)
* asociado al objeto 3D cuyo nombre es especificado en la
* expresin de cadena de caracteres expr_cad. En caso de no existir
* tal objeto, devuelve la CADENA NULA.
*/
	public final String  c_d_last_mov_fun() throws RecognitionException, TokenStreamException {
		String c = "";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST c_d_last_mov_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					c = partida.cDLastMov(s1);
					  	  	}
				
			}
			c_d_last_mov_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = c_d_last_mov_fun_AST;
		return c;
	}
	
/** funcion X_P_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del punto representante 2D de la instancia 3D cuya
* identidad queda especificada por la expresin entera expr_ent.
*/
	public final int  f_d_last_mov_fun() throws RecognitionException, TokenStreamException {
		int valor = 0;;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST f_d_last_mov_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp96_AST = null;
			tmp96_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp96_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					valor = partida.fDLastMov(s1);
					  	  	}
				
			}
			f_d_last_mov_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		returnAST = f_d_last_mov_fun_AST;
		return valor;
	}
	
/**funcion Y_P_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada Y del punto representante 2D de la instancia 3D cuya
* identidad queda especificada por la expresin entera expr_ent.
*/
	public final double  ratio_wb_fun() throws RecognitionException, TokenStreamException {
		double ret = 0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ratio_wb_fun_AST = null;
		
		try {      // for error handling
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
			match(OP_PAR_I);
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
				ret = partida.ratioWB();
					  	  	}
				
			}
			ratio_wb_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		returnAST = ratio_wb_fun_AST;
		return ret;
	}
	
	public final double  ratio_points_wb_fun() throws RecognitionException, TokenStreamException {
		double ret = 0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ratio_points_wb_fun_AST = null;
		
		try {      // for error handling
			AST tmp99_AST = null;
			tmp99_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp99_AST);
			match(OP_PAR_I);
			AST tmp100_AST = null;
			tmp100_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp100_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
				ret = partida.ratioPointsWB();
					  	  	}
				
			}
			ratio_points_wb_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		returnAST = ratio_points_wb_fun_AST;
		return ret;
	}
	
	public final String  captured_piece_type_fun() throws RecognitionException, TokenStreamException {
		String res = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST captured_piece_type_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp101_AST = null;
			tmp101_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp101_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					res = partida.capturedPieceType(s1);
					  	  	}
				
			}
			captured_piece_type_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = captured_piece_type_fun_AST;
		return res;
	}
	
	public final String  captured_piece_color_fun() throws RecognitionException, TokenStreamException {
		String res = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST captured_piece_color_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					res = partida.capturedPieceColor(s1);
					  	  	}
				
			}
			captured_piece_color_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = captured_piece_color_fun_AST;
		return res;
	}
	
	public final boolean  castling_fun() throws RecognitionException, TokenStreamException {
		boolean valor = false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST castling_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp106_AST = null;
			tmp106_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp106_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					valor = partida.castling(s1);
					  	  	}
				
			}
			castling_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = castling_fun_AST;
		return valor;
	}
	
/**funcion READ_INTEGER()
* Lee un entero de teclado y lo devuelve.
*/
	public final int  fun_r_entero() throws RecognitionException, TokenStreamException {
		int valor=-1;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fun_r_entero_AST = null;
		
		try {      // for error handling
			AST tmp107_AST = null;
			tmp107_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp107_AST);
			match(OP_PAR_I);
			AST tmp108_AST = null;
			tmp108_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp108_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					  	  		 InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader (isr);
					try{
					  System.out.println("  READ_INTEGER -> Introduzca un valor entero.");	
				int num = Integer.parseInt(br.readLine());
				valor=num;
				System.out.println("  READ_INTEGER -> El valor entero ledo es: " + valor);
				}catch(Exception e){ e.printStackTrace();}
					  	  	}
				
			}
			fun_r_entero_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_r_entero_AST;
		return valor;
	}
	
/**funcion READ_DOUBLE()
* Lee un flotante de teclado y lo devuelve.
*/
	public final double  fun_r_real() throws RecognitionException, TokenStreamException {
		double valor=-1.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fun_r_real_AST = null;
		
		try {      // for error handling
			AST tmp109_AST = null;
			tmp109_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp109_AST);
			match(OP_PAR_I);
			AST tmp110_AST = null;
			tmp110_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp110_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					  	  			InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader (isr);
					try{
					  System.out.println("  READ_DOUBLE -> Introduzca un valor real.");		
				double num = Double.parseDouble(br.readLine());
				valor=num;
				System.out.println("  READ_DOUBLE -> El valor real ledo es: " + valor);
				}catch(Exception e){ e.printStackTrace();}
					  	  	}
				
			}
			fun_r_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_r_real_AST;
		return valor;
	}
	
/**funcion READ_BOOL ()
* Lee un booleano de teclado y lo devuelve (TRUE o FALSE).
*/
	public final boolean  fun_r_bool() throws RecognitionException, TokenStreamException {
		boolean valor=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fun_r_bool_AST = null;
		
		try {      // for error handling
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp111_AST);
			match(OP_PAR_I);
			AST tmp112_AST = null;
			tmp112_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp112_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					  	  			InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader (isr);
					try{
					  System.out.println("  READ_BOOL -> Introduzca un valor booleano.");	
				boolean val = Boolean.parseBoolean(br.readLine().toLowerCase());
				valor=val;
				System.out.println("  READ_BOOL -> El valor booleano ledo es: " + valor);
				}catch(Exception e){ e.printStackTrace();}
					  	  	}
				
			}
			fun_r_bool_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_r_bool_AST;
		return valor;
	}
	
/**funcion READ_STRING()
* Lee una cadena de teclado y la devuelve.
*/
	public final String  fun_r_cadena() throws RecognitionException, TokenStreamException {
		String valor="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fun_r_cadena_AST = null;
		
		try {      // for error handling
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp113_AST);
			match(OP_PAR_I);
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
						InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader (isr);
					try{
					  System.out.println("  READ_STRING -> Introduzca una cadena.");	
				String texto = br.readLine();
				valor=texto;
				System.out.println("  READ_STRING -> La cadena leda es: " + valor);
				}catch(Exception e){ e.printStackTrace();}
					  	  	}
				
			}
			fun_r_cadena_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_r_cadena_AST;
		return valor;
	}
	
/**expresiones 
*/
	public final String  expresion() throws RecognitionException, TokenStreamException {
		String res=null;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expresion_AST = null;
		int i1; double e1; String s1; boolean b1;
		
		try {      // for error handling
			{
			if ((_tokenSet_34.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_36.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = String.valueOf(i1);
				}
			}
			else if ((_tokenSet_37.member(LA(1))) && (_tokenSet_38.member(LA(2))) && (_tokenSet_39.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = String.valueOf(e1);
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_PAR_D||LA(2)==OP_SUMA) && (_tokenSet_40.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = s1;
				}
			}
			else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_41.member(LA(2))) && (_tokenSet_42.member(LA(3)))) {
				b1=expr_bool();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = String.valueOf(b1);
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expresion_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_43);
			} else {
			  throw ex;
			}
		}
		returnAST = expresion_AST;
		return res;
	}
	
/**funcion SKETCH_SURFACE (expr_flot1, expr_flot2)
* La superficie XZ sobre la que se ubicarn las instancias de los
* objetos 3D del croquis ser por defecto de 50x50 m. Estar
* representada por un paraleleppedo (Box) de altura (Y) 1 m,
* cuya base superior tendr los vrtices en las siguientes
* ubicaciones: (0,0,0), (0,0,50), (50,0,0) y (50,0,50).
*
* La invocacin de esta orden permitir modificar sus
* dimensiones (sin modificar su orientacin y manteniendo un
* vrtice de la base superior en el origen de coordenadas)
* aadiendo el resultado de la expresin flotante expr_flot1 a la
* dimensin en X y aadiendo el resultado de la expresin
* expr_flot2 a la dimensin en Z. La superficie del croquis
* podr aumentar o disminuir sus dimensiones siempre y
* cuando no queden fuera de la nueva superficie los
* representantes 2D de las instancias de objetos 3D que se
* encuentren presentes en la antigua superficie.
*/
	public final void r_b_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST r_b_fun_AST = null;
		double prop = 1; String disp; int num_pics;
		
		try {      // for error handling
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
			match(OP_PAR_I);
			num_pics=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==OP_SEPA) && (_tokenSet_44.member(LA(2))) && (_tokenSet_45.member(LA(3)))) {
				AST tmp116_AST = null;
				tmp116_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp116_AST);
				match(OP_SEPA);
				prop=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==OP_SEPA) && (_tokenSet_5.member(LA(2))) && (LA(3)==OP_PAR_I||LA(3)==OP_PAR_D||LA(3)==OP_SUMA)) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp117_AST);
			match(OP_SEPA);
			disp=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					partida.random(num_pics, prop, disp);
					  	  	}
				
			}
			r_b_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = r_b_fun_AST;
	}
	
/**funcion OBJECT_3D (expr_cad1, expr_cad2)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un punto.
*
* OBJECT_3D (expr_cad1, expr_cad2, exp_fl1, exp_fl2)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un segmento. La
* longitud y orientacin de tal segmento la define como punto
* medio el origen de coordenadas (0,0,0) y como uno de los
* extremos, incluido en el croquis, las coordenadas (c1, c2),
* siendo c1 (eje X) el resultado de evaluar la expresin flotante
* expr_fl1 y siendo c2 (eje Z) el resultado de evaluar la
* expresin flotante expr_fl2.
*
* OBJECT_3D (expr_cad1, expr_cad2, exp_fl)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un crculo cuyo radio
* vendr determinado por el resultado de la expresin flotante
* exp_fl.
*/
	public final void a_p_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST a_p_fun_AST = null;
		String s1="",s2="", s3=""; int e1=1;
		
		try {      // for error handling
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp119_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp120_AST = null;
			tmp120_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp120_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp121_AST = null;
			tmp121_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp121_AST);
			match(OP_SEPA);
			s3=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp122_AST);
			match(OP_SEPA);
			e1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp123_AST = null;
			tmp123_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp123_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
				partida.addPiece(s1,s2,s3,e1);
					  	  	}
				
			}
			a_p_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = a_p_fun_AST;
	}
	
/**funcion INSTANCE (expr_ent1, expr_cad, expr_fl1, expr_fl2)
* Crea una instancia de un objeto cuya identidad queda
* especificada en la expresin entera expr_ent1 (la identidad
* ser un nmero natural nico para todas las instancias de
* objetos 3D). La instancia corresponder al objeto 3D cuyo
* nombre es resultado de la expresin de cadenas de caracteres
* expr_cad. El representante 2D de la instancia vendr definido
* por el punto de coordenadas (c1, c2), siendo c1 (eje X) el
* resultado de evaluar la expresin flotante expr_fl1 y siendo c2
* (eje Z) el resultado de evaluar la expresin flotante expr_fl2.
* Si el objeto 3D es de tipo punto, (c1, c2) ser tal
* representante; si es de tipo segmento, (c1, c2) corresponder
* al punto medio del segmento; si es de tipo crculo, (c1, c2) ser
* el centro del crculo. La instancia ser ubicada sobre el
* croquis en esta localizacin.
*/
	public final void s_p_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST s_p_fun_AST = null;
		int i1, i2; String s1, s2;
		
		try {      // for error handling
			AST tmp124_AST = null;
			tmp124_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp124_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp125_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp126_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp127_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp128_AST = null;
			tmp128_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp128_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
				partida.setupPiece(s1,i1,s2,i2);
					  	  	}
				
			}
			s_p_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = s_p_fun_AST;
	}
	
/**funcion DISTANCE (exp_ent1, exp_ent2)
* Crea una restriccin geomtrica de distancia entre dos
* instancias cuya identidad viene representada respectivamente
* como el resultado de la evaluacin de las expresiones enteras
* exp_ent1 y exp_ent2 (la identidad ser un nmero natural
* nico para todas las restricciones geomtricas). El valor
* inicial de esta restriccin geomtrica ser el de la distancia
* eucldea entre los representantes 2D de las instancias
* correspondientes. Devuelve un identificador entero nico
* para la restriccin geomtrica creada.
*/
	public final void r_p_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST r_p_fun_AST = null;
		int i1 = -1; String s1, s2 = "";
		
		try {      // for error handling
			AST tmp129_AST = null;
			tmp129_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp129_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==OP_SEPA) && (_tokenSet_34.member(LA(2))) && (_tokenSet_35.member(LA(3)))) {
				AST tmp130_AST = null;
				tmp130_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp130_AST);
				match(OP_SEPA);
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==OP_SEPA) && (_tokenSet_5.member(LA(2))) && (LA(3)==OP_PAR_I||LA(3)==OP_PAR_D||LA(3)==OP_SUMA)) {
				AST tmp131_AST = null;
				tmp131_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp131_AST);
				match(OP_SEPA);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			AST tmp132_AST = null;
			tmp132_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp132_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					
					  	  	if (ejecucion) {
					if (i1 == -1) {
						partida.removePiece(s1,s2);
					} else {
						partida.removePiece(s1,i1);
					}
					  	  	}
				
			}
			r_p_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = r_p_fun_AST;
	}
	
/**funcion ANGLE (exp_ent1, exp_ent2)
* Crea una restriccin geomtrica de ngulo entre dos
* instancias cuya identidad viene representada respectivamente
* como el resultado de la evaluacin de las expresiones enteras
* exp_ent1 y exp_ent2 (la identidad ser un nmero natural
* nico para todas las restricciones geomtricas). El valor
* inicial de esta restriccin geomtrica ser el del ngulo entre
* los representantes 2D de las instancias correspondientes.
* Devuelve un identificador entero nico para la restriccin
* geomtrica creada.
*/
	public final void g_3_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST g_3_fun_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp133_AST = null;
			tmp133_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp133_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp134_AST = null;
			tmp134_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp134_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					try{
						 	partida.generate3D(s1);
						} catch (IOException e) {
							e.printStackTrace();	
						}
					  	  	}
				
			}
			g_3_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = g_3_fun_AST;
	}
	
	public final void m_p_w_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST m_p_w_fun_AST = null;
		int i1, i2; String s1, s2;
		
		try {      // for error handling
			AST tmp135_AST = null;
			tmp135_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp135_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp136_AST = null;
			tmp136_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp136_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp137_AST = null;
			tmp137_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp137_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp138_AST = null;
			tmp138_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp138_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp139_AST = null;
			tmp139_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp139_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					if (ejecucion) {
				partida.movePlayerW(s1,i1,s2,i2);
					}
				
			}
			m_p_w_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = m_p_w_fun_AST;
	}
	
	public final void m_p_b_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST m_p_b_fun_AST = null;
		int i1, i2; String s1, s2;
		
		try {      // for error handling
			AST tmp140_AST = null;
			tmp140_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp140_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp141_AST = null;
			tmp141_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp141_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp142_AST = null;
			tmp142_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp142_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp143_AST = null;
			tmp143_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp143_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp144_AST = null;
			tmp144_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp144_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
				partida.movePlayerB(s1,i1,s2,i2);
					  	}
				
			}
			m_p_b_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = m_p_b_fun_AST;
	}
	
	public final void m_r_w_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST m_r_w_fun_AST = null;
		
		try {      // for error handling
			AST tmp145_AST = null;
			tmp145_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp145_AST);
			match(OP_PAR_I);
			AST tmp146_AST = null;
			tmp146_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp146_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
				partida.moveRandomlyW();
					  	}
				
			}
			m_r_w_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = m_r_w_fun_AST;
	}
	
	public final void m_r_b_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST m_r_b_fun_AST = null;
		
		try {      // for error handling
			AST tmp147_AST = null;
			tmp147_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp147_AST);
			match(OP_PAR_I);
			AST tmp148_AST = null;
			tmp148_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp148_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
				partida.moveRandomlyB();
					  	}
				
			}
			m_r_b_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = m_r_b_fun_AST;
	}
	
	public final void s_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST s_fun_AST = null;
		String s1 = null;
		
		try {      // for error handling
			AST tmp149_AST = null;
			tmp149_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp149_AST);
			match(OP_PAR_I);
			{
			switch ( LA(1)) {
			case IDENT:
			case LIT_CADENA:
			case PIECE_TYPE:
			case PIECE_COLOR:
			case CAPTURED_PIECE_TYPE:
			case CAPTURED_PIECE_COLOR:
			case READ_STR:
			case C_D_LAST_MOV:
			case C_O_LAST_MOV:
			{
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case OP_PAR_D:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp150_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
					partida.state(s1);
					  	}
				
			}
			s_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = s_fun_AST;
	}
	
	public final void m_l_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST m_l_fun_AST = null;
		
		try {      // for error handling
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp151_AST);
			match(OP_PAR_I);
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
				partida.movementsList();
					  	}
				
			}
			m_l_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = m_l_fun_AST;
	}
	
	public final void s_3_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST s_3_fun_AST = null;
		String s1 = "./3D/";
		
		try {      // for error handling
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp153_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp154_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	if (ejecucion) {
				
					try{
						  	partida.state3D(s1);
						} catch (IOException e) {
							e.printStackTrace();	
						}
					  	}
				
			}
			s_3_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_23);
			} else {
			  throw ex;
			}
		}
		returnAST = s_3_fun_AST;
	}
	
/** resta enteros
*/
	public final int  expr_e_resta() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_e_resta_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case IDENT:
			case OP_PAR_I:
			case LIT_ENTERO:
			case READ_NUMBER:
			case POINTS:
			case F_O_LAST_MOV:
			case F_D_LAST_MOV:
			{
				i1=exp_e_mult();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = i1;
				}
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			case OP_PAR_D:
			case THEN:
			case OP_SUMA:
			case OP_REST:
			case OP_IGUA:
			case OP_DESI:
			case OP_MAYO:
			case OP_MENO:
			case F_UNTIL:
			case F_DO:
			case DO:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop5181:
			do {
				if ((LA(1)==OP_REST)) {
					AST tmp155_AST = null;
					tmp155_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp155_AST);
					match(OP_REST);
					i2=exp_e_mult();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res-i2;
					}
				}
				else {
					break _loop5181;
				}
				
			} while (true);
			}
			expr_e_resta_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_e_resta_AST;
		return res;
	}
	
/** multiplicacion enteros
*/
	public final int  exp_e_mult() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_e_mult_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			i1=exp_e_divi();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = i1;
			}
			{
			_loop5184:
			do {
				if ((LA(1)==OP_MULT)) {
					AST tmp156_AST = null;
					tmp156_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp156_AST);
					match(OP_MULT);
					i2=exp_e_divi();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res*i2;
					}
				}
				else {
					break _loop5184;
				}
				
			} while (true);
			}
			exp_e_mult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_46);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_e_mult_AST;
		return res;
	}
	
/** division enteros
*/
	public final int  exp_e_divi() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_e_divi_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			i1=exp_e_modu();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = i1;
			}
			{
			_loop5187:
			do {
				if ((LA(1)==OP_DIVI)) {
					AST tmp157_AST = null;
					tmp157_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp157_AST);
					match(OP_DIVI);
					i2=exp_e_modu();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						if(i2==0)
						throw new ArithmeticException("      Divisin por cero.");
						else
						res=res/i2;
					}
				}
				else {
					break _loop5187;
				}
				
			} while (true);
			}
			exp_e_divi_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_47);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_e_divi_AST;
		return res;
	}
	
/** modulo enteros
*/
	public final int  exp_e_modu() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_e_modu_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			i1=exp_e_pot();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = i1;
			}
			{
			_loop5190:
			do {
				if ((LA(1)==MOD)) {
					AST tmp158_AST = null;
					tmp158_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp158_AST);
					match(MOD);
					i2=exp_e_pot();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res%i2;
					}
				}
				else {
					break _loop5190;
				}
				
			} while (true);
			}
			exp_e_modu_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_48);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_e_modu_AST;
		return res;
	}
	
/** potencia enteros
*/
	public final int  exp_e_pot() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_e_pot_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			i1=exp_e_base();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = i1;
			}
			{
			_loop5193:
			do {
				if ((LA(1)==OP_EXPO)) {
					AST tmp159_AST = null;
					tmp159_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp159_AST);
					match(OP_EXPO);
					i2=exp_e_base();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=(int)Math.pow(res,i2);
					}
				}
				else {
					break _loop5193;
				}
				
			} while (true);
			}
			exp_e_pot_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_49);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_e_pot_AST;
		return res;
	}
	
/** expresion base enteros
*/
	public final int  exp_e_base() throws RecognitionException, TokenStreamException {
		int res=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_e_base_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		int i1=0;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LIT_ENTERO:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LIT_ENTERO);
				if ( inputState.guessing==0 ) {
					res= new Integer (n.getText()).intValue();
				}
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case OP_PAR_I:
			{
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp160_AST);
				match(OP_PAR_I);
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp161_AST = null;
				tmp161_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp161_AST);
				match(OP_PAR_D);
				if ( inputState.guessing==0 ) {
					res = i1;
				}
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			{
				n1 = LT(1);
				n1_AST = astFactory.create(n1);
				astFactory.addASTChild(currentAST, n1_AST);
				match(IDENT);
				if ( inputState.guessing==0 ) {
					
						
					if (ejecucion) {
					Variable var = null;
					for(int i=0;i<listaVars.size();i++) 
					{
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
								var = listaVars.get(i);
								break;
						}	
					}
					if(var != null && var.getKind() == Variable.Kind.INT)
					{
						res = Integer.parseInt(var.getValue());
					}
						}
					
				}
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case READ_NUMBER:
			{
				AST tmp162_AST = null;
				tmp162_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp162_AST);
				match(READ_NUMBER);
				res=fun_r_entero();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case POINTS:
			{
				AST tmp163_AST = null;
				tmp163_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp163_AST);
				match(POINTS);
				res=points_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case F_O_LAST_MOV:
			{
				AST tmp164_AST = null;
				tmp164_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp164_AST);
				match(F_O_LAST_MOV);
				res=f_o_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case F_D_LAST_MOV:
			{
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp165_AST);
				match(F_D_LAST_MOV);
				res=f_d_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_32);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_e_base_AST;
		return res;
	}
	
/** resta reales
*/
	public final double  expr_r_resta() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_r_resta_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case IDENT:
			case OP_PAR_I:
			case LIT_REAL:
			case R_REAL:
			case RATIO_WB:
			case RATIO_POINTS_WB:
			{
				e1=exp_r_mult();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = e1;
				}
				break;
			}
			case OP_SEPA:
			case OP_DELI:
			case OP_PAR_D:
			case THEN:
			case OP_SUMA:
			case OP_REST:
			case OP_IGUA:
			case OP_DESI:
			case OP_MAYO:
			case OP_MENO:
			case DO:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop5202:
			do {
				if ((LA(1)==OP_REST)) {
					AST tmp166_AST = null;
					tmp166_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp166_AST);
					match(OP_REST);
					e2=exp_r_mult();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res-e2;
					}
				}
				else {
					break _loop5202;
				}
				
			} while (true);
			}
			expr_r_resta_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_r_resta_AST;
		return res;
	}
	
/** multiplicacion reales
*/
	public final double  exp_r_mult() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_r_mult_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			e1=exp_r_divi();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = e1;
			}
			{
			_loop5205:
			do {
				if ((LA(1)==OP_MULT)) {
					AST tmp167_AST = null;
					tmp167_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(OP_MULT);
					e2=exp_r_divi();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res*e2;
					}
				}
				else {
					break _loop5205;
				}
				
			} while (true);
			}
			exp_r_mult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_50);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_r_mult_AST;
		return res;
	}
	
/** division reales
*/
	public final double  exp_r_divi() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_r_divi_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			e1=exp_r_pot();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = e1;
			}
			{
			_loop5208:
			do {
				if ((LA(1)==OP_DIVI)) {
					AST tmp168_AST = null;
					tmp168_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp168_AST);
					match(OP_DIVI);
					e2=exp_r_pot();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						if(e2==0.0)
						throw new ArithmeticException("      Divisin por cero.");
						else
						res=res/e2;
					}
				}
				else {
					break _loop5208;
				}
				
			} while (true);
			}
			exp_r_divi_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_51);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_r_divi_AST;
		return res;
	}
	
/** potencia reales
*/
	public final double  exp_r_pot() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_r_pot_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			e1=exp_r_base();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = e1;
			}
			{
			_loop5211:
			do {
				if ((LA(1)==OP_EXPO)) {
					AST tmp169_AST = null;
					tmp169_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp169_AST);
					match(OP_EXPO);
					e2=exp_r_base();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=(double)Math.pow(res,e2);
					}
				}
				else {
					break _loop5211;
				}
				
			} while (true);
			}
			exp_r_pot_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_52);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_r_pot_AST;
		return res;
	}
	
/** expresion base reales
*/
	public final double  exp_r_base() throws RecognitionException, TokenStreamException {
		double res=0.;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_r_base_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		double e1=0.;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LIT_REAL:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LIT_REAL);
				if ( inputState.guessing==0 ) {
					res= new Double (n.getText()).doubleValue();
				}
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case OP_PAR_I:
			{
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
				match(OP_PAR_I);
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp171_AST);
				match(OP_PAR_D);
				if ( inputState.guessing==0 ) {
					res = e1;
				}
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			{
				n1 = LT(1);
				n1_AST = astFactory.create(n1);
				astFactory.addASTChild(currentAST, n1_AST);
				match(IDENT);
				if ( inputState.guessing==0 ) {
					
						
					if (ejecucion) {
					Variable var = null;
					for(int i=0;i<listaVars.size();i++) 
					{
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
								var = listaVars.get(i);
								break;
						}	
					}
					if(var != null && var.getKind() == Variable.Kind.FLO)
					{
						res = Double.parseDouble(var.getValue());
					}
						}
					
				}
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case R_REAL:
			{
				AST tmp172_AST = null;
				tmp172_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp172_AST);
				match(R_REAL);
				res=fun_r_real();
				astFactory.addASTChild(currentAST, returnAST);
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case RATIO_WB:
			{
				AST tmp173_AST = null;
				tmp173_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp173_AST);
				match(RATIO_WB);
				res=ratio_wb_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case RATIO_POINTS_WB:
			{
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp174_AST);
				match(RATIO_POINTS_WB);
				res=ratio_points_wb_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_33);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_r_base_AST;
		return res;
	}
	
/**expresiones relacionales
*/
	public final boolean  expr_relac() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_relac_AST = null;
		boolean b1=false;
		
		try {      // for error handling
			{
			if ((_tokenSet_53.member(LA(1))) && (_tokenSet_54.member(LA(2))) && (_tokenSet_55.member(LA(3)))) {
				b1=relac_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_56.member(LA(1))) && (_tokenSet_57.member(LA(2))) && (_tokenSet_58.member(LA(3)))) {
				b1=relac_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (_tokenSet_59.member(LA(2))) && (_tokenSet_60.member(LA(3)))) {
				b1=relac_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expr_relac_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_relac_AST;
		return res;
	}
	
/** OR logico
*/
	public final boolean  expr_b_or() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_b_or_AST = null;
		boolean b1=false, b2=false;
		
		try {      // for error handling
			b1=expr_b_not();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				res = b1;
			}
			{
			_loop5220:
			do {
				if ((LA(1)==OP_OR)) {
					AST tmp175_AST = null;
					tmp175_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp175_AST);
					match(OP_OR);
					b2=expr_b_not();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res || b2;
					}
				}
				else {
					break _loop5220;
				}
				
			} while (true);
			}
			expr_b_or_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_61);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_b_or_AST;
		return res;
	}
	
/** NOT logico
*/
	public final boolean  expr_b_not() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_b_not_AST = null;
		boolean b1=false;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_NOT:
			{
				AST tmp176_AST = null;
				tmp176_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp176_AST);
				match(OP_NOT);
				b1=expr_b_base();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = !b1;
				}
				expr_b_not_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			case OP_PAR_I:
			case LIT_BOOL:
			case CHECK:
			case CHECKMATE:
			case STALEMATE:
			case CASTLING:
			case R_BOOL:
			{
				b1=expr_b_base();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
				expr_b_not_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_b_not_AST;
		return res;
	}
	
/** expresion base booleanos
*/
	public final boolean  expr_b_base() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_b_base_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		boolean b1=false;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LIT_BOOL:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LIT_BOOL);
				if ( inputState.guessing==0 ) {
					res = Boolean.parseBoolean(n.getText().toLowerCase());
				}
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case OP_PAR_I:
			{
				AST tmp177_AST = null;
				tmp177_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp177_AST);
				match(OP_PAR_I);
				b1=expr_bool();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp178_AST = null;
				tmp178_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp178_AST);
				match(OP_PAR_D);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			{
				n1 = LT(1);
				n1_AST = astFactory.create(n1);
				astFactory.addASTChild(currentAST, n1_AST);
				match(IDENT);
				if ( inputState.guessing==0 ) {
					
						
					if (ejecucion) {
					Variable var = null;
					for(int i=0;i<listaVars.size();i++) 
					{
						if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
								var = listaVars.get(i);
								break;
						}	
					}
					if(var != null && var.getKind() == Variable.Kind.LOG)
					{
						res = Boolean.parseBoolean(var.getValue());
					}
						}
					
				}
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CHECK:
			{
				AST tmp179_AST = null;
				tmp179_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp179_AST);
				match(CHECK);
				res=check_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CHECKMATE:
			{
				AST tmp180_AST = null;
				tmp180_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp180_AST);
				match(CHECKMATE);
				res=checkmate_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case STALEMATE:
			{
				AST tmp181_AST = null;
				tmp181_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp181_AST);
				match(STALEMATE);
				res=stalemate_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CASTLING:
			{
				AST tmp182_AST = null;
				tmp182_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp182_AST);
				match(CASTLING);
				res=castling_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case R_BOOL:
			{
				AST tmp183_AST = null;
				tmp183_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp183_AST);
				match(R_BOOL);
				res=fun_r_bool();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_31);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_b_base_AST;
		return res;
	}
	
/**expresiones relacionales enteros
*/
	public final boolean  relac_entero() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relac_entero_AST = null;
		int i1=0, i2=0;
		
		try {      // for error handling
			{
			if ((_tokenSet_62.member(LA(1))) && (_tokenSet_63.member(LA(2))) && (_tokenSet_64.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp184_AST = null;
				tmp184_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp184_AST);
				match(OP_IGUA);
				i2=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(i1 == i2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_65.member(LA(1))) && (_tokenSet_66.member(LA(2))) && (_tokenSet_67.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp185_AST);
				match(OP_DESI);
				i2=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(i1 != i2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_68.member(LA(1))) && (_tokenSet_69.member(LA(2))) && (_tokenSet_70.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp186_AST = null;
				tmp186_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp186_AST);
				match(OP_MAYO);
				i2=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(i1 > i2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_71.member(LA(1))) && (_tokenSet_72.member(LA(2))) && (_tokenSet_73.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp187_AST = null;
				tmp187_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp187_AST);
				match(OP_MENO);
				i2=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(i1 < i2)
					res = true;
					else
					res = false;
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			relac_entero_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = relac_entero_AST;
		return res;
	}
	
/**expresiones relacionales reales
*/
	public final boolean  relac_real() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relac_real_AST = null;
		double e1=0., e2=0.;
		
		try {      // for error handling
			{
			if ((_tokenSet_74.member(LA(1))) && (_tokenSet_75.member(LA(2))) && (_tokenSet_76.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp188_AST = null;
				tmp188_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp188_AST);
				match(OP_IGUA);
				e2=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(e1 == e2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_77.member(LA(1))) && (_tokenSet_78.member(LA(2))) && (_tokenSet_79.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp189_AST = null;
				tmp189_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp189_AST);
				match(OP_DESI);
				e2=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(e1 != e2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_80.member(LA(1))) && (_tokenSet_81.member(LA(2))) && (_tokenSet_82.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp190_AST = null;
				tmp190_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp190_AST);
				match(OP_MAYO);
				e2=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(e1 > e2)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_83.member(LA(1))) && (_tokenSet_84.member(LA(2))) && (_tokenSet_85.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp191_AST = null;
				tmp191_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp191_AST);
				match(OP_MENO);
				e2=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(e1 < e2)
					res = true;
					else
					res = false;
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			relac_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = relac_real_AST;
		return res;
	}
	
/**expresiones relacionales cadenas
*/
	public final boolean  relac_cadena() throws RecognitionException, TokenStreamException {
		boolean res=false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relac_cadena_AST = null;
		String s1="", s2="";
		
		try {      // for error handling
			{
			if ((_tokenSet_5.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_IGUA) && (_tokenSet_60.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp192_AST = null;
				tmp192_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp192_AST);
				match(OP_IGUA);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(s1.equals(s2))
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_DESI) && (_tokenSet_60.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp193_AST = null;
				tmp193_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp193_AST);
				match(OP_DESI);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(!s1.equals(s2))
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_MAYO) && (_tokenSet_60.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp194_AST = null;
				tmp194_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp194_AST);
				match(OP_MAYO);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(s1.compareTo(s2)>0)
					res = true;
					else
					res = false;
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_MENO) && (_tokenSet_60.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp195_AST = null;
				tmp195_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp195_AST);
				match(OP_MENO);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					if(s1.compareTo(s2)<0)
					res = true;
					else
					res = false;
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			relac_cadena_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_30);
			} else {
			  throw ex;
			}
		}
		returnAST = relac_cadena_AST;
		return res;
	}
	
/**expresion base cadenas
*/
	public final String  exp_c_conca() throws RecognitionException, TokenStreamException {
		String res="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_c_conca_AST = null;
		Token  n = null;
		AST n_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LIT_CADENA:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(LIT_CADENA);
				if ( inputState.guessing==0 ) {
					res= new String (n.getText());
				}
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			{
				n1 = LT(1);
				n1_AST = astFactory.create(n1);
				astFactory.addASTChild(currentAST, n1_AST);
				match(IDENT);
				if ( inputState.guessing==0 ) {
					
						
					if (ejecucion) {
					Variable var = null;
					for(int i=0;i<listaVars.size();i++) 
					{
						if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
								var = listaVars.get(i);
								break;
						}	
					}
					if(var != null && var.getKind() == Variable.Kind.STR)
					{
						res = var.getValue();
					}
						}
					
				}
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case PIECE_TYPE:
			{
				AST tmp196_AST = null;
				tmp196_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp196_AST);
				match(PIECE_TYPE);
				res=piece_type_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case PIECE_COLOR:
			{
				AST tmp197_AST = null;
				tmp197_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp197_AST);
				match(PIECE_COLOR);
				res=piece_color_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case CAPTURED_PIECE_TYPE:
			{
				AST tmp198_AST = null;
				tmp198_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp198_AST);
				match(CAPTURED_PIECE_TYPE);
				res=captured_piece_type_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case CAPTURED_PIECE_COLOR:
			{
				AST tmp199_AST = null;
				tmp199_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp199_AST);
				match(CAPTURED_PIECE_COLOR);
				res=captured_piece_color_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case READ_STR:
			{
				AST tmp200_AST = null;
				tmp200_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp200_AST);
				match(READ_STR);
				res=fun_r_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case C_D_LAST_MOV:
			{
				AST tmp201_AST = null;
				tmp201_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp201_AST);
				match(C_D_LAST_MOV);
				res=c_d_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case C_O_LAST_MOV:
			{
				AST tmp202_AST = null;
				tmp202_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp202_AST);
				match(C_O_LAST_MOV);
				res=c_o_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_21);
			} else {
			  throw ex;
			}
		}
		returnAST = exp_c_conca_AST;
		return res;
	}
	
/**for zona sketch
*/
	public final void buc_for_s() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_for_s_AST = null;
		Token  n = null;
		AST n_AST = null;
		int i1=0,i2=0; 
			       int mark = getInputState().getInput().mark();
			       Variable var = null;
		
		try {      // for error handling
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(INIT_FOR);
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp204_AST = null;
			tmp204_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp204_AST);
			match(F_FROM);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(F_UNTIL);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
			match(F_DO);
			if ( inputState.guessing==0 ) {
				
						if(i1<i2) {
						if (ejecucion) {
								for(int i=0;i<listaVars.size();i++) {
									if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
										var = listaVars.get(i);
										break;
									}	
								}
								if(var != null && var.getKind() == Variable.Kind.INT) {
									if(dentroBucle == false) {
										var.setValue(String.valueOf(i1));
										dentroBucle=true;
									}
								}
							}
						}
				
			}
			board_zone();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(FIN_FOR);
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
				if(Integer.parseInt(var.getValue())<i2-1){
				var.setValue(String.valueOf(Integer.parseInt(var.getValue())+1));
				rewind(mark);
				}  
				else
				dentroBucle=false; 	
				
			}
			if ( inputState.guessing==0 ) {
				System.out.println("  Fin for transform.");
			}
			buc_for_s_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_for_s_AST;
	}
	
/**while zona sketch
*/
	public final void buc_while_s() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_while_s_AST = null;
		boolean b1=false;
		int mark = getInputState().getInput().mark();
		
		
		try {      // for error handling
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(WHILE);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(DO);
			if ( inputState.guessing==0 ) {
				if(b1 == false) {
					if (salirBucle != -1) {
				rewind(salirBucle);
					}
					}
				
			}
			board_zone();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				salirBucle = getInputState().getInput().mark();
			}
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(END_WHILE);
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
					if(b1 == true) {
				rewind(mark);
						} else {
							salirBucle = -1;
					}
				
			}
			buc_while_s_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_while_s_AST;
	}
	
/**for zona transform
*/
	public final void buc_for_t() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_for_t_AST = null;
		Token  n = null;
		AST n_AST = null;
		int i1=0,i2=0; 
			       int mark = getInputState().getInput().mark();
			       Variable var = null;
		
		try {      // for error handling
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(INIT_FOR);
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp214_AST = null;
			tmp214_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp214_AST);
			match(F_FROM);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp215_AST = null;
			tmp215_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp215_AST);
			match(F_UNTIL);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp216_AST = null;
			tmp216_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp216_AST);
			match(F_DO);
			if ( inputState.guessing==0 ) {
				
						if(i1<i2) {
						if (ejecucion) {
								for(int i=0;i<listaVars.size();i++) {
									if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
										var = listaVars.get(i);
										break;
									}	
								}
								if(var != null && var.getKind() == Variable.Kind.INT) {
									if(dentroBucle == false) {
										var.setValue(String.valueOf(i1));
										dentroBucle=true;
									}
								}
							}
						}
				
			}
			game_zone();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp217_AST);
			match(FIN_FOR);
			AST tmp218_AST = null;
			tmp218_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp218_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
				if(Integer.parseInt(var.getValue())<i2-1){
				var.setValue(String.valueOf(Integer.parseInt(var.getValue())+1));
				rewind(mark);
				}  
				else
				dentroBucle=false; 	
				
			}
			if ( inputState.guessing==0 ) {
				System.out.println("  Fin for transform.");
			}
			buc_for_t_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_for_t_AST;
	}
	
/**while zona transform
*/
	public final void buc_while_t() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST buc_while_t_AST = null;
		boolean b1=false;
		int mark = getInputState().getInput().mark();
		
		
		try {      // for error handling
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp219_AST);
			match(WHILE);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp220_AST = null;
			tmp220_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp220_AST);
			match(DO);
			if ( inputState.guessing==0 ) {
				if(b1 == false) {
					if (salirBucle != -1) {
				rewind(salirBucle);
					}
					}
				
			}
			game_zone();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				salirBucle = getInputState().getInput().mark();
			}
			AST tmp221_AST = null;
			tmp221_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp221_AST);
			match(END_WHILE);
			AST tmp222_AST = null;
			tmp222_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp222_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
					if(b1 == true) {
				rewind(mark);
						} else {
							salirBucle = -1;
					}
				
			}
			buc_while_t_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = buc_while_t_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"BEGIN_BOARD",
		"END_BOARD",
		"BEGIN_GAME",
		"END_GAME",
		"OP_FIN",
		"BEGIN_VARIABLES",
		"END_VARIABLES",
		"INT",
		"IDENT",
		"CNST",
		"OP_ASIG",
		"OP_SEPA",
		"OP_DELI",
		"STR",
		"FLO",
		"LOG",
		"WRT",
		"WAIT",
		"OP_PAR_I",
		"OP_PAR_D",
		"IF",
		"THEN",
		"ELSE",
		"END_IF",
		"RANDOM_BOARD",
		"ADD_PIECE",
		"SETUP_PIECE",
		"REMOVE_PIECE",
		"GENERATE_3D_BOARD",
		"MOVE_PLAYER_W",
		"MOVE_PLAYER_B",
		"MOVE_RANDOMLY_W",
		"MOVE_RANDOMLY_B",
		"STATE",
		"MOVEMENTS_LIST",
		"STATE_3D",
		"OP_SUMA",
		"OP_REST",
		"OP_MULT",
		"OP_DIVI",
		"MOD",
		"OP_EXPO",
		"LIT_ENTERO",
		"READ_NUMBER",
		"POINTS",
		"F_O_LAST_MOV",
		"F_D_LAST_MOV",
		"LIT_REAL",
		"R_REAL",
		"RATIO_WB",
		"RATIO_POINTS_WB",
		"OP_AND",
		"OP_OR",
		"OP_NOT",
		"LIT_BOOL",
		"CHECK",
		"CHECKMATE",
		"STALEMATE",
		"CASTLING",
		"R_BOOL",
		"OP_IGUA",
		"OP_DESI",
		"OP_MAYO",
		"OP_MENO",
		"LIT_CADENA",
		"PIECE_TYPE",
		"PIECE_COLOR",
		"CAPTURED_PIECE_TYPE",
		"CAPTURED_PIECE_COLOR",
		"READ_STR",
		"C_D_LAST_MOV",
		"C_O_LAST_MOV",
		"INIT_FOR",
		"F_FROM",
		"F_UNTIL",
		"F_DO",
		"FIN_FOR",
		"WHILE",
		"DO",
		"END_WHILE"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 201326624L, 589824L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 201326720L, 589824L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 8542753312L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 2184729608654848L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 4096L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { -108153461261987840L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 33780295744425984L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 1099464446624L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 1024L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 1091142947456L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 920576L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 2184729650630656L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 144115188075839136L, 1040383L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { -16L, 1040383L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 1099553669120L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 42041344L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 42041344L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 33780295786401792L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 141916164820287136L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { -17592186044432L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 1099553669120L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 42041344L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 65536L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { -144115188071657472L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { -67070163087360L, 266239L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { -945504L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 35961726813868032L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 36027697553543168L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 144115188074910368L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 42008576L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 108086391098933248L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 69269274591232L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 51677088546816L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 2184729616977920L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 2250700314710016L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 2251799779152544L, 729072L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 33780295752749056L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 33828674264436736L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 33829773728879264L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 8458240L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { -1099499040768L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { -1099498975232L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 8388608L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 33780295744393216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 33828674264403968L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 3298576924672L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 7696623435776L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = { 16492716457984L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 34084902502400L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = { 3298576924672L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = { 7696623435776L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = { 16492716457984L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = { 2184729608589312L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = { 2250700348264448L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = { 110338190869631648L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = { 33780295744360448L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = { 33828674297991168L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = { 141916164819358368L, 987151L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = { 1099515822080L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = { 8392704L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = { 36028797061005312L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = { 2184729608589312L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = { 2250700348264448L, 262145L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = { 110338190869631648L, 991217L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = { 2184729608589312L, 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = { 2250700348264448L, 262146L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = { 110338190869631648L, 991218L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = { 2184729608589312L, 4L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = { 2250700348264448L, 262148L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = { 110338190869631648L, 991220L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = { 2184729608589312L, 8L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	private static final long[] mk_tokenSet_72() {
		long[] data = { 2250700348264448L, 262152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	private static final long[] mk_tokenSet_73() {
		long[] data = { 110338190869631648L, 991224L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	private static final long[] mk_tokenSet_74() {
		long[] data = { 33780295744360448L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	private static final long[] mk_tokenSet_75() {
		long[] data = { 33828674297991168L, 262145L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	private static final long[] mk_tokenSet_76() {
		long[] data = { 141916164819358368L, 987137L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());
	private static final long[] mk_tokenSet_77() {
		long[] data = { 33780295744360448L, 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());
	private static final long[] mk_tokenSet_78() {
		long[] data = { 33828674297991168L, 262146L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());
	private static final long[] mk_tokenSet_79() {
		long[] data = { 141916164819358368L, 987138L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());
	private static final long[] mk_tokenSet_80() {
		long[] data = { 33780295744360448L, 4L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());
	private static final long[] mk_tokenSet_81() {
		long[] data = { 33828674297991168L, 262148L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());
	private static final long[] mk_tokenSet_82() {
		long[] data = { 141916164819358368L, 987140L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());
	private static final long[] mk_tokenSet_83() {
		long[] data = { 33780295744360448L, 8L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());
	private static final long[] mk_tokenSet_84() {
		long[] data = { 33828674297991168L, 262152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());
	private static final long[] mk_tokenSet_85() {
		long[] data = { 141916164819358368L, 987144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());
	
	}
