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
  ArrayList listaIden = new ArrayList();
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
			_loop533:
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
					break _loop533;
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
			_loop537:
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
					break _loop537;
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
			_loop541:
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
					break _loop541;
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
	
/**funciones comunes a las zonas sketch y transform
*/
	public final void common_fun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST common_fun_AST = null;
		Token  n = null;
		AST n_AST = null;
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
			case IDENT:
			{
				n = LT(1);
				n_AST = astFactory.create(n);
				astFactory.addASTChild(currentAST, n_AST);
				match(IDENT);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(OP_ASIG);
				s1=expresion();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					
						if (ejecucion) {
					int existe=0;      
					Iden id = new Iden();
					for(int i=0;i<listaIden.size();i++) 
					{
						    id = (Iden)listaIden.get(i);
						    if(n.getText().equals(id.obtenerNombre())){
						      existe=1;
						      break;
						    }	
					}
					if(existe == 1)
					{
						if(id.obtenerConst())  //si es constante
						  System.out.println("  Variable constante, no se puede modificar su valor");
						else   //si no
						{
						  String tipo="";
						  tipo=id.obtenerTipo();
						    if(tipo.equals("real"))  //si es real
						    {
					if(s1.substring(0,1).equals("D")){
					double valor = Double.parseDouble(s1.substring(1)); 
					listaIden.remove(id);    
					id.establecerValor(String.valueOf(valor));
					listaIden.add(id);
					}
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
						    }
					else
						    {
						      if(tipo.equals("entero"))  //si es entero
						      {
						  	    if(s1.substring(0,1).equals("E")){
					int valor = Integer.parseInt(s1.substring(1)); 
					listaIden.remove(id);    
					id.establecerValor(String.valueOf(valor));
					listaIden.add(id);
					}	  
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
						      }
						      else
						      {
					if(tipo.equals("booleano")) //si es booleano
						        {
						          if(s1.substring(0,1).equals("B")){
					boolean valor = Boolean.parseBoolean(s1.substring(1)); 
					listaIden.remove(id);    
					id.establecerValor(String.valueOf(valor));
					listaIden.add(id);
					}	  
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
						        }
						        else  //si es una cadena
						        {
						          if(s1.substring(0,1).equals("S")){	
					String valor = s1.substring(1); 
					listaIden.remove(id);    
					id.establecerValor(String.valueOf(valor));
					listaIden.add(id);
					}  
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
						        }
						      }
						    }    	  	
						}
					}
					else
						System.out.println("  La variable de la asignacin " + n.getText() + " no existe.");
					}	
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp13_AST = null;
			tmp13_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp13_AST);
			match(OP_DELI);
			common_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_4);
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
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp14_AST);
				match(RANDOM_BOARD);
				r_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ADD_PIECE:
			{
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(ADD_PIECE);
				a_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SETUP_PIECE:
			{
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(SETUP_PIECE);
				s_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case REMOVE_PIECE:
			{
				AST tmp17_AST = null;
				tmp17_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp17_AST);
				match(REMOVE_PIECE);
				r_p_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case GENERATE_3D_BOARD:
			{
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp18_AST);
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
			AST tmp19_AST = null;
			tmp19_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp19_AST);
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
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp20_AST);
			match(IF);
			b1=expr_logica();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
										
			}
			AST tmp21_AST = null;
			tmp21_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp21_AST);
			match(THEN);
			board_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case ELSE:
			{
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(ELSE);
				if ( inputState.guessing==0 ) {
					if (bloqueo == 0) {ejecucion = !ejecucion;}
				}
				game_expr();
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
			AST tmp23_AST = null;
			tmp23_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp23_AST);
			match(END_IF);
			if ( inputState.guessing==0 ) {
				if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}
			}
			AST tmp24_AST = null;
			tmp24_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp24_AST);
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
			if ( inputState.guessing==0 ) {
				System.out.println("  <VARIABLES>");
			}
			{
			_loop544:
			do {
				if ((_tokenSet_5.member(LA(1)))) {
					declaracion();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop544;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				System.out.println("  </VARIABLES>");
			}
			zona_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_6);
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
				recover(ex,_tokenSet_7);
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
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(MOVE_PLAYER_W);
				m_p_w_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_PLAYER_B:
			{
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(MOVE_PLAYER_B);
				m_p_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_RANDOMLY_W:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(MOVE_RANDOMLY_W);
				m_r_w_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVE_RANDOMLY_B:
			{
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(MOVE_RANDOMLY_B);
				m_r_b_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STATE:
			{
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(STATE);
				s_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case MOVEMENTS_LIST:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(MOVEMENTS_LIST);
				m_l_fun();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case STATE_3D:
			{
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp31_AST);
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
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(OP_DELI);
			game_fun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
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
				recover(ex,_tokenSet_7);
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
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(IF);
			b1=expr_logica();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
										
			}
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(THEN);
			game_expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case ELSE:
			{
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(ELSE);
				if ( inputState.guessing==0 ) {
					if (bloqueo == 0) {ejecucion = !ejecucion;}
				}
				game_expr();
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
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(END_IF);
			if ( inputState.guessing==0 ) {
				if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}
			}
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(OP_DELI);
			game_cond_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = game_cond_AST;
	}
	
/** declaracion de variables
*/
	public final void declaracion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		Token  n2 = null;
		AST n2_AST = null;
		int num=0;
		
		try {      // for error handling
			num=tipo_decl();
			astFactory.addASTChild(currentAST, returnAST);
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(IDENT);
			{
			_loop547:
			do {
				if ((LA(1)==OP_SEPA)) {
					AST tmp38_AST = null;
					tmp38_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp38_AST);
					match(OP_SEPA);
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					astFactory.addASTChild(currentAST, n2_AST);
					match(IDENT);
					if ( inputState.guessing==0 ) {
						listaNombres.add(n2.getText());
					}
				}
				else {
					break _loop547;
				}
				
			} while (true);
			}
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				//se busca el numero de declaracion en la lista, se le aade el nombre y se vuelve a guardar
					Iden id = new Iden();
				for(int i=0;i<listaIden.size();i++) 
				{
					  id = (Iden)listaIden.get(i);
				if(id.obtenerNumId() == num)
				break;
				}  
				
				Iden mismoNom = new Iden();
				int igual=0;
				for(int i=0;i<listaIden.size();i++) 
				{
					  mismoNom = (Iden)listaIden.get(i);
				if(n1.getText().equals(mismoNom.obtenerNombre())){
					igual=1;
				break; 
				}   
				}	
				
				if(igual == 0)
				{
				listaIden.remove(id);    
				id.establecerNombre(n1.getText());
				listaIden.add(id);
				}
				else
				{
				System.out.println("    Ya existe una variable con " + n1.getText() + " por nombre.");
				listaIden.remove(id); 
				}
				//si hay varios identificadores, se obtienen sus nombres y se van guardando las nuevas declaraciones
				String nom;
				int total=listaNombres.size();
				for(int i=total-1;i>=0;i--) 
				{
				nom = (String)listaNombres.get(i);	
				listaNombres.remove(nom);
				
				igual=0;
				for(int j=0;j<listaIden.size();j++) 
				{
					    mismoNom = (Iden)listaIden.get(j);
				if(nom.equals(mismoNom.obtenerNombre())){
					  igual=1;
				break; 
				}   
				}	
				if(igual == 0)
				{
				Iden id2 = new Iden();
				id2.establecerNombre(nom);
				id2.establecerTipo(id.obtenerTipo());
				id2.establecerValor(id.obtenerValor());
				id2.establecerNumId(id.obtenerNumId());
				id2.establecerConst(id.obtenerConst());
				listaIden.add(id2);
				}
				else
				{
				System.out.println("    Ya existe una variable con " + nom + " por nombre.");
				}
				}	  
				
			}
			declaracion_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = declaracion_AST;
	}
	
