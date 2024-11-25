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
"definicao_de_cenarios"       { return new Symbol(Tokens.BLOCK_TYPE, yytext()); }
"definicao_de_configuracao"   { return new Symbol(Tokens.BLOCK_TYPE, yytext()); }
/*"definicao_de_acoes"         { return new Symbol(Tokens.BLOCK_TYPE, yytext()); } */

"definicao_de_acoes"         { return new Symbol(Tokens.BLOCK_TYPE_ACTION, yytext()); }
"tipo"					     { return new Symbol(Tokens.IDENTIFICADOR_ACAO_TIPO, yytext()); }
"dados_entrada"			     { return new Symbol(Tokens.DADOS_ENTRADA, yytext()); }

"dados_entrada"              { return new Symbol(Tokens.BLOCK_TYPE, yytext()); }
"acoes"                      { return new Symbol(Tokens.ACOES, yytext()); }
"resultados_esperados"       { return new Symbol(Tokens.RESULTADOS_ESPERADOS, yytext()); }

// Identificador de cenario (procura string cenario_[a-zA-Z0-9_]* { )
cenario_{identificador}       { return new Symbol(Tokens.IDENTIFICADOR_CENARIO, yytext()); }
acao_{identificador}          { return new Symbol(Tokens.IDENTIFICADOR_ACAO, yytext()); }


// Identificador genérico de nome
"nome"						{ return new Symbol(Tokens.NOME, yytext()); }

/* operadores */
"{"                          { return new Symbol(Tokens.LBRACE); }
"}"                          { return new Symbol(Tokens.RBRACE); }
"="                          { return new Symbol(Tokens.EQUALS); }
";"                          { return new Symbol(Tokens.SEMICOLON); }
"("                          { return new Symbol(Tokens.LPAREN); }
")"                          { return new Symbol(Tokens.RPAREN); }

/* Identificadores */
\"[^\"]*\"                  { return new Symbol(Tokens.STRING_LITERAL,yytext().substring(1, yytext().length()-1)); }
{identificador}             { return new Symbol(Tokens.IDENTIFIER, yytext()); }

/* Whitespace */
[ \t\n\r\f]                  { /* Ignore whitespace */ }

/* Invalid characters */
.                            { System.out.println("Illegal character: " + yytext()); }