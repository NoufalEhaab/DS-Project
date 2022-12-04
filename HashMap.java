import java.util.ArrayList;

public class HashMap<T,U> {
    int key;
    U value;
    ArrayList<Integer> arr ;
    public HashMap(){
       arr = new ArrayList<>();
    }

    public void put(int key,int value){
        arr.add(key, value);
    }
    public int get(int key){
        if(key >= arr.size()){
            throw new IndexOutOfBoundsException();
        }
        return arr.get(key);
    }
    public void replace(int key,int value){
        if(key >= arr.size()){
            throw new IndexOutOfBoundsException();
        }
        arr.add(key, value);
    }
    public void createmaze(){
        for (int i = 0; i <= 100; i++) {
            put(i, -1);
        }
    }
    public void printmaze(HashMap<T,U> a) {
        int n = 0;
        int x = 100;
        while (n < 5) {
            // n = x-11;
            for (int i = x; i > x - 10; i--) {
                if (a.get(i) == -1) {
                    System.out.print((i) + " ");
                }else{
                    System.out.print(a.get(i) + " ");
                }
            }
            x = x - 19;
            System.out.println();
            for (int i = x; i < x + 10; i++) {
                if (a.get(i) == -1) {
                    System.out.print((i) + " ");
                }else{
                    System.out.print(a.get(i) + " ");
                }
            }
            System.out.println();
            x--;
            n++;
        }

    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> maze =new HashMap<>();
        maze.createmaze();
        maze.printmaze(maze);
        maze.replace(5, 21);
        maze.printmaze(maze);
        // maze.put(101, 0);
        // maze.get(102);
      
       
    }
}
