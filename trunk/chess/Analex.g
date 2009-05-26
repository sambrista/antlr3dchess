header{
	package chess;
}

//Clase Analex
//realiza el analisis lexico
//@author Alfonso Jimnez Vlchez
//
class Analex extends Lexer;

options{
  importVocab = Anasint; // Importacin del conjunto de tokens
  caseSensitive = false;
  charVocabulary = '\3'..'\377'; 
  exportVocab = AnalexVocab;
  testLiterals = false;
  k=3;
}

tokens{
	// tipos
	ENTERO = "INT";
	CHAR = "CHR";
	CADENA = "STR";
	REAL = "FLO";
	BOOLEANO = "LOG";
	CTE = "cnst";
	// instrucciones
	IF = "If_Chess";
	END_IF = "End_If_Chess";
	THEN = "Play_If";
	DO = "Play";
	ELSE = "Play_If_Not";
	FOR = "For_Chess";
	FROM = "From";
	TO = "...";
	WHILE = "While_Chess";
	END_WHILE = "End_While_Chess";
	// zonas
	BEGIN_BOARD = "begin_board";
	END_BOARD = "end_board";
	BEGIN_GAME = "begin_game";
	END_GAME = "end_game";
	BEGIN_VARIABLES = "begin_variables";
	END_VARIABLES = "end_variables";
	//BOARD
	RANDOM_BOARD = "RANDOM_BOARD";
	ADD_PIECE = "ADD_PIECE";
	SETUP_PIECE = "SETUP_PIECE";
	REMOVE_PIECE = "REMOVE_PIECE";
	GENERATE_3D_BOARD = "GENERATE_3D_BOARD";
	//GAME
	MOVE_PLAYER_W = "MOVE_PLAYER_W";
	MOVE_PLAYER_B = "MOVE_PLAYER_B";
	MOVE_RANDOMLY_W = "MOVE_RANDOMLY_W";
	MOVE_RANDOMLY_B = "MOVE_RANDOMLY_B";
	STATE = "STATE";
	MOVEMENTS_LIST = "MOVEMENTS_LIST";
	STATE_3D = "STATE_3D";
	//Common
	CHECK = "CHECK";
	CHECKMATE = "CHECKMATE";
	STALEMATE = "STALEMATE";
	PIECE_TYPE = "PIECE_TYPE";
	PIECE_COLOR = "PIECE_COLOR";
	POINTS = "POINTS";
	C_O_LAST_MOVE = "C_O_LAST_MOVE";
	F_O_LAST_MOVE = "F_O_LAST_MOVE";
	C_D_LAST_MOVE = "C_D_LAST_MOVE";
	F_D_LAST_MOVE = "F_D_LAST_MOVE";
	RATIO_WB = "RATIO_WB";
	RATIO_POINTS_WB = "RATIO_POINTS_WB";
	CAPTURED_PIECE_TYPE = "CAPTURED_PIECE_TYPE";
	CAPTURED_PIECE_COLOR = "CAPTURED_PIECE_COLOR";
	CASTLING = "CASTLING";
	//Other
	READ_NUMBER = "READ_NUMBER";
	READ_STR = "READ_STR";
	READ_CHR = "READ_CHR";
	WRT = "WRT";
	WAIT = "WAIT";
	MOD = "MOD";
}

BLANCO : (' '|'\t'|"\r\n"|'\n'|'\r') {$setType(Token.SKIP);};
protected DIGITO : ('0'..'9');
protected LETRA : ('a'..'z');


IDENT options {testLiterals=true;} : (LETRA|'_') (LETRA|DIGITO|'_')* ;

LIT_NUMERO : ((DIGITO)+'.') =>
  (DIGITO)+'.'(DIGITO)* {$setType(LIT_REAL);}
  | (DIGITO)+{$setType(LIT_ENTERO);} ;
  
LIT_CADENA : 
  '"' !
  (~('"'|'\n'|'\r'))*
  '"' ! ;
  
LIT_BOOL : 
  "true" 
  | "false" ;

	//comentarios
COMEN_LINEA :
  "%" ( ~('\n'|'\r') )* 
  {$setType(Token.SKIP);} {System.out.println("comentario de una linea");}; 

COMEN_VARIAS :
  '[' (~(']'))* ']'
  {$setType(Token.SKIP);} {System.out.println("comentario de varias lineas");};
  
  	//operadores
  OP_ASIG : "=" ;
  OP_DECL : ':' ;
  OP_DELI : ';' ;
  OP_SEPA : ',' ;
  OP_PAR_I : '(' ;
  OP_PAR_D : ')' ;
  OP_FIN : '@' ;
  OP_SUMA : '+' ;
  OP_REST : '-' ;
  OP_MULT : '*' ;
  OP_DIVI : '/' ;
  OP_EXPO : '^' ;
  OP_AND : "&&" ;
  OP_OR : "|| "|"||(" ;
  OP_NOT : "!" ;
  OP_IGUA : "==" ;
  OP_DESI : "!=" ;
  OP_MAYO : '>' ;
  OP_MENO : '<' ;
  OP_CONCAT : "++";
