grammar Configs;

@header {

package org.boxin;
/**
 * @author baka4n
 */
}

options {
    language = Java;
}

all: sy+;
sy: moveL | moveR | plus | ride;
moveL: a='<<' b=INT END;
moveR: a='>>' b=INT END;
plus: a='+' b=INT END ;
ride: a='*' b=INT END;

MOVE: '<<' | '>>';
LINE_COMMENT : '//' .*? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS  : [ \t\r\n]+ -> skip;
END: ';';


FILENAME: SHEETNAME ':' '\\' ( | (SHEETNAME '\\')+) SHEETNAME'.'SHEETNAME ;
INT: [0-9]+;
SHEETNAME: [\u4e00-\u9fa5a-zA-Z0-9]+;
DOUBLE: INT'.'INT;
STRING: '"' .*? '"';