/** tipo de variable
*/
	public final int  tipo_decl() throws RecognitionException, TokenStreamException {
		int id=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipo_decl_AST = null;
		int num=0;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case REAL:
			{
				num=decl_real();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ENTERO:
			{
				num=decl_int();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case BOOLEANO:
			{
				num=decl_bool();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case CADENA:
			{
				num=decl_cad();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case CTE:
			{
				num=decl_cons();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				id=num;
			}
			tipo_decl_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = tipo_decl_AST;
		return id;
	}
	
/** variable real
*/
	public final int  decl_real() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_real_AST = null;
		double e1;
		
		try {      // for error handling
			boolean synPredMatched552 = false;
			if (((LA(1)==REAL) && (LA(2)==OP_ASIG))) {
				int _m552 = mark();
				synPredMatched552 = true;
				inputState.guessing++;
				try {
					{
					match(REAL);
					match(OP_ASIG);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched552 = false;
				}
				rewind(_m552);
inputState.guessing--;
			}
			if ( synPredMatched552 ) {
				AST tmp40_AST = null;
				tmp40_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp40_AST);
				match(REAL);
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp41_AST);
				match(OP_ASIG);
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("real");
					id.establecerValor(String.valueOf(e1));
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_real_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==REAL) && (LA(2)==IDENT)) {
				AST tmp42_AST = null;
				tmp42_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp42_AST);
				match(REAL);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("real");
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_real_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = decl_real_AST;
		return num;
	}
	
/** variable entero
*/
	public final int  decl_int() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_int_AST = null;
		int i1;
		
		try {      // for error handling
			boolean synPredMatched555 = false;
			if (((LA(1)==ENTERO) && (LA(2)==OP_ASIG))) {
				int _m555 = mark();
				synPredMatched555 = true;
				inputState.guessing++;
				try {
					{
					match(ENTERO);
					match(OP_ASIG);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched555 = false;
				}
				rewind(_m555);
inputState.guessing--;
			}
			if ( synPredMatched555 ) {
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp43_AST);
				match(ENTERO);
				AST tmp44_AST = null;
				tmp44_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp44_AST);
				match(OP_ASIG);
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
						contId++;
					Iden id = new Iden();
					id.establecerTipo("entero");
					id.establecerValor(String.valueOf(i1));
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_int_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==ENTERO) && (LA(2)==IDENT)) {
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(ENTERO);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("entero");
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_int_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = decl_int_AST;
		return num;
	}
	
/** variable booleana
*/
	public final int  decl_bool() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_bool_AST = null;
		boolean b1;
		
		try {      // for error handling
			boolean synPredMatched558 = false;
			if (((LA(1)==BOOLEANO) && (LA(2)==OP_ASIG))) {
				int _m558 = mark();
				synPredMatched558 = true;
				inputState.guessing++;
				try {
					{
					match(BOOLEANO);
					match(OP_ASIG);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched558 = false;
				}
				rewind(_m558);
inputState.guessing--;
			}
			if ( synPredMatched558 ) {
				AST tmp46_AST = null;
				tmp46_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp46_AST);
				match(BOOLEANO);
				AST tmp47_AST = null;
				tmp47_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp47_AST);
				match(OP_ASIG);
				b1=expr_bool();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("booleano");
					id.establecerValor(String.valueOf(b1));
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_bool_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BOOLEANO) && (LA(2)==IDENT)) {
				AST tmp48_AST = null;
				tmp48_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp48_AST);
				match(BOOLEANO);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("booleano");
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_bool_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = decl_bool_AST;
		return num;
	}
	
