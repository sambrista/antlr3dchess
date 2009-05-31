[
Programa 4
Partida de ajedrez donde se añaden piezas.
]
begin_board
	RANDOM_BOARD(16,"original");
	ADD_PIECE("reina","negro","D",4);
	REMOVE_PIECE("caballo","negro");
	GENERATE_3D_BOARD("./3D/");
end_board
begin_game
	STATE();
	MOVEMENTS_LIST();
end_game
@


[

Salida:

comentario de varias lineas

PIEZAS BLANCAS

E,1 Rey
A,2 Peon
E,2 Peon
H,1 Torre
D,2 Peon
F,2 Peon
C,1 Alfil
G,1 Caballo
C,2 Peon
B,2 Peon
A,1 Torre
F,1 Alfil
D,1 Reina
B,1 Caballo
H,2 Peon
G,2 Peon

PIEZAS NEGRAS

E,8 Rey
H,7 Peon
D,7 Peon
B,7 Peon
E,7 Peon
G,7 Peon
G,8 Caballo
H,8 Torre
C,8 Alfil
C,7 Peon
F,8 Alfil
A,7 Peon
A,8 Torre
D,8 Reina
F,7 Peon
D,4 Reina

SITUACION ACTUAL

Turno: Blanco


Resultado ASA:  begin_board RANDOM_BOARD ( 16 , original ) ; ADD_PIECE ( reina , negro , D , 4 ) ; REMOVE_PIECE ( caballo , negro ) ; GENERATE_3D_BOARD ( ./3D/ ) ; end_board begin_game STATE ( ) ; MOVEMENTS_LIST ( ) ; end_game @
]