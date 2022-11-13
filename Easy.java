import java.util.HashMap;
import java.util.Random;

public class Easy {
   static HashMap<Integer,Integer> a;
    // Easy(HashMap<Integer,Integer> a){
    //     // a = new Hashmap<>();
    // }

    static public void createmaze(HashMap<Integer,Integer> a){
        for (int i = 0; i < 100; i++) {
            a.put((i+1), -1);
        }
        Random r = new Random();
        //------Ladders-----
        //First Row
        int temp = r.nextInt(11);
        System.out.println(temp);
        a.replace(temp, r.nextInt(30-10) + 10);
        //Second Row
        temp = r.nextInt((20-11))+10;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(50-20) + 20);
        //Fourth Row 
        temp = r.nextInt((40-31))+30;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(70-50) + 50); 
        //Fifth Row
        temp = r.nextInt((50-41))+41;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(80-60) + 60); 
        //Sixth Row
        temp = r.nextInt((60-51))+51;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(90-61) + 61); 
        //Seventh Row
        temp = r.nextInt((70-61))+61;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(90-71) + 71);
        //------Snakes------
        //Fourth Row 
        temp = r.nextInt((40-31))+30;
        System.out.println("\n"+temp);
        a.replace(temp,  r.nextInt(40)); 
        //Fifth Row
        temp = r.nextInt((50-41))+41;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(40)); 
        //Sixth Row
        temp = r.nextInt((60-51))+51;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(50)); 
        //Ninth Row
        temp = r.nextInt((90-81))+81;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(70));
        //Tenth Row
        temp = r.nextInt((100-91))+91;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(60));
        temp = r.nextInt((100-91))+91;
        System.out.println(temp);
        a.replace(temp,  r.nextInt(10));
    }
    

    

    static public void printmaze(HashMap<Integer,Integer> a){
        int n = 0;
        int x = 100;
        while(n < 5){
            // n = x-11;
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
        printmaze(a);
    }

    
}
