package pacoteInterno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Programa {
    private List<HashMap<String, Object>> blocos;
    private String python_code;  // Propriedade para armazenar o código Python

    public Programa(List<HashMap<String, Object>> blocosGenericos) {
        this.blocos = blocosGenericos;
        verifyBlocks();  // Verifica se os blocos necessários estão presentes
        setupSeleniumHeaders();  // Inicializa o cabeçalho do código Python
        processBlocos();
    }

    private void processBlocos() {
        for (HashMap<String, Object> bloco : blocos) {
            String blockType = (String) bloco.get("block_type");
            if (blockType.equals("configuracao")) {
                Object content = bloco.get("content");
    
                // Verifique se o conteúdo é uma lista
                if (content instanceof ArrayList) {
                    ArrayList<HashMap<String, Object>> contentList = (ArrayList<HashMap<String, Object>>) content;
                    HashMap<String, Object> configMap = new HashMap<>();
    
                    // Mescla todos os HashMap dentro da lista em um único HashMap
                    for (HashMap<String, Object> map : contentList) {
                        configMap.putAll(map);  // Adiciona as chaves e valores do HashMap atual ao configMap
                    }
    
                    // Agora, 'configMap' contém todos os valores combinados da lista
                    System.out.println("========================================");
                    System.out.println(configMap);  // Exibe o HashMap combinado
                    System.out.println("========================================");
    
                    // Exemplo de uso: acessar as informações
                    String ambiente = (String) configMap.get("ambiente");
                    String urlBase = (String) configMap.get("url_base");
                    String browser = (String) configMap.get("browser");
    
                    System.out.println("Ambiente: " + ambiente);
                    System.out.println("URL base: " + urlBase);
                    System.out.println("Navegador: " + browser);
    
                    // Processa o bloco de configuração para setup do driver
                    processConfigurationBlock(browser);
                } else {
                    System.err.println("O conteúdo não é uma lista, mas sim de tipo: " + content.getClass().getName());
                }
            }
        }
    }
    
    // Método para processar o bloco de configuração e definir o driver
    private void processConfigurationBlock(String browser) {
        if (browser != null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    this.python_code += "\n# Configuração do Selenium para o Chrome\n";
                    this.python_code += "driver = webdriver.Chrome()\n";
                    break;
                default:
                    System.err.println("Navegador não suportado: " + browser);
            }
        }
    }

    // Método para inicializar o cabeçalho do código Python
    private void setupSeleniumHeaders() {
        this.python_code = "# Importando bibliotecas necessárias para o Selenium\n";
        this.python_code += "from selenium import webdriver\n";
        this.python_code += "from selenium.webdriver.common.by import By\n";
        this.python_code += "from selenium.webdriver.common.keys import Keys\n";
        this.python_code += "import time\n\n";
        
        // Adiciona um cabeçalho básico explicando a finalidade do código
        this.python_code += "# Este código foi gerado para realizar um teste automatizado de login usando Selenium\n";
    }

    // Método para verificar se os tipos de blocos necessários estão presentes
    public List<String> verifyBlocks() {
        List<String> missingBlocks = new ArrayList<>();
        List<String> requiredBlockTypes = List.of(
                "cenarios",
                "teste_completo",
                "acoes",
                "resultados",
                "configuracao", // OK
                "resultados_cenario"
        );

        // Verifica cada tipo de bloco necessário
        for (String requiredBlockType : requiredBlockTypes) {
            boolean found = false;
            for (HashMap<String, Object> bloco : blocos) {
                String blockType = (String) bloco.get("block_type");
                if (requiredBlockType.equals(blockType)) {
                    found = true;
                    break;
                }
            }
            // Se o bloco necessário não for encontrado, adiciona à lista de faltantes
            if (!found) {
                missingBlocks.add(requiredBlockType);
            }
        }

        return missingBlocks;
    }

    // Getter e setter para blocos
    public List<HashMap<String, Object>> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<HashMap<String, Object>> blocos) {
        this.blocos = blocos;
    }

    // Getter para o código Python gerado
    public String getPythonCode() {
        return python_code;
    }

    // Exemplo de método para adicionar um novo bloco
    public void addBloco(HashMap<String, Object> bloco) {
        this.blocos.add(bloco);
    }

    @Override
    public String toString() {
        return "Programa{" +
                "blocos=" + blocos +
                '}'
                + "\n\nCódigo Python gerado:\n\n" + python_code;
    }
}
