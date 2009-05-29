[
Programa 1
Partida de ajedrez aleatoria hasta jaque mate o ahogado.
][
begin_board
	RANDOM_BOARD(10,1.5,"random");
end_board
begin_game
	WRT ("");
	WRT ("Programa 1");
	WRT ("");
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") Play
		MOVE_RANDOMLY_W();
		MOVE_RANDOMLY_B();
	End_While_Chess;
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game
]
[

Salida:
comentario de varias lineas
  WRITE -> 
  WRITE -> Programa 1
  WRITE -> 

PIEZAS BLANCAS

F,8 Rey
Peon (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Torre (ficha capturada)
Alfil (ficha capturada)
Torre (ficha capturada)
Caballo (ficha capturada)
Peon (ficha capturada)
Caballo (ficha capturada)
Reina (ficha capturada)
Caballo (ficha capturada)

PIEZAS NEGRAS

F,3 Rey
Torre (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Caballo (ficha capturada)
A,4 Alfil
Torre (ficha capturada)
Alfil (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Reina (ficha capturada)
Peon (ficha capturada)
Peon (ficha capturada)
Caballo (ficha capturada)
D,5 Caballo
Caballo (ficha capturada)
Alfil (ficha capturada)
Caballo (ficha capturada)
G,6 Reina

SITUACION ACTUAL

Turno: Blanco
Blancas ahogadas.

TB (H,3) -> (H,2) (Jaque)
CN (G,4) -> (H,2) (Captura TB)
PB (D,5) -> (E,6) (Captura PN)
RN (A,2) -> (A,1)
PB (G,1) -> (H,2) (Captura CN)
AN (D,3) -> (C,4)
RB (E,7) -> (E,8)
TN (G,6) -> (F,6)
PB (H,2) -> (H,3)
PN (E,4) -> (F,3) (Captura PB)
AB (G,3) -> (E,1) (Captura AN)
TN (F,6) -> (G,6)
PB (H,3) -> (H,4)
RN (A,1) -> (A,2)
RB (E,8) -> (F,7)
PN (A,8) -> (A,7)
AB (E,1) -> (D,2)
PN (A,6) -> (A,5)
CB (C,5) -> (B,7) (Captura PN)
TN (D,6) -> (D,2) (Captura AB)
PB (A,4) -> (B,5) (Captura CN)
PN (A,5) -> (A,4)
RB (F,7) -> (F,8)
AN (C,4) -> (B,5) (Captura PB)
PB (H,4) -> (H,5)
PN (A,4) -> (B,3) (Captura TB)
PB (H,5) -> (G,6) (Captura TN)
AN (B,5) -> (E,2)
CB (B,7) -> (D,8)
TN (D,2) -> (D,8) (Captura CB) (Jaque)
RB (F,8) -> (F,7)
TN (D,8) -> (D,3)
PB (H,1) -> (H,2)
AN (E,2) -> (F,1)
PB (E,6) -> (E,7)
PN (B,6) -> (B,5)
PB (H,2) -> (H,3)
PN (B,3) -> (B,2)
PB (E,7) -> (E,8) (Promociona a CB)
RN (A,2) -> (B,3)
PB (H,3) -> (H,4)
PN (B,8) -> (B,7)
CB (E,8) -> (D,6)
PN (B,2) -> (B,1) (Promociona a CN)
CB (D,6) -> (E,8)
RN (B,3) -> (A,4)
RB (F,7) -> (E,6)
AN (F,1) -> (G,2)
RB (E,6) -> (E,7)
PN (A,7) -> (A,6)
PB (G,6) -> (G,7)
PN (B,5) -> (B,4)
PB (H,4) -> (H,5)
PN (B,7) -> (B,6)
CB (E,8) -> (C,7)
RN (A,4) -> (A,5)
PB (H,5) -> (H,6)
PN (B,6) -> (B,5)
PB (H,6) -> (H,7)
AN (G,2) -> (H,1)
RB (E,7) -> (F,8)
AN (H,1) -> (G,2)
RB (F,8) -> (E,8)
DN (C,3) -> (C,5)
CB (C,7) -> (E,6)
PN (F,3) -> (F,2)
PB (H,7) -> (H,8) (Promociona a DB)
TN (D,3) -> (D,2)
DB (H,8) -> (F,8)
TN (D,2) -> (C,2)
DB (F,8) -> (E,7)
CN (B,1) -> (D,2)
RB (E,8) -> (F,7)
TN (C,2) -> (C,3)
DB (E,7) -> (C,5) (Captura DN)
PN (F,2) -> (F,1) (Promociona a CN)
CB (E,6) -> (C,7)
RN (A,5) -> (A,4)
DB (C,5) -> (B,6)
PN (B,4) -> (B,3)
RB (F,7) -> (F,6)
PN (B,5) -> (B,4)
RB (F,6) -> (E,5)
CN (F,1) -> (H,2)
CB (C,7) -> (D,5)
AN (G,2) -> (D,5) (Captura CB)
RB (E,5) -> (F,5)
CN (D,2) -> (E,4)
PB (G,7) -> (G,8) (Promociona a CB)
RN (A,4) -> (A,3)
CB (G,8) -> (E,7)
PN (B,3) -> (B,2)
RB (F,5) -> (G,6)
CN (H,2) -> (F,1)
DB (B,6) -> (E,6)
PN (B,2) -> (B,1) (Promociona a AN)
CB (E,7) -> (C,6)
AN (B,1) -> (D,3)
CB (C,6) -> (A,7)
TN (C,3) -> (C,6)
CB (A,7) -> (C,6) (Captura TN)
RN (A,3) -> (A,4)
RB (G,6) -> (H,7)
PN (A,6) -> (A,5)
RB (H,7) -> (G,7)
AN (D,5) -> (E,6) (Captura DB)
RB (G,7) -> (H,7)
PN (B,4) -> (B,3)
RB (H,7) -> (H,6)
AN (E,6) -> (H,3)
CB (C,6) -> (A,7)
RN (A,4) -> (A,3)
RB (H,6) -> (H,7)
CN (F,1) -> (G,3)
RB (H,7) -> (G,6)
RN (A,3) -> (A,2)
RB (G,6) -> (G,7)
AN (D,3) -> (F,1)
CB (A,7) -> (B,5)
CN (G,3) -> (H,1)
CB (B,5) -> (A,3)
AN (F,1) -> (G,2)
CB (A,3) -> (C,2)
AN (G,2) -> (F,3)
CB (C,2) -> (A,3)
PN (A,5) -> (A,4)
RB (G,7) -> (H,7)
CN (E,4) -> (G,3)
RB (H,7) -> (H,8)
CN (H,1) -> (F,2)
RB (H,8) -> (G,7)
PN (B,3) -> (B,2)
CB (A,3) -> (C,2)
PN (A,4) -> (A,3)
RB (G,7) -> (F,7)
AN (H,3) -> (D,7)
CB (C,2) -> (D,4)
PN (B,2) -> (B,1) (Promociona a CN)
CB (D,4) -> (E,2)
AN (D,7) -> (G,4)
CB (E,2) -> (D,4)
RN (A,2) -> (A,1)
CB (D,4) -> (B,5)
CN (B,1) -> (C,3)
RB (F,7) -> (E,8)
PN (A,3) -> (A,2)
RB (E,8) -> (E,7)
AN (G,4) -> (F,5)
RB (E,7) -> (E,8)
CN (C,3) -> (B,1)
RB (E,8) -> (F,8)
AN (F,5) -> (E,6)
RB (F,8) -> (G,7)
CN (B,1) -> (C,3)
RB (G,7) -> (G,6)
CN (G,3) -> (F,5)
RB (G,6) -> (F,6)
AN (F,3) -> (H,5)
CB (B,5) -> (C,3) (Captura CN)
CN (F,2) -> (H,3)
RB (F,6) -> (E,5)
RN (A,1) -> (B,2)
CB (C,3) -> (A,4) (Jaque)
RN (B,2) -> (A,3)
CB (A,4) -> (C,5)
CN (H,3) -> (G,1)
CB (C,5) -> (A,6)
RN (A,3) -> (B,2)
RB (E,5) -> (E,4)
RN (B,2) -> (C,3)
RB (E,4) -> (F,4)
AN (E,6) -> (D,5)
CB (A,6) -> (C,5)
PN (A,2) -> (A,1) (Promociona a DN)
CB (C,5) -> (D,7)
CN (G,1) -> (E,2) (Jaque)
RB (F,4) -> (G,5)
AN (H,5) -> (G,4)
RB (G,5) -> (G,4) (Captura AN)
RN (C,3) -> (C,2)
CB (D,7) -> (E,5)
CN (E,2) -> (C,1)
CB (E,5) -> (D,3)
DN (A,1) -> (B,2)
CB (D,3) -> (C,1) (Captura CN)
DN (B,2) -> (F,6)
RB (G,4) -> (H,3)
AN (D,5) -> (E,4)
CB (C,1) -> (E,2)
CN (F,5) -> (D,4)
CB (E,2) -> (C,3)
AN (E,4) -> (G,6)
CB (C,3) -> (B,5)
RN (C,2) -> (D,1)
RB (H,3) -> (H,2)
CN (D,4) -> (B,3)
CB (B,5) -> (D,4)
RN (D,1) -> (E,1)
RB (H,2) -> (H,3)
CN (B,3) -> (A,5)
CB (D,4) -> (E,6)
DN (F,6) -> (F,1) (Jaque)
RB (H,3) -> (G,4)
DN (F,1) -> (D,3)
CB (E,6) -> (C,5)
DN (D,3) -> (B,5)
CB (C,5) -> (B,7)
RN (E,1) -> (E,2)
CB (B,7) -> (D,6)
RN (E,2) -> (F,1)
RB (G,4) -> (G,3)
DN (B,5) -> (F,5)
CB (D,6) -> (F,7)
AN (G,6) -> (H,7)
RB (G,3) -> (H,4)
DN (F,5) -> (C,8)
CB (F,7) -> (H,8)
RN (F,1) -> (E,2)
RB (H,4) -> (H,5)
DN (C,8) -> (G,8)
RB (H,5) -> (H,6)
CN (A,5) -> (B,7)
CB (H,8) -> (G,6)
DN (G,8) -> (F,7)
RB (H,6) -> (H,5)
DN (F,7) -> (C,4)
RB (H,5) -> (H,6)
DN (C,4) -> (E,4)
CB (G,6) -> (H,4)
AN (H,7) -> (G,6)
CB (H,4) -> (F,3)
CN (B,7) -> (C,5)
RB (H,6) -> (G,7)
DN (E,4) -> (D,3)
RB (G,7) -> (F,6)
CN (C,5) -> (A,6)
RB (F,6) -> (E,5)
RN (E,2) -> (F,2)
CB (F,3) -> (H,4)
RN (F,2) -> (G,3)
RB (E,5) -> (E,6)
AN (G,6) -> (H,5)
CB (H,4) -> (F,3)
CN (A,6) -> (C,7) (Jaque)
RB (E,6) -> (F,6)
CN (C,7) -> (A,8)
RB (F,6) -> (E,7)
DN (D,3) -> (B,5)
RB (E,7) -> (F,8)
DN (B,5) -> (E,2)
RB (F,8) -> (G,7)
DN (E,2) -> (F,3) (Captura CB)
RB (G,7) -> (H,8)
CN (A,8) -> (C,7)
RB (H,8) -> (G,7)
RN (G,3) -> (G,4)
RB (G,7) -> (G,8)
DN (F,3) -> (D,1)
RB (G,8) -> (F,8)
CN (C,7) -> (D,5)
RB (F,8) -> (G,7)
RN (G,4) -> (F,5)
RB (G,7) -> (G,8)
RN (F,5) -> (G,4)
RB (G,8) -> (G,7)
AN (H,5) -> (F,7)
RB (G,7) -> (H,7)
DN (D,1) -> (C,1)
RB (H,7) -> (H,8)
AN (F,7) -> (E,8)
RB (H,8) -> (H,7)
RN (G,4) -> (F,3)
RB (H,7) -> (G,8)
DN (C,1) -> (C,2)
RB (G,8) -> (F,8)
CN (D,5) -> (C,3)
RB (F,8) -> (G,7)
AN (E,8) -> (A,4)
RB (G,7) -> (G,8)
DN (C,2) -> (E,4)
RB (G,8) -> (F,7)
CN (C,3) -> (D,5)
RB (F,7) -> (F,8)
DN (E,4) -> (G,6) (Ahogamiento)

]

[
Programa 2
Uso de variables. Partida de 10 movimientos.
]
begin_board
	RANDOM_BOARD(16,"original");
end_board
begin_game
	begin_variables
		INT movimientos;
	end_variables
	WRT ("");
	WRT ("Programa 2");
	WRT ("");
	movimientos = 0;
	While_Chess true Play
		If_Chess false Play_If
			MOVE_RANDOMLY_W();
			WRT ("Blanco");
		Play_If_Not
			MOVE_RANDOMLY_B();
			WRT ("Negro");
		End_If_Chess;
		movimientos = movimientos + 1;
	End_While;
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game

@
