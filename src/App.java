import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static void printToken(Symbol token) {
        String value = token.value != null ? token.value.toString() : "null";
        System.out.printf("Token: <%d, %s> at position: %d\n", 
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
            
            System.out.printf("\nTotal tokens found: %d\n", tokens.size());
            
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Scanning Error: " + e.getMessage());
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
            System.err.println("File Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Parsing Error: " + e.getMessage());
            System.err.println("Stack trace:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "entrada.txt";

        System.out.println("Arquivo de entrada: " + filename);
        
        try {
            // First pass: Just scan and show tokens
            scanOnly(filename);
            
            // Second pass: Full parsing
            parseOnly(filename);
            
        } catch (Exception e) {
            System.err.println("Fatal Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}