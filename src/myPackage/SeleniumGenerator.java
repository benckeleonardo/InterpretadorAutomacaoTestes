package myPackage;

import java.util.ArrayList;
import java.util.List;

// Main parser result class to hold the entire parsed structure
public class SeleniumGenerator {
    private List<Block> blocks;
    
    public SeleniumGenerator(List<Block> blocks) {
        this.blocks = blocks != null ? blocks : new ArrayList<>();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : blocks) {
            sb.append(block.toString()).append("\n\n");
        }
        return sb.toString();
    }

    // Helper method to find specific block types
    public List<Block> getBlocksByType(String type) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getType().equals(type)) {
                result.add(block);
            }
        }
        return result;
    }

    public List<Block> getBlocks() { return blocks; }
}