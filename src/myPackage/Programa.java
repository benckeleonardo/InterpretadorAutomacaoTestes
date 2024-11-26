package myPackage;

import java.util.HashMap;
import java.util.Map;

public class Programa {
    private Map<String, String> configuracoes = new HashMap<>();
    
    public void adicionarConfiguracao(String chave, String valor) {
        configuracoes.put(chave, valor);
    }
    
    // Métodos para recuperar e manipular configurações
    public String getConfiguracao(String chave) {
        return configuracoes.get(chave);
    }
    
    // Outros métodos conforme necessário
}