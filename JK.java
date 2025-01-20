public class JK {

    private boolean q = false;
    private boolean qnot = true;

    private boolean set = false;
    private boolean reset = false;
    private boolean preset = true;
    private boolean clear = true;

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

    public boolean[] getOutputs() {
        return new boolean[] {q, qnot};
    }

    public void clock() {
        if (!preset && !clear) {
            throw new IllegalStateException("Invalid state: Both Preset and Clear are false.");
        } else if (!preset) {
            q = true;
            qnot = false;
        } else if (!clear) {
            q = false;
            qnot = true;
        } else {
            if (!set && reset) {
                q = false;
                qnot = true;
            } else if (set && !reset) {
                q = true;
                qnot = false;
            } else if (set && reset) {
                q = !q;
                qnot = !qnot;
            }
        }
    }
}
