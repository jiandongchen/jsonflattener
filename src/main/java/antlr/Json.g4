grammar Json;

@header {
    package antlr;
}

json
   : value
   ;

pair
   : STRING ':' value
   ;

value
   : STRING                            # String
   | NUMBER                            # Number
   | '{' pair (',' pair)* '}'          # Object
   | '{' '}'                           # EmptyObject
   | '[' value (',' value)* ']'        # Array
   | '[' ']'                           # EmptyArray
   | 'true'                            # True
   | 'false'                           # False
   | 'null'                            # Null
   ;

STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;


fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;


fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;


fragment HEX
   : [0-9a-fA-F]
   ;


fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;


NUMBER
   : '-'? INT ('.' [0-9] +)? EXP?
   ;


fragment INT
   : '0' | [1-9] [0-9]*
   ;

// no leading zeros

fragment EXP
   : [Ee] [+\-]? INT
   ;

// \- since - means "range" inside [...]

TRUE
    : 'true'
    ;

FALSE
    : 'false'
    ;

NULL
    : 'null'
    ;

WS
   : [ \t\n\r] + -> skip
   ;