/** variable cadena
*/
	public final int  decl_cad() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_cad_AST = null;
		String s1;
		
		try {      // for error handling
			boolean synPredMatched561 = false;
			if (((LA(1)==CADENA) && (LA(2)==OP_ASIG))) {
				int _m561 = mark();
				synPredMatched561 = true;
				inputState.guessing++;
				try {
					{
					match(CADENA);
					match(OP_ASIG);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched561 = false;
				}
				rewind(_m561);
inputState.guessing--;
			}
			if ( synPredMatched561 ) {
				AST tmp49_AST = null;
				tmp49_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp49_AST);
				match(CADENA);
				AST tmp50_AST = null;
				tmp50_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp50_AST);
				match(OP_ASIG);
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
						contId++;
					Iden id = new Iden();
					id.establecerTipo("cadena");
					id.establecerValor(s1);
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_cad_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==CADENA) && (LA(2)==IDENT)) {
				AST tmp51_AST = null;
				tmp51_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp51_AST);
				match(CADENA);
				if ( inputState.guessing==0 ) {
					contId++;
					Iden id = new Iden();
					id.establecerTipo("cadena");
					id.establecerNumId(contId);
					listaIden.add(id);
					num=contId;
					
				}
				decl_cad_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = decl_cad_AST;
		return num;
	}
	
/** declaracion variables constantes
*/
	public final int  decl_cons() throws RecognitionException, TokenStreamException {
		int id=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_cons_AST = null;
		int num=0;
		
		try {      // for error handling
			AST tmp52_AST = null;
			tmp52_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp52_AST);
			match(CTE);
			{
			switch ( LA(1)) {
			case REAL:
			{
				num=cte_real();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ENTERO:
			{
				num=cte_int();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case BOOLEANO:
			{
				num=cte_bool();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case CADENA:
			{
				num=cte_cad();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				if(num==0)
					  throw new NullPointerException("    Debe asignar un valor a la variable constante.");
					else  
					  id=num;
			}
			decl_cons_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = decl_cons_AST;
		return id;
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
			if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2))) && (_tokenSet_12.member(LA(3)))) {
				e1=expr_r_resta();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res=e1;
				}
			}
			else if ((_tokenSet_13.member(LA(1))) && (_tokenSet_11.member(LA(2))) && (_tokenSet_12.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop639:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp53_AST = null;
					tmp53_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp53_AST);
					match(OP_SUMA);
					e2=expr_r_resta();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+e2;
					}
				}
				else {
					break _loop639;
				}
				
			} while (true);
			}
			expr_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_real_AST;
		return res;
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
			if ((_tokenSet_15.member(LA(1))) && (_tokenSet_16.member(LA(2))) && (_tokenSet_17.member(LA(3)))) {
				i1=expr_e_resta();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = i1;
				}
			}
			else if ((_tokenSet_18.member(LA(1))) && (_tokenSet_16.member(LA(2))) && (_tokenSet_17.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop618:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp54_AST = null;
					tmp54_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp54_AST);
					match(OP_SUMA);
					i2=expr_e_resta();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+i2;
					}
				}
				else {
					break _loop618;
				}
				
			} while (true);
			}
			expr_entero_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_19);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_entero_AST;
		return res;
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
			if ((_tokenSet_20.member(LA(1))) && (_tokenSet_21.member(LA(2))) && (_tokenSet_22.member(LA(3)))) {
				b1=expr_logica();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_23.member(LA(1))) && (_tokenSet_24.member(LA(2))) && (_tokenSet_25.member(LA(3)))) {
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
				recover(ex,_tokenSet_26);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_bool_AST;
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
			_loop676:
			do {
				if ((LA(1)==OP_SUMA)) {
					AST tmp55_AST = null;
					tmp55_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp55_AST);
					match(OP_SUMA);
					s2=exp_c_conca();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res+s2;
					}
				}
				else {
					break _loop676;
				}
				
			} while (true);
			}
			expr_cadena_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_cadena_AST;
		return res;
	}
	
/** variable constante real 
*/
	public final int  cte_real() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cte_real_AST = null;
		double e1=0.;
		
		try {      // for error handling
			AST tmp56_AST = null;
			tmp56_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp56_AST);
			match(REAL);
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(OP_ASIG);
			e1=expr_real();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				contId++;
				Iden id = new Iden();
				id.establecerTipo("real");
				id.establecerValor(String.valueOf(e1));
				id.establecerNumId(contId);
				id.establecerConst(true);
				listaIden.add(id);
				num=contId;
				
			}
			cte_real_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = cte_real_AST;
		return num;
	}
	
/** variable constante entero 
*/
	public final int  cte_int() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cte_int_AST = null;
		int i1=0;
		
		try {      // for error handling
			AST tmp58_AST = null;
			tmp58_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp58_AST);
			match(ENTERO);
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(OP_ASIG);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
					  contId++;
				Iden id = new Iden();
				id.establecerTipo("entero");
				id.establecerValor(String.valueOf(i1));
				id.establecerNumId(contId);
				id.establecerConst(true);
				listaIden.add(id);
				num=contId;
				
			}
			cte_int_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = cte_int_AST;
		return num;
	}
	
/** variable constante booleana 
*/
	public final int  cte_bool() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cte_bool_AST = null;
		boolean b1;
		
		try {      // for error handling
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(BOOLEANO);
			AST tmp61_AST = null;
			tmp61_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp61_AST);
			match(OP_ASIG);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				contId++;
				Iden id = new Iden();
				id.establecerTipo("booleano");
				id.establecerValor(String.valueOf(b1));
				id.establecerNumId(contId);
				id.establecerConst(true);
				listaIden.add(id);
				num=contId;
				
			}
			cte_bool_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = cte_bool_AST;
		return num;
	}
	
