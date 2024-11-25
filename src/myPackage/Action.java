package myPackage;

import java.util.ArrayList;
import java.util.List;


// Represents an action with optional parameters (like preencher_campo_usuario(usuario))
public class Action extends BlockContent {
    // private String value;
    private String name;
    private String parameters;
    
    private String tipo;
    private String rota;
    private String metodo;
    private String seletor;
    private String valor_seletor;
    
    
    public Action(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getParameters() {
        return this.parameters;
    }

    public String getName() {
        return name;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRota() {
        return rota;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getSeletor() {
        return seletor;
    }

    public String getValor_seletor() {
        return valor_seletor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setSeletor(String seletor) {
        this.seletor = seletor;
    }

    public void setValor_seletor(String valor_seletor) {
        this.valor_seletor = valor_seletor;
    }

    // @Override
    // public String toString() {
    //     return "Action[" + name + " - " + this.parameters.toString() + "]";
    // }
    // public List<Parameter> getParameters() { return parameters; }
}