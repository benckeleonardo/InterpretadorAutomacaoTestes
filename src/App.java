import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static void printToken(Symbol token) {
        String value = token.value != null ? token.value.toString() : "null";
        System.out.printf("Token: <%d, %s> na posição: %d\n", 
            token.sym, value, token.left);
    }

    private static void scanOnly(String filename) {
        System.out.println("\n=== Fase de Análise Léxica ===");
        try (FileReader reader = new FileReader(filename)) {
            Scanner scanner = new Scanner(reader);
            List<Symbol> tokens = new ArrayList<>();
            
            Symbol token;
            while ((token = scanner.next_token()).sym != Tokens.EOF) {
                tokens.add(token);
                printToken(token);
            }
            
            System.out.printf("\nNúmero total de tokens: %d\n", tokens.size());
            
        } catch (IOException e) {
            System.err.println("Erro de arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro de scan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void parseOnly(String filename) {
        System.out.println("\n=== Fase de Análise Sintática ===");
        try (FileReader reader = new FileReader(filename)) {
            Scanner scanner = new Scanner(reader);
            Parser parser = new Parser(scanner);
            
            System.out.println("Iniciando análise sintática...");
            Object result = parser.parse().value;
            
            if (result != null) {
                System.out.println("\nParse completado com sucesso!");
                System.out.println("Resultado do parse:\n");
                System.out.println(result.toString());
            } else {
                System.out.println("\nParse completou e retornou null.");
            }
            
        } catch (IOException e) {
            System.err.println("Erro de arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro de parse: " + e.getMessage());
            System.err.println("Stack trace:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "entrada.txt";

        System.out.println("Arquivo de entrada: " + filename);
        
        try {
            // Faz o scan e mostra os tokens
            scanOnly(filename);
            
            // Faz o parse do arquivo
            parseOnly(filename);
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}