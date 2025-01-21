/**
 * Represents a JK flip flop. Contains inputs for set, reset, preset, and clear.
 * Can output Q and Qnot.
 */
public class JK {
    
    /**
     * Set input for the JK flip flop.
     */
    boolean set;
    
    /**
     * Reset input for the JK flip flop.
     */
    boolean reset;
    
    /**
     * Preset input for the JK flip flop.
     */
    boolean preset;
    
    /**
     * Clear input for the JK flip flop.
     */
    boolean clear;
    
    /**
     * Q output of the JK flip flop.
     */
    boolean q;
    
    /**
     * Qnot output of the JK flip flop.
     */
    boolean qnot;
    
    /**
     * Initializes the JK flip flop with all inputs set to 0.
     */
    public JK() {}
    
    
    /**
     * Initializes the JK flip flop with given inputs.
     * 
     * @param set Initial set state.
     * @param reset Initial reset state.
     * @param preset Initial preset state.
     * @param clear Initial clear state.
     */
    public JK(boolean set, boolean reset, boolean preset, boolean clear) {
        this.set = set;
        this.reset = reset;
        this.preset = preset;
        this.clear = clear;
    }
    
    /**
     * Sets the inputs of the JK flip flop after initializing.
     * 
     * @param set New set state.
     * @param reset New reset state.
     * @param preset New preset state.
     * @param clear New clear state.
     */
    public void setInputs(boolean set, boolean reset, boolean preset, boolean clear) {
        this.set = set;
        this.reset = reset;
        this.preset = preset;
        this.clear = clear;
    }
    
    /**
     * Returns the current inputs.
     * 
     * @return An array containing the inputs in the order of set, reset, preset, then clear.
     */
    public boolean[] getInputs() {
        boolean[] inputs = {this.set, this.reset, this.preset, this.clear};
        return inputs;
    }
    
    /**
     * A static method that returns the outputs of a given JK flip flop, based on the inputs.
     * 
     * @param A given JK flip flop.
     * @return An array containing the outputs in the order of q then qnot.
     */
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
                boolean temp = outputs[0];
                outputs[0] = outputs[1];
                outputs[1] = temp;
            }
            
        }
        
        return outputs;
        
    }
    
    /**
     * Returns the output Q.
     * 
     * @return The state of Q.
     */
    public boolean getq() {
        return this.q;
    }
    
    
    /**
     * Returns the output Qnot.
     * 
     * @return The state of Qnot.
     */
    public boolean getqnot() {
        return this.qnot;
    }
    
    /**
     * Sets the output of Q.
     * 
     * @param New Q state.
     */
    public void setq(boolean q) {
        this.q = q;
    }
    
    /**
     * Sets the output of Qnot.
     * 
     * @param New Qnot state.
     */
    public void setqnot(boolean qnot) {
        this.qnot = qnot;
    }
    
}
