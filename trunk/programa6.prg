[
Programa 6
Partida de ajedrez con fichas aleatorias a 50 movimientos
]
begin_board
	RANDOM_BOARD(10,1.5,"random");
end_board
begin_game
	begin_variables
		LOG turno_blanco = true;
		INT movimientos;
		INT puntosB;
		INT puntosN;
	end_variables
	movimientos = 50;
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
	puntosB=POINTS("blanco");
	puntosN=POINTS("negro");
	STATE();
	MOVEMENTS_LIST();
	WRT ("Los puntos de las blancas son");
	WRT (puntosB);
	WRT ("Los puntos de las negras son");
	WRT (puntosN);
end_game
@

[
SALIDA: 

comentario de varias lineas

PIEZAS BLANCAS

C,2 Rey
E,4 Alfil
B,6 Peon
Caballo (ficha capturada)
Peon (ficha capturada)
B,8 Alfil
Peon (ficha capturada)
E,7 Peon
A,7 Peon
G,3 Torre

PIEZAS NEGRAS

E,2 Rey
A,4 Peon
Torre (ficha capturada)
Peon (ficha capturada)
H,7 Torre
Peon (ficha capturada)
Peon (ficha capturada)
B,5 Caballo
A,8 Alfil
Reina (ficha capturada)
B,7 Peon
D,7 Caballo
A,5 Peon
G,4 Peon
Alfil (ficha capturada)
A,1 Torre

SITUACION ACTUAL

Turno: Blanco

CB (C,8) -> (D,6)
PN (D,8) -> (D,7)
TB (G,6) -> (G,3)
PN (B,5) -> (A,4) (Captura PB)
PB (D,4) -> (E,5) (Captura DN)
CN (H,5) -> (F,6)
AB (F,4) -> (G,5)
AN (F,8) -> (D,6) (Captura CB)
AB (G,5) -> (H,4)
AN (D,6) -> (C,5)
AB (H,4) -> (G,5)
PN (D,5) -> (D,4)
RB (C,2) -> (D,1) (Captura TN)
PN (D,4) -> (D,3)
AB (G,5) -> (F,4)
AN (C,5) -> (B,6)
PB (E,5) -> (E,6)
RN (F,1) -> (F,2) (Jaque)
RB (D,1) -> (D,2)
PN (G,7) -> (G,6)
PB (C,3) -> (C,4)
CN (G,2) -> (E,1)
PB (C,4) -> (C,5)
TN (H,1) -> (H,2)
RB (D,2) -> (C,1)
CN (E,1) -> (C,2)
RB (C,1) -> (D,2)
PN (G,6) -> (G,5)
PB (A,5) -> (B,6) (Captura AN)
PN (A,3) -> (A,2)
PB (C,5) -> (C,6)
CN (C,2) -> (D,4)
AB (F,4) -> (D,6)
TN (H,2) -> (H,7)
RB (D,2) -> (D,3) (Captura PN)
CN (D,4) -> (B,5)
AB (E,8) -> (G,6)
PN (A,6) -> (A,5)
RB (D,3) -> (C,2)
PN (A,2) -> (A,1) (Promociona a TN)
AB (D,6) -> (C,7)
PN (G,5) -> (G,4)
PB (C,6) -> (D,7) (Captura PN)
TN (A,1) -> (G,1)
AB (G,6) -> (E,4)
TN (G,1) -> (A,1)
AB (C,7) -> (B,8)
CN (F,6) -> (D,7) (Captura PB)
PB (E,6) -> (E,7)
RN (F,2) -> (E,2)

  WRITE -> Los puntos de las blancas son
  WRITE -> 20
  WRITE -> Los puntos de las negras son
  WRITE -> 5

Resultado ASA:  begin_board RANDOM_BOARD ( 10 , 1.5 , random ) ; end_board begin_game begin_variables LOG turno_blanco = true ; INT movimientos ; FLO puntosB ; FLO puntosN ; end_variables movimientos = 50 ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play If_Chess ( true && turno_blanco ) Play_If MOVE_RANDOMLY_W ( ) ; turno_blanco = false ; Play_If_Not MOVE_RANDOMLY_B ( ) ; turno_blanco = true ; End_If_Chess ; movimientos = movimientos - 1 ; End_While_Chess ; While_Chess ( 0 < movimientos ) Play End_While_Chess ; puntosB = POINTS ( blanco ) ; puntosN = POINTS ( negro ) ; STATE ( ) ; MOVEMENTS_LIST ( ) ; WRT ( Los puntos de las blancas son ) ; WRT ( puntosB ) ; WRT ( Los puntos de las negras son ) ; WRT ( puntosN ) ; end_game @
]

