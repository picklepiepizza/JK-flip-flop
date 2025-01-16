import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		
    	final String[] inputs = {"Set", "Reset", "Preset", "Clear"};
		
		Scanner scan = new Scanner(System.in);
		
		JK MyJK = new JK();
		
		while (true) {
		    
		    boolean[] settings = {false, false, false, false};
		    
		    for (int currentInput=0;currentInput<=3;currentInput++) {
		        
		        System.out.print("Enter "+inputs[currentInput]+" (0-1): ");
		        
		        int chosenInput = Integer.parseInt(scan.nextLine());
		        settings[currentInput] = chosenInput!=0;
		        
		    }
		    
		    MyJK.setInputs(settings[0], settings[1], settings[2], settings[3]);
		    
		    // clock
		    
		    boolean[] outputs = JK.clock(MyJK);
		    boolean q = outputs[0];
		    boolean qnot = outputs[1];
		    
		    System.out.println("Outputs");
		    System.out.println("Q: "+q);
		    System.out.println("Qn: "+qnot);
		    
		}
		
	}
}
