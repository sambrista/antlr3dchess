begin_board
	RANDOM_BOARD(10,1.5,"random");
end_board
begin_game
	[While_Chess !CHECKMATE("blanco") && !STALEMATE("blanco") && !CHECKMATE("negro") && !STALEMATE("negro") Play
		MOVE_RANDOMLY_W();
		MOVE_RANDOMLY_B();
	End_While_Chess;]
	WRT ("HEY");
	While_Chess true Play
		WRT ("hola");
	End_While_Chess;
	WRT ("HEdd");
	STATE();
	MOVEMENTS_LIST();
	STATE_3D("./3D/");
end_game
@
