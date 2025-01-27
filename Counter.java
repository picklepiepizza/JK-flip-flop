/**
 * Represents a counter composed of multiple JK flip flops.
 */
public class Counter
{

    /**
     * An array of JK flip flops used in the counter.
     */
    JK[] JKs;

    /**
     * Initializes the counter given the number of flip flops.
     *
     * @param numJKs Number of JK flip flops used in the counter.
     */
    public Counter(int numJKs) {

        this.JKs = new JK[numJKs];

        for (int index=0;index<numJKs;index++) {
            this.JKs[index] = new JK(true, true, true, true);
        }

    }

    /**
     * Pulses the counter, going to the next consecutive number.
     */
    public void pulse() {

        int numJKs = this.JKs.length;
        boolean[] currentOutputs = new boolean[numJKs];
        for (int index=0;index<numJKs;index++) {
            currentOutputs[index] = this.JKs[index].getq();
        }

        for (int i=numJKs-1;i>=0;i--) {

            if (currentOutputs[i] == true && i > 0) {
                continue;
            }

            for (int k=i;k<numJKs;k++) {
                JK currentJK = this.JKs[k];
                boolean[] outputs = JK.clock(currentJK);
                currentJK.setq(outputs[0]);
                currentJK.setqnot(outputs[1]);
            }
            break;

        }

    }

    /**
     * Returns the current number value of the counter.
     *
     * @return The value of the counter.
     */
    public int read() {

        int total = 0;
        for (int index=this.JKs.length-1;index>=0;index--) {
            if (this.JKs[index].getq()) {
                total += Math.pow(2, this.JKs.length-index-1);
            }
        }

        return total;
    }

    /**
     * Returns an array of each JK flip flop used in the counter.
     *
     * @return An array of each JK flip flop.
     */
    public JK[] getJKs() {
        return this.JKs;
    }

}