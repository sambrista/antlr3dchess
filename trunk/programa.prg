[
Programa 2
Uso de variables. Partida de 10 movimientos.
]
begin_board
	RANDOM_BOARD(16,"original");
end_board
begin_game
	begin_variables
		LOG turno;
		INT movimientos;
	end_variables
	WRT ("");
	WRT ("Programa 2");
	WRT ("");
	movimientos = 0;
		WRT ("3");
	turno = true;
		WRT ("6");
	While_Chess (10 > movimientos) Play
			WRT ("7");
		If_Chess (true == turno) Play_If
				WRT ("8");
			MOVE_RANDOMLY_W();
			turno = false;
		Play_If_Not
				WRT ("0");
			MOVE_RANDOMLY_B();
			turno = true;
		End_If_Chess;
		movimientos = movimientos + 1;
	End_While_Chess;
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game

@
