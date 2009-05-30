[
Programa 2
Partida de ajedrez de jaque mate pastor
]

begin_board
RANDOM_BOARD(16,"original");
end_board
begin_game 
STATE();
MOVE_PLAYER_W("E",2,"E",3);
MOVE_PLAYER_B("A",7,"A",5);
MOVE_PLAYER_W("D",1,"H",5);
MOVE_PLAYER_B("H",7,"H",6);
MOVE_PLAYER_W("F",1,"C",4);
MOVE_PLAYER_B("A",8,"A",6);
MOVE_PLAYER_W("H",5,"F",7);
STATE_3D("./3D/");
MOVEMENTS_LIST();
end_game
@

[

Salida:

PIEZAS BLANCAS

E,1 Rey
G,2 Peon
H,2 Peon
E,2 Peon
D,2 Peon
D,1 Reina
C,1 Alfil
A,2 Peon
A,1 Torre
F,1 Alfil
H,1 Torre
B,1 Caballo
G,1 Caballo
B,2 Peon
C,2 Peon
F,2 Peon

PIEZAS NEGRAS

E,8 Rey
H,7 Peon
F,8 Alfil
B,7 Peon
H,8 Torre
E,7 Peon
D,7 Peon
C,8 Alfil
B,8 Caballo
A,7 Peon
D,8 Reina
F,7 Peon
G,7 Peon
A,8 Torre
G,8 Caballo
C,7 Peon

SITUACION ACTUAL

Turno: Blanco
Archivo generado

PB (E,2) -> (E,3)
PN (A,7) -> (A,5)
DB (D,1) -> (H,5)
PN (H,7) -> (H,6)
AB (F,1) -> (C,4)
TN (A,8) -> (A,6)
DB (H,5) -> (F,7) (Captura PN) (Jaque Mate)

Resultado ASA:  begin_board RANDOM_BOARD ( 16 , original ) ; end_board begin_game STATE ( ) ; MOVE_PLAYER_W ( E , 2 , E , 3 ) ; MOVE_PLAYER_B ( A , 7 , A , 5 ) ; MOVE_PLAYER_W ( D , 1 , H , 5 ) ; MOVE_PLAYER_B ( H , 7 , H , 6 ) ; MOVE_PLAYER_W ( F , 1 , C , 4 ) ; MOVE_PLAYER_B ( A , 8 , A , 6 ) ; MOVE_PLAYER_W ( H , 5 , F , 7 ) ; STATE_3D ( ./3D/ ) ; MOVEMENTS_LIST ( ) ; end_game @

]