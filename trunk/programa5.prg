[
Programa 5
Partida de ajedrez con cambio de torre por caballo a 10 movimientos
]
begin_board
	RANDOM_BOARD(16,"original");
	SETUP_PIECE("A",1,"B",1);
	SETUP_PIECE("B",1,"A",1);
	GENERATE_3D_BOARD("./3D/");
end_board
begin_game
	begin_variables
		LOG turno_blanco = true;
		INT movimientos;
	end_variables
	movimientos = 10;
	While_Chess (0 < movimientos) Play
		If_Chess (true && turno_blanco) Play_If
			MOVE_RANDOMLY_W();
			turno_blanco = false;
		Play_If_Not
			MOVE_RANDOMLY_B();
			turno_blanco = true;
		End_If_Chess;
		movimientos = movimientos - 1;
	End_While_Chess;
	STATE();
	MOVEMENTS_LIST();
end_game
@

[

Salida: 

PIEZAS BLANCAS

D,2 Rey
Caballo (ficha capturada)
C,5 Peon
B,4 Peon
Peon (ficha capturada)
A,4 Peon
F,3 Peon
Caballo (ficha capturada)
C,2 Peon
A,3 Torre
G,1 Torre
F,1 Reina
B,2 Alfil
D,1 Alfil
E,6 Peon
H,2 Peon

PIEZAS NEGRAS

E,8 Rey
C,6 Caballo
A,5 Peon
F,4 Peon
D,6 Peon
C,7 Peon
C,8 Alfil
A,6 Torre
H,7 Peon
Reina (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
G,5 Peon
H,6 Caballo
H,8 Torre
G,7 Alfil

SITUACION ACTUAL

Turno: Blanco

PB (E,2) -> (E,3)
PN (E,7) -> (E,5)
PB (A,2) -> (A,3)
PN (B,7) -> (B,5)
PB (D,2) -> (D,3)
PN (D,7) -> (D,6)
PB (A,3) -> (A,4)
DN (D,8) -> (F,6)
PB (G,2) -> (G,4)
CN (B,8) -> (D,7)

Resultado ASA:  begin_board RANDOM_BOARD ( 16 , original ) ; SETUP_PIECE ( A , 1 , B , 1 ) ; SETUP_PIECE ( B , 1 , A , 1 ) ; GENERATE_3D_BOARD ( ./3D/ ) ; end_board begin_game begin_variables LOG turno_blanco = true ; INT movimientos ; end_variables movimientos = 10 ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play End_While_Chess ; STATE ( ) ; MOVEMENTS_LIST ( ) ; end_game @
]
