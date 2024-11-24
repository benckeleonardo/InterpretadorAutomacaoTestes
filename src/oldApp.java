import java.io.FileReader;

import java_cup.runtime.Symbol;

public class oldApp {

    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(new FileReader("entrada.txt"));
            System.out.println("Análise Léxica: Lista de Tokens:");
            Symbol s = scanner.next_token();
            while(s.sym != Tokens.EOF){
                System.out.printf("<%d, %s>\n", s.sym, s.value);
                s = scanner.next_token();
            }

            scanner = new Scanner(new FileReader("entrada.txt"));
            Parser parser = new Parser(scanner);        
            parser.parse(); 
        }
        catch(Exception e) { 
            System.out.println(e.getMessage());
        }
    }
    
}
