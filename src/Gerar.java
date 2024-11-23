import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Gerar {

    public static void main(String[] args) {
        try {           
            Runtime r = Runtime.getRuntime();
            Process p;            
            p = r.exec(new String[]{"java", "-jar", "../jflex-full-1.8.2.jar", "../scanner.flex"}, null, new File("src"));
            System.out.println(p.waitFor());

            Path sourcePath = Paths.get("Scanner.java");
            Path destPath = Paths.get("src/Scanner.java");

            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);

            p = r.exec(new String[]{"java","-jar", "../java-cup-11b.jar", "-parser", "Parser", "-symbols", "Tokens", "../parser.cup"}, null, new File("src"));
            System.out.println(p.waitFor());
        }
        catch(Exception e) { 
            System.out.println(e.getMessage());
        }
    }
    
}
