package myPackage;
import java.util.ArrayList;
import java.util.List;

// Represents a complete block (like definicao_de_cenarios or definicao_de_configuracao)

public class Block {
    private String type;
    private String name;
    private List<Object> contents;
    
    public Block(String type, String name, List<Object> contents) {
        this.type = type;
        this.name = name;
        this.contents = contents != null ? contents : new ArrayList<>();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Block[type=").append(type);
        if (name != null) {
            sb.append(", name=").append(name);
        }
        sb.append(", contents=").append(contents).append("]");
        return sb.toString();
    }
}