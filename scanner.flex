// scanner.flex
import java_cup.runtime.Symbol;

/*
Directivas:
public: classe publica
cup: compatibilidade com cup
full: estende o alfabeto com todos os valores de 8 bits
linha: adicionar a variável int yyline, para indicar a linha do lexema
char: adicionar a variável int yychar, para indicar o índice do primeiro caractere do lexema
ignorecase: validar, independentemente de a letra ser maiúscula ou minúscula
eofval: especifica um valor de retorno no final do arquivo
*/

%%

%class Scanner
%cup
%full
%line
%char
%eofval{
	return new Symbol(Tokens.EOF,new String("Fim do arquivo"));
%eofval}

digito = [0-9]
letra = [a-zA-Z]
id = {letra}({letra}|{digito}|"_")*
espaco = \t|\f|" "|\r|\n
identificador = [a-zA-Z][a-zA-Z0-9_]*

%%

/* Identificadores de blocos */
definicao_de_{identificador}  { return new Symbol(Tokens.BLOCK, yytext().substring(13)); }
cenario_{identificador}       { return new Symbol(Tokens.BLOCK, yytext()); }
acao_{identificador}          { return new Symbol(Tokens.BLOCK, yytext()); }
teste_{identificador}         { return new Symbol(Tokens.BLOCK, yytext()); }
resultado_{identificador}     { return new Symbol(Tokens.BLOCK, yytext()); }
cenarios_{identificador}      { return new Symbol(Tokens.BLOCK, yytext()); }
dados_{identificador}         { return new Symbol(Tokens.BLOCK, yytext()); }
acoes                         { return new Symbol(Tokens.BLOCK, yytext()); }
resultados                    { return new Symbol(Tokens.BLOCK, yytext()); }
cenarios                      { return new Symbol(Tokens.BLOCK, yytext()); }

/* Operadores */
"{"                          { return new Symbol(Tokens.LBRACE); }
"}"                          { return new Symbol(Tokens.RBRACE); }
"="                          { return new Symbol(Tokens.EQUALS); }
";"                          { return new Symbol(Tokens.SEMICOLON); }
"("                          { return new Symbol(Tokens.LPAREN); }
")"                          { return new Symbol(Tokens.RPAREN); }
"["                          { return new Symbol(Tokens.LBRACKET); }
"]"                          { return new Symbol(Tokens.RBRACKET); }
"\n"                         { return new Symbol(Tokens.LINHA, yytext());}

/* Identificadores */
\"[^\"]*\"                  { return new Symbol(Tokens.STRING_LITERAL,yytext().substring(1, yytext().length()-1)); }
{identificador}             { return new Symbol(Tokens.IDENTIFICADOR, yytext()); }
{digito}+                   { return new Symbol(Tokens.NUMERAL, yytext()); }

/* Espaços em branco */
{espaco}+                   { /* Ignora espaços em branco */ }

/* Caracteres não reconhecidos / inválidos */
.                           { System.out.println("Caractere não reconhecido: " + yytext()); }