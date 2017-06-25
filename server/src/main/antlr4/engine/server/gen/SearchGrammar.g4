grammar SearchGrammar;

search_term : (term)+;

term: not_word | exact_word | word ;

exact_word : '"' (word)+ '"';
not_word : '-' (word | exact_word);
word : WORD;

WORD: [a-zA-Z0-9] ~([ \t\r\n"])* ;

WS : [ \t\r\n]+ -> skip ;