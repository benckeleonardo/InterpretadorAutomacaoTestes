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
// "definicao_de_cenarios"      { return new Symbol(Tokens.BLOCK_TYPE_CENARIOS, yytext()); }
// "definicao_de_acoes"         { return new Symbol(Tokens.BLOCK_TYPE_ACOES, yytext()); }
// "definicao_de_configuracao"  { return new Symbol(Tokens.BLOCK_TYPE_CONFIGURACAO, yytext()); }
// "definicao_de_resultados"    { return new Symbol(Tokens.BLOCK_TYPE_RESULTADOS, yytext()); }

definicao_de_{identificador}  { return new Symbol(Tokens.BLOCK, yytext().substring(13)); }

// Identificador de cenario (procura string cenario_[a-zA-Z0-9_]* { )
// cenario_{identificador}       { return new Symbol(Tokens.IDENTIFICADOR_CENARIO, yytext()); }
cenario_{identificador}       { return new Symbol(Tokens.BLOCK, yytext()); }
acao_{identificador}          { return new Symbol(Tokens.BLOCK, yytext()); }
teste_{identificador}         { return new Symbol(Tokens.BLOCK, yytext()); }
resultado_{identificador}     { return new Symbol(Tokens.BLOCK, yytext()); }
cenarios_{identificador}      { return new Symbol(Tokens.BLOCK, yytext()); }
dados_{identificador}         { return new Symbol(Tokens.BLOCK, yytext()); }
acoes                         { return new Symbol(Tokens.BLOCK, yytext()); }
resultados                    { return new Symbol(Tokens.BLOCK, yytext()); }
cenarios                      { return new Symbol(Tokens.BLOCK, yytext()); }

// Identificadores internos de cenário
// "dados_entrada"              { return new Symbol(Tokens.DADOS_ENTRADA_CENARIO, yytext()); }
// "acoes"                      { return new Symbol(Tokens.ACOES_CENARIO, yytext()); }
// "resultados_esperados"       { return new Symbol(Tokens.RESULTADOS_ESPERADOS_CENARIO, yytext()); }

// Identificadores internos de configuração
// "ambiente"       { return new Symbol(Tokens.IDENTIFICADOR_AMBIENTE, yytext()); }
// "url_base"       { return new Symbol(Tokens.IDENTIFICADOR_URL_BASE, yytext()); }
// "browser"        { return new Symbol(Tokens.IDENTIFICADOR_BROWSER, yytext()); }

// Identificadores internos de Teste
// "configuracao"   { return new Symbol(Tokens.IDENTIFICADOR_CONFIGURACAO_TESTE, yytext()); }
// "cenarios"       { return new Symbol(Tokens.IDENTIFICADOR_CENARIOS_TESTE, yytext()); }
// "cenarios"       { return new Symbol(Tokens.STRING_LITERAL, yytext()); }

// Identificadores internos de Ação
// "tipo"                       { return new Symbol(Tokens.IDENTIFICADOR_ACAO_TIPO, yytext()); }


// Identificador genérico de nome
// "nome"              { return new Symbol(Tokens.NOME, yytext()); }

/* operadores */
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

/* Caraacteres não reconhecidos */
.                           { System.out.println("Caractere não reconhecido: " + yytext()); }