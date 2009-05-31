[
Programa 7
Partida de ajedrez deathmach, rey contra rey con ayuda de un peon hasta que alguno se mate o hagan 30 movimientos
]
begin_board
	RANDOM_BOARD(1,"original");
	ADD_PIECE("peon","negro","E",7);
	ADD_PIECE("peon","blanco","E",2);
end_board
begin_game
	begin_variables
		INT movimientos;
	end_variables
	movimientos = 30;
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") && (0 < movimientos) Play
		MOVE_RANDOMLY_W();
		MOVE_RANDOMLY_B();
		movimientos = movimientos - 1;
	End_While_Chess;
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game
@

[

SALIDA:


PIEZAS BLANCAS

D,7 Rey
E,7 Peon

PIEZAS NEGRAS

F,2 Rey
Peon (ficha capturada)

SITUACION ACTUAL

Turno: Blanco

PB (E,2) -> (E,3)
RN (E,8) -> (F,8)
PB (E,3) -> (E,4)
RN (F,8) -> (G,8)
PB (E,4) -> (E,5)
RN (G,8) -> (H,8)
PB (E,5) -> (E,6)
RN (H,8) -> (G,7)
RB (E,1) -> (E,2)
RN (G,7) -> (G,8)
RB (E,2) -> (E,3)
RN (G,8) -> (G,7)
RB (E,3) -> (D,4)
RN (G,7) -> (H,6)
RB (D,4) -> (E,3)
RN (H,6) -> (H,7)
RB (E,3) -> (D,4)
RN (H,7) -> (H,6)
RB (D,4) -> (D,3)
RN (H,6) -> (G,7)
RB (D,3) -> (C,2)
RN (G,7) -> (G,8)
RB (C,2) -> (D,3)
RN (G,8) -> (H,8)
RB (D,3) -> (E,4)
RN (H,8) -> (H,7)
RB (E,4) -> (E,3)
RN (H,7) -> (G,8)
RB (E,3) -> (D,4)
RN (G,8) -> (H,8)
RB (D,4) -> (D,5)
RN (H,8) -> (H,7)
RB (D,5) -> (C,5)
RN (H,7) -> (H,8)
RB (C,5) -> (C,6)
RN (H,8) -> (H,7)
RB (C,6) -> (B,6)
RN (H,7) -> (H,6)
RB (B,6) -> (C,7)
RN (H,6) -> (G,5)
RB (C,7) -> (B,6)
RN (G,5) -> (F,4)
RB (B,6) -> (B,5)
RN (F,4) -> (G,5)
RB (B,5) -> (A,6)
RN (G,5) -> (F,4)
RB (A,6) -> (B,7)
RN (F,4) -> (G,3)
RB (B,7) -> (C,8)
RN (G,3) -> (H,3)
RB (C,8) -> (D,8)
RN (H,3) -> (H,4)
RB (D,8) -> (E,7) (Captura PN)
RN (H,4) -> (H,3)
RB (E,7) -> (D,6)
RN (H,3) -> (H,4)
PB (E,6) -> (E,7)
RN (H,4) -> (G,3)
RB (D,6) -> (D,7)
RN (G,3) -> (F,2)
Archivo generado

Resultado ASA:  begin_board RANDOM_BOARD ( 1 , original ) ; ADD_PIECE ( peon , negro , E , 7 ) ; ADD_PIECE ( peon , blanco , E , 2 ) ; end_board begin_game begin_variables INT movimientos ; end_variables movimientos = 30 ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play MOVE_RANDOMLY_W ( ) ; MOVE_RANDOMLY_B ( ) ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ! CHECKMATE ( blanco ) && ! STALEMATE ( blanco ) && ! CHECKMATE ( negro ) && ! STALEMATE ( negro ) && ( 0 < movimientos ) Play End_While_Chess ; STATE ( ) ; MOVEMENTS_LIST ( ) ; STATE_3D ( ./3D/ ) ; end_game @

]