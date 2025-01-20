import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String[] inputs = {"Set", "Reset", "Preset", "Clear"};
        Scanner scan = new Scanner(System.in);

        JK myJK = new JK();

        while (true) {
            try {
                boolean[] settings = new boolean[4];

                for (int i = 0; i < inputs.length; i++) {
                    System.out.print("Enter " + inputs[i] + " (0-1): ");
                    settings[i] = Integer.parseInt(scan.nextLine()) != 0;
                }

                myJK.setInputs(settings[0], settings[1], settings[2], settings[3]);
                myJK.clock();

                boolean[] outputs = myJK.getOutputs();
                System.out.println("Outputs\nQ: " + outputs[0] + "\nQn: " + outputs[1]);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
