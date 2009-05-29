// $ANTLR : "Anasint.g" -> "Anasint.java"$

	package chess;
	import java.util.*;
	import java.lang.*;
	import java.io.*;

public interface AnasintTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int BEGIN_BOARD = 4;
	int END_BOARD = 5;
	int BEGIN_GAME = 6;
	int END_GAME = 7;
	int OP_FIN = 8;
	int BEGIN_VARIABLES = 9;
	int END_VARIABLES = 10;
	int INT = 11;
	int IDENT = 12;
	int CNST = 13;
	int OP_ASIG = 14;
	int OP_SEPA = 15;
	int OP_DELI = 16;
	int STR = 17;
	int FLO = 18;
	int LOG = 19;
	int WRT = 20;
	int WAIT = 21;
	int OP_PAR_I = 22;
	int OP_PAR_D = 23;
	int IF = 24;
	int THEN = 25;
	int ELSE = 26;
	int END_IF = 27;
	int RANDOM_BOARD = 28;
	int ADD_PIECE = 29;
	int SETUP_PIECE = 30;
	int REMOVE_PIECE = 31;
	int GENERATE_3D_BOARD = 32;
	int MOVE_PLAYER_W = 33;
	int MOVE_PLAYER_B = 34;
	int MOVE_RANDOMLY_W = 35;
	int MOVE_RANDOMLY_B = 36;
	int STATE = 37;
	int MOVEMENTS_LIST = 38;
	int STATE_3D = 39;
	int OP_SUMA = 40;
	int OP_REST = 41;
	int OP_MULT = 42;
	int OP_DIVI = 43;
	int MOD = 44;
	int OP_EXPO = 45;
	int LIT_ENTERO = 46;
	int R_ENTERO = 47;
	int POINTS = 48;
	int F_O_LAST_MOV = 49;
	int F_D_LAST_MOV = 50;
	int LIT_REAL = 51;
	int R_REAL = 52;
	int RATIO_WB = 53;
	int RATIO_POINTS_WB = 54;
	int OP_AND = 55;
	int OP_OR = 56;
	int OP_NOT = 57;
	int LIT_BOOL = 58;
	int CHECK = 59;
	int CHECKMATE = 60;
	int STALEMATE = 61;
	int CASTLING = 62;
	int R_BOOL = 63;
	int OP_IGUA = 64;
	int OP_DESI = 65;
	int OP_MAYO = 66;
	int OP_MENO = 67;
	int LIT_CADENA = 68;
	int PIECE_TYPE = 69;
	int PIECE_COLOR = 70;
	int CAPTURED_PIECE_TYPE = 71;
	int CAPTURED_PIECE_COLOR = 72;
	int R_CADENA = 73;
	int C_D_LAST_MOV = 74;
	int C_O_LAST_MOV = 75;
	int INIT_FOR = 76;
	int F_FROM = 77;
	int F_UNTIL = 78;
	int F_DO = 79;
	int FIN_FOR = 80;
	int WHILE = 81;
	int DO = 82;
	int END_WHILE = 83;
}
