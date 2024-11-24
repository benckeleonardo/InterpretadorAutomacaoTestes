package myPackage;

import java.util.ArrayList;
import java.util.List;

public class TestParser {
    public static void main(String[] args) {
        // Create a sample structure programmatically to test the classes
        List<BlockContent> configContents = new ArrayList<>();
        configContents.add(new Entry("ambiente", "teste"));
        configContents.add(new Entry("url_base", "https://www.example.com/"));
        configContents.add(new Entry("browser", "chrome"));
        Block configBlock = new Block("definicao_de_configuracao", null, configContents);

        List<BlockContent> scenarioContents = new ArrayList<>();
        scenarioContents.add(new Entry("nome", "Login de usuário válido"));
        
        List<BlockContent> actionContents = new ArrayList<>();
        List<Parameter> params = new ArrayList<>();
        params.add(new Parameter("usuario"));
        actionContents.add(new Action("preencher_campo_usuario", params));
        actionContents.add(new Action("clicar_botao_login", new ArrayList<>()));
        
        Block actionsBlock = new Block("acoes", null, actionContents);
        scenarioContents.add(actionsBlock);
        
        Block scenarioBlock = new Block("cenario_login", null, scenarioContents);
        
        List<Block> allBlocks = new ArrayList<>();
        allBlocks.add(configBlock);
        allBlocks.add(scenarioBlock);
        
        ParseResult result = new ParseResult(allBlocks);
        
        // Print the entire structure
        System.out.println(result.toString());
    }
}