
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import myPackage.Programa;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Tokens.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\012\005\000\002\002\004\000\002\002" +
    "\005\000\002\006\006\000\002\005\003\000\002\005\004" +
    "\000\002\005\003\000\002\005\004\000\002\010\003\000" +
    "\002\010\003\000\002\010\004\000\002\010\004\000\002" +
    "\011\003\000\002\011\004\000\002\007\006\000\002\007" +
    "\006\000\002\004\003\000\002\004\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\004\006\004\001\002\000\004\017\010\001" +
    "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
    "\000\006\007\031\017\010\001\002\000\004\004\012\001" +
    "\002\000\006\007\ufff5\017\ufff5\001\002\000\010\015\014" +
    "\016\016\017\010\001\002\000\012\005\027\015\014\016" +
    "\016\017\010\001\002\000\004\010\023\001\002\000\012" +
    "\005\ufff9\015\ufff9\016\ufff9\017\ufff9\001\002\000\004\010" +
    "\020\001\002\000\012\005\ufff8\015\ufff8\016\ufff8\017\ufff8" +
    "\001\002\000\004\014\021\001\002\000\004\011\022\001" +
    "\002\000\012\005\ufff2\015\ufff2\016\ufff2\017\ufff2\001\002" +
    "\000\004\014\024\001\002\000\004\011\025\001\002\000" +
    "\012\005\ufff3\015\ufff3\016\ufff3\017\ufff3\001\002\000\012" +
    "\005\ufff7\015\ufff7\016\ufff7\017\ufff7\001\002\000\014\005" +
    "\ufffe\007\ufffe\015\ufffe\016\ufffe\017\ufffe\001\002\000\012" +
    "\005\ufff6\015\ufff6\016\ufff6\017\ufff6\001\002\000\004\002" +
    "\001\001\002\000\006\007\ufff4\017\ufff4\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\004\012\004\001\001\000\006\006\010\011" +
    "\006\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\006\031\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\006\016\007\014\010\012\001\001\000\006\006\027" +
    "\007\025\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
  
    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

    Symbol token = s.next_token();

    // se token.value for null, então token_str = token.toString()
    String token_str = token.value == null ? token.toString() : token.value.toString();

    System.out.println("Token: " + token_str + " - " + token.sym);
    System.out.println("Erro encontrado: " + error);

    if(error){
        error = false;
       System.out.println("---"+descricao_erro+"---");
    }
    // return s.next_token(); 
    return token; 

    }


    // conectar esse parser ao scanner!
    Scanner s;
    Parser(Scanner s){ this.s=s; }

    String teste = "teste";
    int count = 0;
    int lines = 1;

    boolean debug = false;
    boolean error = false;
    String descricao_erro = "";
    
    // tabela de símbolos
    java.util.Map<String, Integer> simbolos = new java.util.HashMap<String, Integer>();


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // inicio ::= LBRACKET blocos_genericos RBRACKET 
            {
              Object RESULT =null;
		int blocosleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int blocosright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<HashMap<String,Object>> blocos = (List<HashMap<String,Object>>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        System.out.println("Programa final com blocos: " + blocos);
        RESULT = blocos; 
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // input ::= LBRACKET blocos_genericos RBRACKET 
            {
              Object RESULT =null;
		int blleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int blright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<HashMap<String,Object>> bl = (List<HashMap<String,Object>>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        System.out.println("Parsed multiple blocks: " + bl);
        RESULT = bl;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("input",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // bloco_generico ::= BLOCK LBRACE chaves_valor_ou_blocos RBRACE 
            {
              HashMap<String,Object> RESULT =null;
		int blocoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int blocoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String bloco = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int conteudoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int conteudoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<Object> conteudo = (List<Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        HashMap<String, Object> map = new HashMap<>();
        map.put("block_type", bloco);
        map.put("content", conteudo);
        RESULT = map;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bloco_generico",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // conteudo_bloco_aninhado ::= chave_valor 
            {
              List<Object> RESULT =null;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> conteudo = new ArrayList<>();
        conteudo.add(cv); // Adiciona um par chave-valor
        RESULT = conteudo;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conteudo_bloco_aninhado",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // conteudo_bloco_aninhado ::= conteudo_bloco_aninhado chave_valor 
            {
              List<Object> RESULT =null;
		int conteudoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int conteudoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<Object> conteudo = (List<Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        conteudo.add(cv); // Adiciona mais pares chave-valor
        RESULT = conteudo;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conteudo_bloco_aninhado",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // conteudo_bloco_aninhado ::= bloco_generico 
            {
              List<Object> RESULT =null;
		int bgleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bgright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bg = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> conteudo = new ArrayList<>();
        conteudo.add(bg); // Adiciona um bloco
        RESULT = conteudo;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conteudo_bloco_aninhado",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // conteudo_bloco_aninhado ::= conteudo_bloco_aninhado bloco_generico 
            {
              List<Object> RESULT =null;
		int conteudoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int conteudoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<Object> conteudo = (List<Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bgleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bgright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bg = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        conteudo.add(bg); // Adiciona mais blocos
        RESULT = conteudo;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conteudo_bloco_aninhado",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // chaves_valor_ou_blocos ::= chave_valor 
            {
              List<Object> RESULT =null;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> list = new ArrayList<>();
        list.add(cv);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor_ou_blocos",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // chaves_valor_ou_blocos ::= bloco_generico 
            {
              List<Object> RESULT =null;
		int bgleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bgright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bg = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> list = new ArrayList<>();
        list.add(bg);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor_ou_blocos",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // chaves_valor_ou_blocos ::= chaves_valor_ou_blocos chave_valor 
            {
              List<Object> RESULT =null;
		int cvbleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cvbright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<Object> cvb = (List<Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> list = new ArrayList<>(cvb);
        list.add(cv);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor_ou_blocos",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // chaves_valor_ou_blocos ::= chaves_valor_ou_blocos bloco_generico 
            {
              List<Object> RESULT =null;
		int cvbleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cvbright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<Object> cvb = (List<Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bgleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bgright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bg = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<Object> list = new ArrayList<>(cvb);
        list.add(bg);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor_ou_blocos",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // blocos_genericos ::= bloco_generico 
            {
              List<HashMap<String,Object>> RESULT =null;
		int blocoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int blocoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bloco = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<HashMap<String, Object>> list = new ArrayList<>();
        list.add(bloco);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("blocos_genericos",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // blocos_genericos ::= blocos_genericos bloco_generico 
            {
              List<HashMap<String,Object>> RESULT =null;
		int blocosleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int blocosright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<HashMap<String,Object>> blocos = (List<HashMap<String,Object>>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int blocoleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int blocoright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,Object> bloco = (HashMap<String,Object>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        List<HashMap<String, Object>> list = new ArrayList<>(blocos);
        list.add(bloco);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("blocos_genericos",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // chave_valor ::= IDENTIFICADOR EQUALS STRING_LITERAL SEMICOLON 
            {
              HashMap<String,String> RESULT =null;
		int chaveleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int chaveright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String chave = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        HashMap<String, String> map = new HashMap<>();
        map.put(chave, valor);
        System.out.println("Chave: " + chave + ", Valor: " + valor);
        RESULT = map;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chave_valor",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // chave_valor ::= NUMERAL EQUALS STRING_LITERAL SEMICOLON 
            {
              HashMap<String,String> RESULT =null;
		int chaveleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int chaveright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String chave = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        HashMap<String, String> map = new HashMap<>();
        map.put(String.valueOf(chave), valor); // Converta o NUMERAL para String
        System.out.println("Chave (numérica): " + chave + ", Valor: " + valor);
        RESULT = map;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chave_valor",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // chaves_valor ::= chave_valor 
            {
              List<HashMap<String,String>> RESULT =null;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        System.out.println("Chave: " + cv.keySet().toArray()[0] + ", Valor: " + cv.values().toArray()[0]);
        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(cv);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // chaves_valor ::= chaves_valor chave_valor 
            {
              List<HashMap<String,String>> RESULT =null;
		int cvleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cvright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		List<HashMap<String,String>> cv = (List<HashMap<String,String>>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int cv2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cv2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		HashMap<String,String> cv2 = (HashMap<String,String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
        System.out.println("Chave: " + cv2.keySet().toArray()[0] + ", Valor: " + cv2.values().toArray()[0]);
        List<HashMap<String, String>> list = new ArrayList<>();
        list.addAll(cv);
        list.add(cv2);
        RESULT = list;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("chaves_valor",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
