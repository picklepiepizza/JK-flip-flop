public class JK {
    
    boolean set;
    boolean reset;
    boolean preset;
    boolean clear;
    boolean q;
    boolean qnot;
    
    
    public void setValues(boolean set, boolean reset, boolean preset, boolean clear) {
        this.set = set;
        this.reset = reset;
        this.preset = preset;
        this.clear = clear;
    }
    
    public void clock() {
        
        if (this.preset == false && this.clear == false) {
            this.q = true;
            this.qnot = true;
        } else if (this.preset == false && this.clear == true) {
            this.q = true;
            this.qnot = false;
        } else if (this.preset == true && this.clear == false) {
            this.q = false;
            this.qnot = true;
        } else if (this.preset == true && this.clear == true) {
            
            if (this.set == false && this.reset == true) {
                this.q = false;
                this.qnot = true;
            } else if (this.set == true && this.reset == false) {
                this.q = true;
                this.qnot = false;
            } else if (this.set == true && this.reset == true) {
                this.q = !this.q;
                this.qnot = !this.qnot;
            }
            
        }
        
    }
    
}
