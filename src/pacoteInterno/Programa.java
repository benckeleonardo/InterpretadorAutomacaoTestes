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
                
                if (content instanceof HashMap) {
                    // Caso o conteúdo seja um HashMap
                    HashMap<String, Object> config = (HashMap<String, Object>) content;
                    String ambiente = (String) config.get("ambiente");
                    String urlBase = (String) config.get("url_base");
                    String browser = (String) config.get("browser");
                    
                    // Aqui você pode configurar o ambiente de teste com essas informações
                    System.out.println("Ambiente: " + ambiente);
                    System.out.println("URL base: " + urlBase);
                    System.out.println("Navegador: " + browser);
                } else if (content instanceof ArrayList) {
                    // Caso o conteúdo seja um ArrayList, vamos tentar convertê-lo para HashMap
                    ArrayList<Object> contentList = (ArrayList<Object>) content;
                    HashMap<String, Object> configMap = new HashMap<>();
                    
                    // Verifique se a lista contém dados suficientes para mapear para um HashMap
                    if (contentList.size() >= 3) {
                        configMap.put("ambiente", contentList.get(0));
                        configMap.put("url_base", contentList.get(1));
                        configMap.put("browser", contentList.get(2));
                        
                        // Exibe as informações convertidas
                        System.out.println("Ambiente: " + configMap.get("ambiente"));
                        System.out.println("URL base: " + configMap.get("url_base"));
                        System.out.println("Navegador: " + configMap.get("browser"));
                    } else {
                        System.err.println("Content list does not contain enough elements to form a valid configuration.");
                    }
                } else {
                    System.err.println("Expected content to be either a HashMap or ArrayList but found: " + content.getClass().getName());
                }
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
                "configuracao",
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
                + "\n\nCódigo Python gerado:\n\n" + python_code
                ;
    }
}
