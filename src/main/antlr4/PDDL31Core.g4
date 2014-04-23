lexer grammar PDDL31Core;

NAME: LETTER ANYCHAR*;
fragment LETTER: [a-zA-Z];
fragment ANYCHAR: LETTER | DIGIT | '-' | '_';
fragment NUMBER: DIGIT+ DECIMAL?;
fragment DIGIT:  [0-9];
fragment DECIMAL: '.' DIGIT+;

LINECOMMENT: (';'|'//') ~('\n'|'\r')* '\r'? '\n' -> skip;
WS: [ \n\t\r]+ -> skip;
