public class Main {
    public static void main(String[] args) {
        
        JK newJK = new JK(true, false, true, true);
        
        newJK.clock();
        
        System.out.println(newJK.getq());
        System.out.println(newJK.getqnot());
    }
}
