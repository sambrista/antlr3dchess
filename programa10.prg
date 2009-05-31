[
Programa 10
Partida de ajedrez aleatoria hasta jaque mate o ahogado desde la posicion original y guarda un informe de la partida
]
begin_board
	RANDOM_BOARD(16,"original");
end_board
begin_game
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") Play
		MOVE_RANDOMLY_W();
		MOVE_RANDOMLY_B();
	End_While_Chess;
	MOVEMENTS_LIST();
	STATE("informe.chs");
	STATE_3D("./3D/");
end_game
@


