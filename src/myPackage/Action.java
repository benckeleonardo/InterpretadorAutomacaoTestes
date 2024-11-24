package myPackage;

import java.util.ArrayList;
import java.util.List;


// Represents an action with optional parameters (like preencher_campo_usuario(usuario))
public class Action extends BlockContent {
    private String key;
    // private String value;
    private String name;
    private List<Parameter> parameters;
    
    public Action(String name, List<Parameter> parameters) {
        this.name = name;
        this.parameters = parameters != null ? parameters : new ArrayList<>();
    }
    
    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder(name).append("(");
    //     for (int i = 0; i < parameters.size(); i++) {
    //         if (i > 0) sb.append(", ");
    //         sb.append(parameters.get(i));
    //     }
    //     sb.append(");");
    //     return sb.toString();
    // }

    @Override
    public String toString() {
        return "Action[" + name + " - " + this.parameters.toString() + "]";
    }
    public List<Parameter> getParameters() { return parameters; }
}