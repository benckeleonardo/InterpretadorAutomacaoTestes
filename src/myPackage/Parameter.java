package myPackage;
public class Parameter {
    private String value;
    
    public Parameter(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }

    public String getValue() { return value; }
}