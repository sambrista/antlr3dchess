[
Programa 9
Partida de ajedrez de 1 contra 1 o contra la maquina 
]
begin_board
	RANDOM_BOARD(16,"original");
end_board
begin_game
	begin_variables
		INT jugadores, filao, filad;
		STR columnao, columnad;
	end_variables
	WRT("Introduzca el numero de jugadores (1-2)");
	jugadores = READ_NUMBER();
	While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") Play
		%Jugador blanco
		STATE();
		WRT("Introduzca la fila de origen (1-8)");
		filao = READ_NUMBER();
		WRT("Introduzca la columna de origen (A-H)");
		columnao = READ_STR();
		WRT("Introduzca la fila de destino (1-8)");
		filad = READ_NUMBER();
		WRT("Introduzca la columna de destino (A-H)");
		columnad = READ_STR();
		MOVE_PLAYER_W(columnao,filao, columnad, filad);
		%Jugador negro
		If_Chess ( 1 < jugadores )&& !CHECKMATE("blanco")  && !STALEMATE("negro") && !CHECKMATE("negro") Play_If
			STATE();
			WRT("Introduzca la fila de origen (1-8)");
			filao = READ_NUMBER();
			WRT("Introduzca la columna de origen (A-H)");
			columnao = READ_STR();
			WRT("Introduzca la fila de destino (1-8)");
			filad = READ_NUMBER();
			WRT("Introduzca la columna de destino (A-H)");
			columnad = READ_STR();
			WRT(columnad);
			MOVE_PLAYER_B(columnao,filao, columnad, filad);
		Play_If_Not
			MOVE_RANDOMLY_B();
		End_If_Chess;
	End_While_Chess;
	WRT("Fin de la partida");
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game
@