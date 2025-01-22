import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		
    	final String[] inputs = {"Set", "Reset", "Preset", "Clear"};
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose an option\n (1) Test JK flip flop\n (2) Test counter");
		int option = Integer.parseInt(scan.nextLine());
		
		JK MyJK = new JK();
		
		if (option == 1) {
		    
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
    		    System.out.println("Outputs"+"\nQ: "+outputs[0]+"\nQn: "+outputs[1]);
    		    
    		    MyJK.setq(outputs[0]);
    		    MyJK.setqnot(outputs[1]);
    		    
    		}
    		
		} else if (option == 2) {
		    
		    System.out.println("Input counter length (in JK flip flops)");
		    int counterLength = Integer.parseInt(scan.nextLine());
		    
		    Counter myCounter = new Counter(counterLength);
		    
		    while (true) {
		        
		        System.out.println(" (1) Pulse counter\n (2) Read counter");
		        int counterOption = Integer.parseInt(scan.nextLine());
    		    
    		    if (counterOption == 1) {
    		        myCounter.pulse();
    		        System.out.println("Pulsed counter");
    		    } else {
    		        System.out.println("Current value: "+myCounter.read());
    		    }
        		
		    }
		    
		}
		
	}
	
}
