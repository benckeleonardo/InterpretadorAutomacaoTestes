
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;
import myPackage.Programa;

public class ConfigParser {
    public static void main(String[] args) throws Exception {
        String input = "definicao_de_configuracao";
        
        // Criar o scanner com a entrada
        Scanner scanner = new Scanner(new StringReader(input));

        // print the tokens

        List<Symbol> tokens = new ArrayList<>();
        

        while (true) {
            Symbol token = scanner.next_token();
            tokens.add(token);
            if (token.sym == Tokens.EOF) {
                break;
            }
        }

        for (Symbol token : tokens) {
            System.out.println("Token: " + token.sym + " - " + token.value);
        }
        
        // Criar o parser com o scanner
        Parser parser = new Parser(scanner);
        
        // Realizar o parsing
        Object result = parser.parse();
        
        // Processar o resultado
        if (result instanceof Programa) {
            Programa programa = (Programa) result;
            
            // Exemplo de uso das configurações
            // System.out.println("Ambiente: " + programa.getConfiguracao("ambiente"));
            // System.out.println("URL Base: " + programa.getConfiguracao("url_base"));
        }
    }
}