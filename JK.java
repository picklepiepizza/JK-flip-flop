public class JK {
    
    boolean set;
    boolean reset;
    boolean preset;
    boolean clear;
    boolean output;
    
    public void setValues(set, reset, preset, clear) {
        self.set = set;
        self.reset = reset;
        self.preset = preset;
        self.clear = clear;
    }
    
    public void clock() {
        
        if (preset == false && clear == false) {
            self.q = true
            self.qnot = true
        } else if (preset == false && clear == true) {
            self.q = true
            self.qnot = false
        } else if (preset == true && clear == false) {
            self.q = false
            self.qnot = true
        } else if (preset == true && clear == true) {
            
            if (set == false && reset == true) {
                self.q = false;
                self.qnot = true;
            } else if (set == true && reset == false) {
                self.q = true;
                self.qnot = false;
            } else if (set == true && reset == true) {
                self.q = !self.q;
                self.qnot = !self.qnot;
            }
            
        }
        
    }
    
    public boolean get() {
        return currentValue;
    }
    
}