/** variable constante cadena 
*/
	public final int  cte_cad() throws RecognitionException, TokenStreamException {
		int num=0;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cte_cad_AST = null;
		String s1;
		
		try {      // for error handling
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp62_AST);
			match(CADENA);
			AST tmp63_AST = null;
			tmp63_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp63_AST);
			match(OP_ASIG);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				contId++;
				Iden id = new Iden();
				id.establecerTipo("cadena");
				id.establecerValor(s1);
				id.establecerNumId(contId);
				id.establecerConst(true);
				listaIden.add(id);
				num=contId;
				
			}
			cte_cad_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = cte_cad_AST;
		return num;
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
			AST tmp64_AST = null;
			tmp64_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp64_AST);
			match(OP_PAR_I);
			s1=expresion();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp65_AST = null;
			tmp65_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp65_AST);
			match(OP_PAR_D);
			if ( inputState.guessing==0 ) {
				
					  	  	if (ejecucion) {
					  	  		 System.out.println("  WRITE -> " + s1.substring(1));
					  	  	}
				
			}
			fun_wri_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_27);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_wri_AST;
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
			if ((_tokenSet_28.member(LA(1))) && (_tokenSet_29.member(LA(2))) && (_tokenSet_30.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = "E" + String.valueOf(i1);
				}
			}
			else if ((_tokenSet_31.member(LA(1))) && (_tokenSet_32.member(LA(2))) && (_tokenSet_33.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = "D" + String.valueOf(e1);
				}
			}
			else if ((_tokenSet_34.member(LA(1))) && (_tokenSet_35.member(LA(2))) && (_tokenSet_36.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = "S" + s1;
				}
			}
			else if ((_tokenSet_37.member(LA(1))) && (_tokenSet_38.member(LA(2))) && (_tokenSet_39.member(LA(3)))) {
				b1=expr_bool();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = "B" + String.valueOf(b1);
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
				recover(ex,_tokenSet_40);
			} else {
			  throw ex;
			}
		}
		returnAST = expresion_AST;
		return res;
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
			AST tmp66_AST = null;
			tmp66_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp66_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp67_AST = null;
			tmp67_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp67_AST);
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
				recover(ex,_tokenSet_41);
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
			AST tmp68_AST = null;
			tmp68_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp68_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp69_AST);
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
				recover(ex,_tokenSet_41);
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
			AST tmp70_AST = null;
			tmp70_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp70_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp71_AST);
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
				recover(ex,_tokenSet_41);
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
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp72_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp73_AST = null;
			tmp73_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp73_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp74_AST = null;
			tmp74_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp74_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp75_AST = null;
			tmp75_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp75_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp76_AST = null;
			tmp76_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp76_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
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
				recover(ex,_tokenSet_42);
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
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp81_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
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
				recover(ex,_tokenSet_42);
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
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
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
				recover(ex,_tokenSet_42);
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
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(OP_PAR_I);
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
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
				recover(ex,_tokenSet_43);
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
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(OP_PAR_I);
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
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
				recover(ex,_tokenSet_43);
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
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
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
				recover(ex,_tokenSet_13);
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
			AST tmp96_AST = null;
			tmp96_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp96_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
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
				recover(ex,_tokenSet_41);
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
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(OP_PAR_I);
			AST tmp99_AST = null;
			tmp99_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp99_AST);
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
				recover(ex,_tokenSet_42);
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
			AST tmp100_AST = null;
			tmp100_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp100_AST);
			match(OP_PAR_I);
			AST tmp101_AST = null;
			tmp101_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp101_AST);
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
				recover(ex,_tokenSet_43);
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
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(OP_PAR_I);
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
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
				recover(ex,_tokenSet_41);
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
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(OP_PAR_I);
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
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
				recover(ex,_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		returnAST = fun_r_cadena_AST;
		return valor;
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
			_loop658:
			do {
				if ((LA(1)==OP_AND)) {
					AST tmp106_AST = null;
					tmp106_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp106_AST);
					match(OP_AND);
					b2=expr_b_or();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res && b2;
					}
				}
				else {
					break _loop658;
				}
				
			} while (true);
			}
			expr_logica_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_44);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_logica_AST;
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
			AST tmp107_AST = null;
			tmp107_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp107_AST);
			match(OP_PAR_I);
			num_pics=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==OP_SEPA) && (_tokenSet_45.member(LA(2))) && (_tokenSet_46.member(LA(3)))) {
				AST tmp108_AST = null;
				tmp108_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp108_AST);
				match(OP_SEPA);
				prop=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==OP_SEPA) && (_tokenSet_34.member(LA(2))) && (LA(3)==OP_PAR_I||LA(3)==OP_PAR_D||LA(3)==OP_SUMA)) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			AST tmp109_AST = null;
			tmp109_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp109_AST);
			match(OP_SEPA);
			disp=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp110_AST = null;
			tmp110_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp110_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp111_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp112_AST = null;
			tmp112_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp112_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp113_AST);
			match(OP_SEPA);
			s3=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(OP_SEPA);
			e1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp116_AST = null;
			tmp116_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp116_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp117_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp119_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp120_AST = null;
			tmp120_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp120_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp121_AST = null;
			tmp121_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp121_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==OP_SEPA) && (_tokenSet_47.member(LA(2))) && (_tokenSet_48.member(LA(3)))) {
				AST tmp122_AST = null;
				tmp122_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp122_AST);
				match(OP_SEPA);
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==OP_SEPA) && (_tokenSet_34.member(LA(2))) && (LA(3)==OP_PAR_I||LA(3)==OP_PAR_D||LA(3)==OP_SUMA)) {
				AST tmp123_AST = null;
				tmp123_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp123_AST);
				match(OP_SEPA);
				s2=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			AST tmp124_AST = null;
			tmp124_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp124_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp125_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp126_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp127_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp128_AST = null;
			tmp128_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp128_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp129_AST = null;
			tmp129_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp129_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp130_AST = null;
			tmp130_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp130_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp131_AST = null;
			tmp131_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp131_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp132_AST = null;
			tmp132_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp132_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp133_AST = null;
			tmp133_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp133_AST);
			match(OP_SEPA);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp134_AST = null;
			tmp134_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp134_AST);
			match(OP_SEPA);
			s2=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp135_AST = null;
			tmp135_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp135_AST);
			match(OP_SEPA);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp136_AST = null;
			tmp136_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp136_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp137_AST = null;
			tmp137_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp137_AST);
			match(OP_PAR_I);
			AST tmp138_AST = null;
			tmp138_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp138_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp139_AST = null;
			tmp139_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp139_AST);
			match(OP_PAR_I);
			AST tmp140_AST = null;
			tmp140_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp140_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp141_AST = null;
			tmp141_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp141_AST);
			match(OP_PAR_I);
			{
			switch ( LA(1)) {
			case IDENT:
			case LIT_CADENA:
			case PIECE_TYPE:
			case PIECE_COLOR:
			case CAPTURED_PIECE_TYPE:
			case CAPTURED_PIECE_COLOR:
			case R_CADENA:
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
			AST tmp142_AST = null;
			tmp142_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp142_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp143_AST = null;
			tmp143_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp143_AST);
			match(OP_PAR_I);
			AST tmp144_AST = null;
			tmp144_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp144_AST);
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
				recover(ex,_tokenSet_27);
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
			AST tmp145_AST = null;
			tmp145_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp145_AST);
			match(OP_PAR_I);
			s1=expr_cadena();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp146_AST = null;
			tmp146_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp146_AST);
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
				recover(ex,_tokenSet_27);
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
			if ((_tokenSet_49.member(LA(1))) && (_tokenSet_50.member(LA(2))) && (_tokenSet_16.member(LA(3)))) {
				i1=exp_e_mult();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = i1;
				}
			}
			else if ((_tokenSet_51.member(LA(1))) && (_tokenSet_16.member(LA(2))) && (_tokenSet_17.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop622:
			do {
				if ((LA(1)==OP_REST)) {
					AST tmp147_AST = null;
					tmp147_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp147_AST);
					match(OP_REST);
					i2=exp_e_mult();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res-i2;
					}
				}
				else {
					break _loop622;
				}
				
			} while (true);
			}
			expr_e_resta_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_18);
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
			_loop625:
			do {
				if ((LA(1)==OP_MULT)) {
					AST tmp148_AST = null;
					tmp148_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp148_AST);
					match(OP_MULT);
					i2=exp_e_divi();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res*i2;
					}
				}
				else {
					break _loop625;
				}
				
			} while (true);
			}
			exp_e_mult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_51);
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
			_loop628:
			do {
				if ((LA(1)==OP_DIVI)) {
					AST tmp149_AST = null;
					tmp149_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp149_AST);
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
					break _loop628;
				}
				
			} while (true);
			}
			exp_e_divi_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_52);
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
			_loop631:
			do {
				if ((LA(1)==OP_MODU)) {
					AST tmp150_AST = null;
					tmp150_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp150_AST);
					match(OP_MODU);
					i2=exp_e_pot();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res%i2;
					}
				}
				else {
					break _loop631;
				}
				
			} while (true);
			}
			exp_e_modu_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_53);
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
			_loop634:
			do {
				if ((LA(1)==OP_EXPO)) {
					AST tmp151_AST = null;
					tmp151_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp151_AST);
					match(OP_EXPO);
					i2=exp_e_base();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=(int)Math.pow(res,i2);
					}
				}
				else {
					break _loop634;
				}
				
			} while (true);
			}
			exp_e_pot_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_54);
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
				AST tmp152_AST = null;
				tmp152_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp152_AST);
				match(OP_PAR_I);
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp153_AST = null;
				tmp153_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp153_AST);
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
					
					int existe=0;      
					Iden id = new Iden();
					for(int i=0;i<listaIden.size();i++) 
					{
						     id = (Iden)listaIden.get(i);
						     if(n1.getText().equals(id.obtenerNombre())){
						       existe=1;
						       break;
						     }	
					}
					if(existe == 1)
					{
					String tipo="";
					tipo=id.obtenerTipo();
					if(tipo.equals("entero")) 
					{
					res=Integer.parseInt(id.obtenerValor());
					}
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
					}
					else
					System.out.println("  La variable " + n1.getText() + " no existe.");
					
				}
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case R_ENTERO:
			{
				AST tmp154_AST = null;
				tmp154_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp154_AST);
				match(R_ENTERO);
				fun_r_entero();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case POINTS:
			{
				AST tmp155_AST = null;
				tmp155_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp155_AST);
				match(POINTS);
				points_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case F_O_LAST_MOV:
			{
				AST tmp156_AST = null;
				tmp156_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp156_AST);
				match(F_O_LAST_MOV);
				f_o_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_e_base_AST = (AST)currentAST.root;
				break;
			}
			case F_D_LAST_MOV:
			{
				AST tmp157_AST = null;
				tmp157_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp157_AST);
				match(F_D_LAST_MOV);
				f_d_last_mov_fun();
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
				recover(ex,_tokenSet_42);
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
			if ((_tokenSet_55.member(LA(1))) && (_tokenSet_56.member(LA(2))) && (_tokenSet_11.member(LA(3)))) {
				e1=exp_r_mult();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = e1;
				}
			}
			else if ((_tokenSet_57.member(LA(1))) && (_tokenSet_11.member(LA(2))) && (_tokenSet_12.member(LA(3)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			_loop643:
			do {
				if ((LA(1)==OP_REST)) {
					AST tmp158_AST = null;
					tmp158_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp158_AST);
					match(OP_REST);
					e2=exp_r_mult();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res-e2;
					}
				}
				else {
					break _loop643;
				}
				
			} while (true);
			}
			expr_r_resta_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_13);
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
			_loop646:
			do {
				if ((LA(1)==OP_MULT)) {
					AST tmp159_AST = null;
					tmp159_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp159_AST);
					match(OP_MULT);
					e2=exp_r_divi();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=res*e2;
					}
				}
				else {
					break _loop646;
				}
				
			} while (true);
			}
			exp_r_mult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_57);
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
			_loop649:
			do {
				if ((LA(1)==OP_DIVI)) {
					AST tmp160_AST = null;
					tmp160_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp160_AST);
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
					break _loop649;
				}
				
			} while (true);
			}
			exp_r_divi_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_58);
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
			_loop652:
			do {
				if ((LA(1)==OP_EXPO)) {
					AST tmp161_AST = null;
					tmp161_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp161_AST);
					match(OP_EXPO);
					e2=exp_r_base();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res=(double)Math.pow(res,e2);
					}
				}
				else {
					break _loop652;
				}
				
			} while (true);
			}
			exp_r_pot_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_59);
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
				AST tmp162_AST = null;
				tmp162_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp162_AST);
				match(OP_PAR_I);
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp163_AST = null;
				tmp163_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp163_AST);
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
					
					int existe=0;      
					Iden id = new Iden();
					for(int i=0;i<listaIden.size();i++) 
					{
						     id = (Iden)listaIden.get(i);
						     if(n1.getText().equals(id.obtenerNombre())){
						       existe=1;
						       break;
						     }	
					}
					if(existe == 1)
					{
					String tipo="";
					tipo=id.obtenerTipo();
					if(tipo.equals("real")) 
					{
					res=Double.parseDouble(id.obtenerValor());
					}
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
					}
					else
					System.out.println("  La variable " + n1.getText() + " no existe.");
					
				}
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case R_REAL:
			{
				AST tmp164_AST = null;
				tmp164_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp164_AST);
				match(R_REAL);
				fun_r_real();
				astFactory.addASTChild(currentAST, returnAST);
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case RATIO_WB:
			{
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp165_AST);
				match(RATIO_WB);
				ratio_wb_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_r_base_AST = (AST)currentAST.root;
				break;
			}
			case RATIO_POINTS_WB:
			{
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp166_AST);
				match(RATIO_POINTS_WB);
				ratio_points_wb_fun();
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
				recover(ex,_tokenSet_43);
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
			if ((_tokenSet_60.member(LA(1))) && (_tokenSet_61.member(LA(2))) && (_tokenSet_62.member(LA(3)))) {
				b1=relac_entero();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_63.member(LA(1))) && (_tokenSet_64.member(LA(2))) && (_tokenSet_65.member(LA(3)))) {
				b1=relac_real();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					res = b1;
				}
			}
			else if ((_tokenSet_34.member(LA(1))) && (_tokenSet_66.member(LA(2))) && (_tokenSet_67.member(LA(3)))) {
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
				recover(ex,_tokenSet_26);
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
			_loop661:
			do {
				if ((LA(1)==OP_OR)) {
					AST tmp167_AST = null;
					tmp167_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(OP_OR);
					b2=expr_b_not();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						res = res || b2;
					}
				}
				else {
					break _loop661;
				}
				
			} while (true);
			}
			expr_b_or_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_68);
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
				AST tmp168_AST = null;
				tmp168_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp168_AST);
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
				recover(ex,_tokenSet_41);
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
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp169_AST);
				match(OP_PAR_I);
				b1=expr_bool();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
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
					
					int existe=0;      
					Iden id = new Iden();
					for(int i=0;i<listaIden.size();i++) 
					{
						     id = (Iden)listaIden.get(i);
						     if(n1.getText().equals(id.obtenerNombre())){
						       existe=1;
						       break;
						     }	
					}
					if(existe == 1)
					{
					String tipo="";
					tipo=id.obtenerTipo();
					if(tipo.equals("booleano")) 
					{
					res=Boolean.parseBoolean(id.obtenerValor());
					}
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
					}
					else
					System.out.println("  La variable " + n1.getText() + " no existe.");
					
				}
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CHECK:
			{
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp171_AST);
				match(CHECK);
				res=check_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CHECKMATE:
			{
				AST tmp172_AST = null;
				tmp172_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp172_AST);
				match(CHECKMATE);
				res=checkmate_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case STALEMATE:
			{
				AST tmp173_AST = null;
				tmp173_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp173_AST);
				match(STALEMATE);
				res=stalemate_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case CASTLING:
			{
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp174_AST);
				match(CASTLING);
				res=castling_fun();
				astFactory.addASTChild(currentAST, returnAST);
				expr_b_base_AST = (AST)currentAST.root;
				break;
			}
			case R_BOOL:
			{
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp175_AST);
				match(R_BOOL);
				fun_r_bool();
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
				recover(ex,_tokenSet_41);
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
			if ((_tokenSet_69.member(LA(1))) && (_tokenSet_70.member(LA(2))) && (_tokenSet_71.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp176_AST = null;
				tmp176_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp176_AST);
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
			else if ((_tokenSet_72.member(LA(1))) && (_tokenSet_73.member(LA(2))) && (_tokenSet_74.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp177_AST = null;
				tmp177_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp177_AST);
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
			else if ((_tokenSet_75.member(LA(1))) && (_tokenSet_76.member(LA(2))) && (_tokenSet_77.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp178_AST = null;
				tmp178_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp178_AST);
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
			else if ((_tokenSet_78.member(LA(1))) && (_tokenSet_79.member(LA(2))) && (_tokenSet_80.member(LA(3)))) {
				i1=expr_entero();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp179_AST = null;
				tmp179_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp179_AST);
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
				recover(ex,_tokenSet_26);
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
			if ((_tokenSet_81.member(LA(1))) && (_tokenSet_82.member(LA(2))) && (_tokenSet_83.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp180_AST = null;
				tmp180_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp180_AST);
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
			else if ((_tokenSet_84.member(LA(1))) && (_tokenSet_85.member(LA(2))) && (_tokenSet_86.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp181_AST = null;
				tmp181_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp181_AST);
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
			else if ((_tokenSet_87.member(LA(1))) && (_tokenSet_88.member(LA(2))) && (_tokenSet_89.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp182_AST = null;
				tmp182_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp182_AST);
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
			else if ((_tokenSet_90.member(LA(1))) && (_tokenSet_91.member(LA(2))) && (_tokenSet_92.member(LA(3)))) {
				e1=expr_real();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp183_AST = null;
				tmp183_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp183_AST);
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
				recover(ex,_tokenSet_26);
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
			if ((_tokenSet_34.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_IGUA) && (_tokenSet_67.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp184_AST = null;
				tmp184_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp184_AST);
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
			else if ((_tokenSet_34.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_DESI) && (_tokenSet_67.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp185_AST);
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
			else if ((_tokenSet_34.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_MAYO) && (_tokenSet_67.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp186_AST = null;
				tmp186_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp186_AST);
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
			else if ((_tokenSet_34.member(LA(1))) && (LA(2)==OP_PAR_I||LA(2)==OP_SUMA||LA(2)==OP_MENO) && (_tokenSet_67.member(LA(3)))) {
				s1=expr_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp187_AST = null;
				tmp187_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp187_AST);
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
				recover(ex,_tokenSet_26);
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
					
					int existe=0;      
					Iden id = new Iden();
					for(int i=0;i<listaIden.size();i++) 
					{
						     id = (Iden)listaIden.get(i);
						     if(n1.getText().equals(id.obtenerNombre())){
						       existe=1;
						       break;
						     }	
					}
					if(existe == 1)
					{
					String tipo="";
					tipo=id.obtenerTipo();
					if(tipo.equals("cadena")) 
					{
					res=id.obtenerValor();
					}
					else
					System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
					}
					else
					System.out.println("  La variable " + n1.getText() + " no existe.");
					
				}
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case PIECE_TYPE:
			{
				AST tmp188_AST = null;
				tmp188_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp188_AST);
				match(PIECE_TYPE);
				res=piece_type_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case PIECE_COLOR:
			{
				AST tmp189_AST = null;
				tmp189_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp189_AST);
				match(PIECE_COLOR);
				res=piece_color_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case CAPTURED_PIECE_TYPE:
			{
				AST tmp190_AST = null;
				tmp190_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp190_AST);
				match(CAPTURED_PIECE_TYPE);
				res=captured_piece_type_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case CAPTURED_PIECE_COLOR:
			{
				AST tmp191_AST = null;
				tmp191_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp191_AST);
				match(CAPTURED_PIECE_COLOR);
				res=captured_piece_color_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case R_CADENA:
			{
				AST tmp192_AST = null;
				tmp192_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp192_AST);
				match(R_CADENA);
				fun_r_cadena();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case C_D_LAST_MOV:
			{
				AST tmp193_AST = null;
				tmp193_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp193_AST);
				match(C_D_LAST_MOV);
				c_d_last_mov_fun();
				astFactory.addASTChild(currentAST, returnAST);
				exp_c_conca_AST = (AST)currentAST.root;
				break;
			}
			case C_O_LAST_MOV:
			{
				AST tmp194_AST = null;
				tmp194_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp194_AST);
				match(C_O_LAST_MOV);
				c_o_last_mov_fun();
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
				recover(ex,_tokenSet_13);
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
			       Iden id = new Iden();
		
		try {      // for error handling
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp195_AST);
			match(INIT_FOR);
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp196_AST);
			match(F_FROM);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp197_AST);
			match(F_UNTIL);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp198_AST);
			match(F_DO);
			if ( inputState.guessing==0 ) {
				
				if(i1<i2)
				{
				int existe=0;      
				for(int i=0;i<listaIden.size();i++) 
				{
					     id = (Iden)listaIden.get(i);
					     if(n.getText().equals(id.obtenerNombre())){
					       existe=1;
					       break;
					     }	
				}
				if(existe == 1)
				{
				String tipo="";
				tipo=id.obtenerTipo();
				if(tipo.equals("entero") && !id.obtenerConst()) 
				{ 
				if(dentroBucle == false)
				{
				id.establecerValor(String.valueOf(i1));
				dentroBucle=true;
				}
				}
				else
				System.out.println("  No se puede realizar el bucle. La variable no es entera o es un entero constante.");
				}
				else
				System.out.println("  La variable " + n.getText() + " no existe.");
				}
				else
				System.out.println("  La segunda expresion entera debe ser mayor que la primera.");
				
			}
			board_zone();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp199_AST);
			match(FIN_FOR);
			AST tmp200_AST = null;
			tmp200_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp200_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
				if(Integer.parseInt(id.obtenerValor())<i2-1){
				id.establecerValor(String.valueOf(Integer.parseInt(id.obtenerValor())+1));
				rewind(mark);
				}  
				else
				dentroBucle=false; 	
				
			}
			if ( inputState.guessing==0 ) {
				System.out.println("  Fin for sketch.");
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
			AST tmp201_AST = null;
			tmp201_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp201_AST);
			match(WHILE);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp202_AST = null;
			tmp202_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp202_AST);
			match(DO);
			if ( inputState.guessing==0 ) {
				if(b1 == false) {
					System.out.println("3");
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
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(END_WHILE);
			AST tmp204_AST = null;
			tmp204_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp204_AST);
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
			       Iden id = new Iden();
		
		try {      // for error handling
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(INIT_FOR);
			n = LT(1);
			n_AST = astFactory.create(n);
			astFactory.addASTChild(currentAST, n_AST);
			match(IDENT);
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
			match(F_FROM);
			i1=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(F_UNTIL);
			i2=expr_entero();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(F_DO);
			if ( inputState.guessing==0 ) {
				
				if(i1<i2)
				{
				int existe=0;      
				for(int i=0;i<listaIden.size();i++) 
				{
					     id = (Iden)listaIden.get(i);
					     if(n.getText().equals(id.obtenerNombre())){
					       existe=1;
					       break;
					     }	
				}
				if(existe == 1)
				{
				String tipo="";
				tipo=id.obtenerTipo();
				if(tipo.equals("entero") && !id.obtenerConst()) 
				{ 
				if(dentroBucle == false)
				{
				id.establecerValor(String.valueOf(i1));
				dentroBucle=true;
				}
				}
				else
				System.out.println("  No se puede realizar el bucle. La variable no es entera o es un entero constante.");
				}
				else
				System.out.println("  La variable " + n.getText() + " no existe.");
				}
				else
				System.out.println("  La segunda expresion entera debe ser mayor que la primera.");
				
			}
			game_zone();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(FIN_FOR);
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(OP_DELI);
			if ( inputState.guessing==0 ) {
				
				if(Integer.parseInt(id.obtenerValor())<i2-1){
				id.establecerValor(String.valueOf(Integer.parseInt(id.obtenerValor())+1));
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
				recover(ex,_tokenSet_7);
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
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(WHILE);
			b1=expr_bool();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(DO);
			if ( inputState.guessing==0 ) {
				if(b1 == false) {
					System.out.println("3");
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
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(END_WHILE);
			AST tmp214_AST = null;
			tmp214_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp214_AST);
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
				recover(ex,_tokenSet_7);
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
		"IDENT",
		"OP_SEPA",
		"OP_DELI",
		"REAL",
		"OP_ASIG",
		"ENTERO",
		"BOOLEANO",
		"CADENA",
		"CTE",
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
		"OP_MODU",
		"OP_EXPO",
		"LIT_ENTERO",
		"R_ENTERO",
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
		"R_CADENA",
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
		long[] data = { 32L, 589824L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 128L, 589824L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 8542751264L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1099464444576L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 999424L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 1024L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 1091142945408L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 1000448L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 2048L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 33780295752759296L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 141916164819270304L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { -17592186044432L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 1099520030720L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 8402944L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 2184729616988160L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 144115188074822304L, 1040383L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { -16L, 1040383L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 1099520030720L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 8402944L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { -144115188071659520L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { -67070196701184L, 266239L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { -1033568L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 35961726813865984L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 36027697519929344L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 144115188074822304L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { 8398848L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 8192L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 2184729616984064L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 2251799779093152L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { -108086391090450448L, 729087L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 33780295752755200L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 33829773728819872L, 724992L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { -108103983276494864L, 729087L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 2048L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 1099524218880L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 1099472841376L, 729072L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { -108153461261989888L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { -1099499034624L, 4095L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { -34592096L, 729087L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 8396800L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { 108086391098845184L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 69269240952832L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 51677054908416L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 41953280L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 33780295744362496L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 33828674264373248L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 2184729616975872L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = { 2250700314650624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 2181431073703936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = { 2250700314654720L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = { 3298543286272L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = { 7696589797376L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = { 16492682819584L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = { 34084868864000L, 311311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = { 33776997209475072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = { 33828674264381440L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = { 3298543286272L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = { 7696589797376L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	private static final long[] mk_tokenSet_59() {
		long[] data = { 16492682819584L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());
	private static final long[] mk_tokenSet_60() {
		long[] data = { 2184729608587264L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());
	private static final long[] mk_tokenSet_61() {
		long[] data = { 2250700314650624L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());
	private static final long[] mk_tokenSet_62() {
		long[] data = { 110338190869543584L, 991231L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());
	private static final long[] mk_tokenSet_63() {
		long[] data = { 33780295744358400L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());
	private static final long[] mk_tokenSet_64() {
		long[] data = { 33828674264377344L, 262159L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());
	private static final long[] mk_tokenSet_65() {
		long[] data = { 141916164819270304L, 987151L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());
	private static final long[] mk_tokenSet_66() {
		long[] data = { 1099515822080L, 15L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());
	private static final long[] mk_tokenSet_67() {
		long[] data = { 8390656L, 4080L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());
	private static final long[] mk_tokenSet_68() {
		long[] data = { 36028797060917248L, 262144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());
	private static final long[] mk_tokenSet_69() {
		long[] data = { 2184729608587264L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());
	private static final long[] mk_tokenSet_70() {
		long[] data = { 2250700314650624L, 262145L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());
	private static final long[] mk_tokenSet_71() {
		long[] data = { 110338190869543584L, 991217L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());
	private static final long[] mk_tokenSet_72() {
		long[] data = { 2184729608587264L, 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());
	private static final long[] mk_tokenSet_73() {
		long[] data = { 2250700314650624L, 262146L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());
	private static final long[] mk_tokenSet_74() {
		long[] data = { 110338190869543584L, 991218L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());
	private static final long[] mk_tokenSet_75() {
		long[] data = { 2184729608587264L, 4L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());
	private static final long[] mk_tokenSet_76() {
		long[] data = { 2250700314650624L, 262148L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());
	private static final long[] mk_tokenSet_77() {
		long[] data = { 110338190869543584L, 991220L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());
	private static final long[] mk_tokenSet_78() {
		long[] data = { 2184729608587264L, 8L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());
	private static final long[] mk_tokenSet_79() {
		long[] data = { 2250700314650624L, 262152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());
	private static final long[] mk_tokenSet_80() {
		long[] data = { 110338190869543584L, 991224L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());
	private static final long[] mk_tokenSet_81() {
		long[] data = { 33780295744358400L, 1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());
	private static final long[] mk_tokenSet_82() {
		long[] data = { 33828674264377344L, 262145L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());
	private static final long[] mk_tokenSet_83() {
		long[] data = { 141916164819270304L, 987137L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());
	private static final long[] mk_tokenSet_84() {
		long[] data = { 33780295744358400L, 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());
	private static final long[] mk_tokenSet_85() {
		long[] data = { 33828674264377344L, 262146L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());
	private static final long[] mk_tokenSet_86() {
		long[] data = { 141916164819270304L, 987138L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());
	private static final long[] mk_tokenSet_87() {
		long[] data = { 33780295744358400L, 4L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());
	private static final long[] mk_tokenSet_88() {
		long[] data = { 33828674264377344L, 262148L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());
	private static final long[] mk_tokenSet_89() {
		long[] data = { 141916164819270304L, 987140L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());
	private static final long[] mk_tokenSet_90() {
		long[] data = { 33780295744358400L, 8L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());
	private static final long[] mk_tokenSet_91() {
		long[] data = { 33828674264377344L, 262152L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());
	private static final long[] mk_tokenSet_92() {
		long[] data = { 141916164819270304L, 987144L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());
	
	}
