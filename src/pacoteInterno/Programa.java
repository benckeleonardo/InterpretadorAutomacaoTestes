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
        setupConfig();  // Configura o driver Selenium
        instantiateTestClass();  // Inicia a classe de teste em Selenium
        processBlocos();
    }

    private void processBlocos() {
        for (HashMap<String, Object> bloco : blocos) {
            String blockType = (String) bloco.get("block_type");
            if (blockType.equals("acoes")) {
                processActionBlocks((List<HashMap<String, Object>>) bloco.get("content"));
            } else if (blockType.equals("resultados")) {
                processResultsBlocks((List<HashMap<String, Object>>) bloco.get("content"));
            }
        }
    }

    private void setupConfig() {
        for (HashMap<String, Object> bloco : blocos) {
            String blockType = (String) bloco.get("block_type");
            if (blockType.equals("configuracao")) {
                // pega o content
                List<HashMap<String, Object>> content = (List<HashMap<String, Object>>) bloco.get("content");
    
                // Processa cada item do conteúdo
                for (HashMap<String, Object> item : content) {
                    processConfigurationBlock((String) item.get("browser"));
                }
            }
        }
    }

    private void processActionBlocks(List<HashMap<String, Object>> actions) {
        System.out.println("========================================");
        System.out.println("Ações:");
        System.out.println(actions);
        System.out.println("========================================");
    
        // Itera sobre a lista de ações fornecida
        for (HashMap<String, Object> action : actions) {
            String actionName = (String) action.get("block_type");
            List<HashMap<String, Object>> content = (List<HashMap<String, Object>>) action.get("content");
    
            System.out.println("========================================");
            System.out.println("Ação: " + actionName);
            System.out.println("Conteúdo:");
            System.out.println(content);
            System.out.println("========================================");
    
            // Inicializa as variáveis para armazenar as informações
            String tipo = null;
            String rota = null;
            String seletor = null;
            String valorSeletor = null;
            String param = null;
    
            // Processa cada item do conteúdo
            for (HashMap<String, Object> item : content) {
                if (item.containsKey("tipo")) {
                    tipo = (String) item.get("tipo");
                }
                if (item.containsKey("rota")) {
                    rota = (String) item.get("rota");
                }
                if (item.containsKey("seletor")) {
                    seletor = (String) item.get("seletor");
                }
                if (item.containsKey("valor_seletor")) {
                    valorSeletor = (String) item.get("valor_seletor");
                }
                if (item.containsKey("param")) {
                    param = (String) item.get("param");
                }
            }
    
            // Agora processamos com base no tipo
            if (tipo != null) {
                switch (tipo) {
                    case "navegacao":
                        if (rota != null) {
                            python_code += "\n    def " + actionName + "(self):\n";
                            python_code += "        driver = self.driver\n";
                            python_code += "        driver.get(url_base + \"" + rota + "\")\n";
                            python_code += "        self.assertIn(\"Python\", driver.title)\n";
                            python_code += "        elem = driver.find_element(By.NAME, \"q\")\n";
                            python_code += "        elem.send_keys(\"pycon\")\n";
                            python_code += "        elem.send_keys(Keys.RETURN)\n";
                            python_code += "        self.assertNotIn(\"No results found.\", driver.page_source)\n";
                        } else {
                            System.err.println("Erro: faltando rota para " + actionName);
                        }
                        break;
    
                    case "input":
                        if (seletor != null && valorSeletor != null) {
                            python_code += "\n    def " + actionName + "(self):\n";
                            python_code += "        driver = self.driver\n";
                            python_code += "        elem = driver.find_element(By." + seletor.toUpperCase() + ", \"" + valorSeletor + "\")\n";
                            python_code += "        elem.send_keys(\"" + (param != null ? param : "algum valor") + "\")\n";
                        } else {
                            System.err.println("Erro: faltando seletor ou valor_seletor para " + actionName);
                        }
                        break;
    
                    case "clique":
                        if (seletor != null && valorSeletor != null) {
                            python_code += "\n    def " + actionName + "(self):\n";
                            python_code += "        driver = self.driver\n";
                            python_code += "        elem = driver.find_element(By." + seletor.toUpperCase() + ", \"" + valorSeletor + "\")\n";
                            python_code += "        elem.click()\n";
                        } else {
                            System.err.println("Erro: faltando seletor ou valor_seletor para " + actionName);
                        }
                        break;
    
                    default:
                        System.err.println("Tipo de ação não suportado: " + tipo + " para " + actionName);
                }
            } else {
                System.err.println("Erro: Tipo de ação não especificado para " + actionName);
            }
        }
    }
    

    private void processResultsBlocks(List<HashMap<String, Object>> results) {
        for (HashMap<String, Object> result : results) {
            String resultName = (String) result.get("block_type");
            List<HashMap<String, Object>> content = (List<HashMap<String, Object>>) result.get("content");

            String seletor = null;
            String valorSeletor = null;

            for (HashMap<String, Object> item : content) {
                if (item.containsKey("seletor")) {
                    seletor = (String) item.get("seletor");
                }
                if (item.containsKey("valor_seletor")) {
                    valorSeletor = (String) item.get("valor_seletor");
                }
            }

            if (seletor != null && valorSeletor != null) {
                python_code += "\n    def " + resultName + "(self):\n";
                python_code += "        driver = self.driver\n";
                python_code += "        elem = driver.find_element(By." + seletor.toUpperCase() + ", \"" + valorSeletor + "\")\n";
                python_code += "        self.assertTrue(elem.is_displayed())\n";
            } else {
                System.err.println("Erro: faltando seletor ou valor_seletor para " + resultName);
            }
        }
    }


    
    // Método para iniciar a classe de teste em Selenium
    private void instantiateTestClass() {
        this.python_code += "\n# Iniciando a classe de teste\n";
        this.python_code += "class TesteAutomatizado:\n";
        this.python_code += "    def __init__(self, driver):\n";
        this.python_code += "        self.driver = driver\n";
        this.python_code += "\n";
        this.python_code += "    def executar_teste(self):\n";
        this.python_code += "        # Adicione aqui os métodos de teste\n";
        this.python_code += "        pass\n";
    }

    // Getter e setter para blocos
    public List<HashMap<String, Object>> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<HashMap<String, Object>> blocos) {
        this.blocos = blocos;
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