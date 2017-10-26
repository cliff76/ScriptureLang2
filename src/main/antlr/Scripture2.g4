grammar Scripture2;

scipture : 'In the beginning' (functionDefinition | statement)* 'Amen' ;

statement : expression
    | variableDeclaration
    | assignment
;

expression : (ID | functionCall) oper (ID | functionCall)
    | functionCall
    | assignment
    | ID
    | CONSTANT
;

variableDeclaration : ('There was' | 'Let there be') ID ';'
;

functionDefinition : ID ':' 'Thou shalt' (statement)* 'Amen'
;

assignment : 'Thy' ID 'shall be' expression ';'
;

functionCall : 'Saith unto' ID (expression)? ';'
;

oper : '+' | '-' | '*' | '/' ;
ID : [a-z]+ ;
CONSTANT : [0-9]+
    | '"' [a-z]+ '"'
;

WS  :   [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out