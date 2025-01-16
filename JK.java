public class JK {
    
    boolean set;
    boolean reset;
    boolean preset;
    boolean clear;
    boolean q;
    boolean qnot;
    
    public JK() {}
    
    public JK(boolean set, boolean reset, boolean preset, boolean clear) {
        this.set = set;
        this.reset = reset;
        this.preset = preset;
        this.clear = clear;
    }
    
    public void setInputs(boolean set, boolean reset, boolean preset, boolean clear) {
        this.set = set;
        this.reset = reset;
        this.preset = preset;
        this.clear = clear;
    }
    
    public boolean[] getInputs() {
        boolean[] inputs = {this.set, this.reset, this.preset, this.clear};
        return inputs;
    }
    
    public static boolean[] clock(JK jk) {
        
        // Q, Qn
        boolean[] outputs = {jk.getq(), jk.getqnot()};
        boolean[] inputs = jk.getInputs();
        boolean set = inputs[0];
        boolean reset = inputs[1];
        boolean preset = inputs[2];
        boolean clear = inputs[3];
        
        if (preset == false && clear == false) {
            outputs[0] = true;
            outputs[1] = true;
        } else if (preset == false && clear == true) {
            outputs[0] = true;
            outputs[1] = false;
        } else if (preset == true && clear == false) {
            outputs[0] = false;
            outputs[1] = true;
        } else if (preset == true && clear == true) {
            
            if (set == false && reset == true) {
                outputs[0] = false;
                outputs[1] = true;
            } else if (set == true && reset == false) {
                outputs[0] = true;
                outputs[1] = false;
            } else if (set == true && reset == true) {
                outputs[0] = !outputs[0];
                outputs[1] = !outputs[1];
            }
            
        }
        
        return outputs;
        
    }
    
    public boolean getq() {
        return this.q;
    }
    
    public boolean getqnot() {
        return this.qnot;
    }
    
}
