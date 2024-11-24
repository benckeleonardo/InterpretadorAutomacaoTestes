package myPackage;

public class Entry {
    private String key;
    private String value;
    
    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Entry[" + key + "=\"" + value + "\"]";
    }
}