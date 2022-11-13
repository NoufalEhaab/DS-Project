// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Random;
// import java.util.Scanner;

// public class Game {
//     ArrayList<Player> players = new ArrayList<>();
//     static HashMap<Integer,Integer> maze;
    
//     public Game(){
//         Scanner input = new Scanner(System.in);
//         System.out.print("Enter the number of players : ");
//         int NoOfplayer = input.nextInt(0);
//         for (int i = 0; i < NoOfplayer; i++) {
//             System.out.print("Enter the name of  Player#" + (i+1) + " : ");
//             Player a = new Player(input.next());
//             players.add(a);
//         }
//         System.out.println("Select Difficulty :\n1.Easy\n2.Medium\n3.Hard");
//         int choice = input.nextInt();
//         if (choice == 1) {
//             Game g = new Easy();
//         }
//         else if(choice == 2){
//             Game g = new Medium();
//         }
//         else if(choice == 3){
//             Game g = new Hard();
//         }
//     }
// public void createmaze(){
//          maze = new HashMap<>();

//         for (int i = 0; i < 100; i++) {
//             maze.put((i+1), -1);
//         }
//     }

//     public int placeobstacles(){
//         int num;
//         return num;
//     }
//     public int rolldice(){
//         Random r = new Random();
//         int num = r.nextInt(7);
//         return num;
//     }
//     public static void main(String[] args) {
        
//     }
// }
