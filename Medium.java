import java.util.*;
public class Medium{
    static HashMap<Integer,Integer> maze;
   
     static public void createmaze(HashMap<Integer,Integer> a){
        for (int i = 0; i < 100; i++) {
            maze.put((i+1),(i+1) );
        }
       
        // Random r = new Random();
       
    }
    static public void setMaze(HashMap<Integer,Integer> a){
        maze.put(99,4);
        maze.put(85,55);
        maze.put(89,51);
        maze.put(59,37);
        maze.put(39,3);
        maze.put(47,32);
        maze.put(17,46);
        maze.put(8,30);
        maze.put(42,80);
        maze.put(31,67);
        maze.put(99,4);
        maze.put(57,85);
        maze.put(68,93);
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
   
    public static void movesnake(){
        
    }
    public static void main(String[] args) {
        maze = new HashMap<>();
        createmaze(maze);
        // setMaze(a);
        printmaze(maze);
    }
}
