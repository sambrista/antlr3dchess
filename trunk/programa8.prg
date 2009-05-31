[
Programa 8
Partida de ajedrez donde se eliminan las reinas de ambos jugadores y obtenemos el tipo y el color de una pieza
]
begin_board
	RANDOM_BOARD(16,"original");
	REMOVE_PIECE("reina","blanco");
	REMOVE_PIECE("reina","negro");
	GENERATE_3D_BOARD("./3D/");
end_board
begin_game
	begin_variables
		STR ficha;
		STR color;
	end_variables
	ficha=PIECE_COLOR("A",1);
	color=PIECE_TYPE("A",1);
	WRT ("El color de la A 1 es: " + color);
	WRT ("El tipo de la pieza A 1 es: " + ficha);
end_game
@

[

SALIDA:

comentario de varias lineas
  WRITE -> El color de la A 1 es 
  WRITE -> Blanco
  WRITE -> El tipo de la pieza A 1 es 
  WRITE -> Torre

Resultado ASA:  begin_board RANDOM_BOARD ( 16 , original ) ; REMOVE_PIECE ( reina , blanco ) ; REMOVE_PIECE ( reina , negro ) ; GENERATE_3D_BOARD ( ./3D/ ) ; end_board begin_game begin_variables STR ficha ; STR color ; end_variables ficha = PIECE_COLOR ( A , 1 ) ; color = PIECE_TYPE ( A , 1 ) ; WRT ( El color de la A 1 es  ) ; WRT ( color ) ; WRT ( El tipo de la pieza A 1 es  ) ; WRT ( ficha ) ; end_game @

]