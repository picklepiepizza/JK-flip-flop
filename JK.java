public class JK {
    
    boolean set;
    boolean reset;
    boolean preset;
    boolean clear;
    boolean output;
    
    public JK() {
        
    }
    
    public void setValues(set, reset, preset, clear) {
        self.set = set;
        self.reset = reset;
        self.preset = preset;
        self.clear = clear;
    }
    
    public void clock() {
        
    }
    
    public boolean get() {
        return currentValue;
    }
    
}
