import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    static HashMap<Integer,Integer> maze;

    
    public Game(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of players : ");
        int NoOfplayer = input.nextInt();
        for (int i = 0; i < NoOfplayer; i++) {
            System.out.print("Enter the name of  Player#" + (i+1) + " : ");
            Player a = new Player(input.next());
            players.add(a);
        }
        System.out.println("Select Difficulty :\n1.Easy\n2.Medium\n3.Hard");
        int choice = input.nextInt();
        if (choice == 1) {
            maze = new HashMap<>();
            createmaze();
            Random r = new Random();
            //------Ladders-----
            //First Row
            int temp = r.nextInt(11);
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(30-10) + 10);
            //Second Row
            temp = r.nextInt((20-11))+10;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(50-20) + 20);
            //Fourth Row 
            temp = r.nextInt((40-31))+30;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(70-50) + 50); 
            //Fifth Row
            temp = r.nextInt((50-41))+41;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(80-60) + 60); 
            //Sixth Row
            temp = r.nextInt((60-51))+51;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(90-61) + 61); 
            //Seventh Row
            temp = r.nextInt((70-61))+61;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(90-71) + 71);
            //------Snakes------
            //Fourth Row 
            temp = r.nextInt((40-31))+30;
            // System.out.println("\n"+temp);
            maze.replace(temp,  r.nextInt(40)); 
            //Fifth Row
            temp = r.nextInt((50-41))+41;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(40)); 
            //Sixth Row
            temp = r.nextInt((60-51))+51;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(50)); 
            //Ninth Row
            temp = r.nextInt((90-81))+81;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(70));
            //Tenth Row
            temp = r.nextInt((100-91))+91;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(60));
            temp = r.nextInt((100-91))+91;
            // System.out.println(temp);
            maze.replace(temp,  r.nextInt(10));

        }
        else if(choice == 2){
            createmaze();
        }
        else if(choice == 3){
            createmaze();

            // Game g = new Hard();
        }
    }
public void createmaze(){
         maze = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            maze.put((i+1), -1);
        }
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
    public int rolldice(){
        Random r = new Random();
        int num = r.nextInt(7-1)+1;
        return num;
    }
    public void step_assign(Player obj,int num){
        if(obj.step == 0){
            if (num == 6) {
                obj.step = 1;
            }
        }
        else if(obj.step + num > 100){
            System.out.println("Can't make the move!");
            return;
        }
        else if(obj.step + num == 100){
            System.out.println("Player : " + obj.name + " won the game!!!");
            System.exit(0);
        }
        else{
        System.out.println(maze.get(obj.step + num));
        if (maze.get(obj.step + num) != -1) {
            
            obj.step = maze.get(obj.step + num);
        }
        else{
            obj.step += num;
        }
        }
   }
   public void showposition(ArrayList<Player> player){
        for (Player p : player) {
            System.out.println("Player " + p.name + " position = " + p.step);
        }    
    }
    public static void main(String[] args) {
        Game g = new Game();
        printmaze(maze);

        while (0 == 0) {
            printmaze(maze);
            g.showposition(g.players);
            for (Player p : g.players) {
                System.out.println("Press r to roll dice!");
                Scanner sc = new Scanner(System.in);
                String a = sc.next();
                if(a.equals("r")){
                    int num = g.rolldice();
                    System.out.println("Number = " + num);
                    g.step_assign(p, num);
                }
                
           }
        }
    }
}
