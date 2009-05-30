[
Programa 2
Uso de variables. Partida de 10 movimientos.
]
begin_board
	RANDOM_BOARD(16,"original");
end_board
begin_game
<<<<<<< .mine
<<<<<<< .mine
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") Play
=======
=======
	begin_variables
		LOG turno_blanco = true;
		INT movimientos;
	end_variables
>>>>>>> .r79
	WRT ("");
	WRT ("Programa 2");
	WRT ("");
<<<<<<< .mine
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") Play
>>>>>>> .r75
		MOVE_RANDOMLY_W();
		MOVE_RANDOMLY_B();
=======
	WRT ("Introduzca el numero de jugadas a realizar");
	movimientos = READ_NUMBER();
	While_Chess (0 < movimientos) Play
		If_Chess (true && turno_blanco) Play_If
			MOVE_RANDOMLY_W();
			turno_blanco = false;
		Play_If_Not
			MOVE_RANDOMLY_B();
			turno_blanco = true;
		End_If_Chess;
		movimientos = movimientos - 1;
>>>>>>> .r79
<<<<<<< .mine
	End_While_Chess;
	[WRT ("HEY");
	While_Chess true Play
		WRT ("hola");
=======
>>>>>>> .r75
	End_While_Chess;
	STATE();]
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game
[
Salida (10 jugadas):
  WRITE -> 
  WRITE -> Programa 2
  WRITE -> 
  WRITE -> Introduzca el numero de jugadas a realizar
  READ_INTEGER -> Introduzca un valor entero.
10
  READ_INTEGER -> El valor entero ledo es: 10

PIEZAS BLANCAS

E,1 Rey
B,3 Peon
H,3 Caballo
H,1 Torre
D,1 Reina
C,1 Alfil
F,1 Alfil
G,2 Peon
D,2 Peon
A,2 Torre
C,2 Peon
B,1 Caballo
E,4 Peon
F,2 Peon
H,2 Peon
A,3 Peon

PIEZAS NEGRAS

D,8 Rey
G,7 Peon
F,7 Peon
C,8 Alfil
G,8 Caballo
A,6 Peon
A,8 Torre
F,6 Reina
D,7 Peon
B,7 Peon
F,8 Alfil
B,8 Caballo
E,7 Peon
H,7 Peon
H,8 Torre
C,5 Peon

SITUACION ACTUAL

Turno: Blanco

PB (A,2) -> (A,3)
PN (C,7) -> (C,5)
TB (A,1) -> (A,2)
DN (D,8) -> (B,6)
CB (G,1) -> (H,3)
PN (A,7) -> (A,6)
PB (B,2) -> (B,3)
RN (E,8) -> (D,8)
PB (E,2) -> (E,4)
DN (B,6) -> (F,6)
Archivo generado

Resultado ASA:  begin_board RANDOM_BOARD ( 16 , original ) ; end_board begin_game begin_variables LOG turno_blanco = true ; INT movimientos ; end_variables WRT (  ) ; WRT ( Programa 2 ) ; WRT (  ) ; WRT ( Introduzca el numero de jugadas a realizar ) ; movimientos = READ_NUMBER ( ) ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play End_While_Chess ; STATE ( ) ; MOVEMENTS_LIST ( ) ; STATE_3D ( ./3D/ ) ; end_game @

]
@
