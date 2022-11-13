import java.util.*;
public class Medium{
    static HashMap<Integer,Integer> a;
   
     static public void createmaze(HashMap<Integer,Integer> a){
        for (int i = 0; i < 100; i++) {
            a.put((i+1),(i+1) );
        }
       
        // Random r = new Random();
       
    }
    static public void setMaze(HashMap<Integer,Integer> a){
        a.put(99,4);
        a.put(85,55);
        a.put(89,51);
        a.put(59,37);
        a.put(39,3);
        a.put(47,32);
        a.put(17,46);
        a.put(8,30);
        a.put(42,80);
        a.put(31,67);
        a.put(99,4);
        a.put(57,85);
        a.put(68,93);
    }

    static public void printmaze(HashMap<Integer,Integer> a){
        int n = 0;
        int x = 100;
        while(n < 5){
            for (int i = x;  i>x-10 ; i--) {
                System.out.print(a.get(i) + " ");
            }
            x = x - 19;
            System.out.println();
            for (int i = x; i < x + 10; i++) {
                System.out.print(a.get(i) + " ");
                
            }
            System.out.println();
            x--;
              n++;
        }
        
    }
   
    public static void main(String[] args) {
        a = new HashMap<>();
        createmaze(a);
        // setMaze(a);
        printmaze(a);
    }
}
