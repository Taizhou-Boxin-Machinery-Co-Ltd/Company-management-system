grammar BXEXCEL;

@header {

package union.xenfork.news;
/**
 * @author baka4n
 */
}

options {
    language = Java;
}

LINE_COMMENT : '//' .*? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS  : [ \t\r\n]+ -> skip;
END: ';';
all: c1+;
c1: cc1+;
cc1: fileName=FILENAME '{' sheet ((',' sheet)+ | ) '}' END;
sheet:  sheetName=SHEETNAME '{' (((xlsx_x | xlxs_xa) ((',' (xlsx_x | xlxs_xa))+ | )) | ) '}' ;
xlsx_x:  x=INT ('{' xlsx_a (',' xlsx_a)+ '}' | xlsx_a)   ;
xlsx_a: y=SHEETNAME (int=INT | double=DOUBLE | string=STRING);
xlxs_xa: xa=SHEETNAME (int=INT | double=DOUBLE | string=STRING);

FILENAME: SHEETNAME ':' '\\' ( | (SHEETNAME '\\')+) SHEETNAME'.'SHEETNAME ;
INT: [0-9]+;
SHEETNAME: [\u4e00-\u9fa5a-zA-Z0-9]+;
DOUBLE: INT'.'INT;
STRING: '"' .*? '"';