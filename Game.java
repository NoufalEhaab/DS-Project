import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    static HashMap<Integer, Integer> maze;
    static int choice = 0;
    public Game() {
        detailsofplayer();
        selectdifficulty();
        
    }
  
    public void createmaze() {
        maze = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            maze.put((i + 1), -1);
        }
    }
    public void selectdifficulty(){
        try {
        Scanner input = new Scanner(System.in);
        System.out.println(Color.RED_UNDERLINED);
        System.out.println("Select Difficulty :");
        System.out.print(Color.RESET);
        System.out.println(Color.CYAN);
        System.out.println("1.Easy\n2.Medium\n3.Hard");
        System.out.println(Color.RESET);
        choice = input.nextInt();   
        if (choice == 1) {
            maze = new HashMap<>();
            createmaze();
            Random r = new Random();
            // ------Ladders-----
            // First Row
            int temp = r.nextInt(11);
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(30 - 10) + 10);
            // Second Row
            temp = r.nextInt((20 - 11)) + 10;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(50 - 20) + 20);
            // Fourth Row
            temp = r.nextInt((40 - 31)) + 30;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(70 - 50) + 50);
            // Fifth Row
            temp = r.nextInt((50 - 41)) + 41;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(80 - 60) + 60);
            // Sixth Row
            temp = r.nextInt((60 - 51)) + 51;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(90 - 61) + 61);
            // Seventh Row
            temp = r.nextInt((70 - 61)) + 61;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(90 - 71) + 71);
            // ------Snakes------
            // Fourth Row
            temp = r.nextInt((40 - 31)) + 30;
            // System.out.println("\n"+temp);
            maze.replace(temp, r.nextInt(40));
            // Fifth Row
            temp = r.nextInt((50 - 41)) + 41;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(40));
            // Sixth Row
            temp = r.nextInt((60 - 51)) + 51;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(50));
            // Ninth Row
            temp = r.nextInt((90 - 81)) + 81;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(70));
            // Tenth Row
            temp = r.nextInt((100 - 91)) + 91;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(60));
            temp = r.nextInt((100 - 91)) + 91;
            // System.out.println(temp);
            maze.replace(temp, r.nextInt(10));

        } else if (choice == 2) {
            createmaze();
            maze.put(85, 55);
            // maze.put(89, 51);
            maze.put(59, 37);
            maze.put(39, 3);
            maze.put(47, 32);
            maze.put(17, 46);
            maze.put(8, 30);
            maze.put(42, 80);
            maze.put(31, 67);
            // maze.put(99, 4);
            maze.put(57, 85);
            maze.put(68, 93);
        } else if (choice == 3) {
            createmaze();
            // maze.put(99, 4);
            maze.put(85, 55);
            // maze.put(89, 51);
            maze.put(59, 37);
            maze.put(39, 3);
            maze.put(47, 32);
            maze.put(17, 46);
            maze.put(8, 30);
            maze.put(42, 80);
            maze.put(31, 67);
            maze.put(57, 85);
            maze.put(68, 93);
            maze.put(95, -2);
            maze.put(81, -2);
            maze.put(96, -2);
            maze.put(83, -2);

        }
        else{
            System.out.println("Invalid choice entered,Try again");
            selectdifficulty();
        }  
        } catch (InputMismatchException e) {
            System.out.println("Invalid input,Try again");
            selectdifficulty();
        }       
    
    }
    public void detailsofplayer(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println(Color.RED);
            System.out.print("Enter the number of players : ");
            System.out.print(Color.RESET);
            int NoOfplayer = input.nextInt();
            for (int i = 0; i < NoOfplayer; i++) {
                System.out.print(Color.CYAN);
                System.out.print("Enter the name of  Player#" + (i + 1) + " : ");
                System.out.print(Color.RESET);
                Player a = new Player(input.next());
                players.add(a);
            }
    
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input,Try again");
            detailsofplayer();
        }
    }
    static public void printmaze(HashMap<Integer, Integer> a) {
        int n = 0;
        int x = 100;
        while (n < 5) {
            // n = x-11;
            for (int i = x; i > x - 10; i--) {
                if (a.get(i) == -1) {
                    System.out.print(Color.YELLOW_BOLD_BRIGHT);
                    System.out.print((i) + " ");
                    System.out.print(Color.RESET);
                }else{
                    if(a.get(i) == -2){
                        System.out.print(Color.WHITE_BOLD_BRIGHT);
                        System.out.print((i) + " ");
                        System.out.print(Color.RESET);
                    }
                    else if (a.get(i) > i) {
                        System.out.print(Color.BLUE_BOLD_BRIGHT);
                        System.out.print(a.get(i) + " ");
                        System.out.print(Color.RESET);
                    }
                    else{
                        System.out.print(Color.RED_BOLD_BRIGHT);
                        System.out.print(a.get(i) + " ");
                        System.out.print(Color.RESET);
                    }
                }
            }
            x = x - 19;
            System.out.println();
            for (int i = x; i < x + 10; i++) {
                if (a.get(i) == -1) {
                    System.out.print(Color.GREEN_BOLD_BRIGHT);
                    System.out.print((i) + " ");
                    System.out.print(Color.RESET);
                }else{
                    if(a.get(i) == -2){
                        System.out.print(Color.WHITE_BOLD_BRIGHT);
                        System.out.print((i) + " ");
                        System.out.print(Color.RESET);
                    }
                    else if (a.get(i) > i) {
                        System.out.print(Color.BLUE_BOLD_BRIGHT);
                        System.out.print(a.get(i) + " ");
                        System.out.print(Color.RESET);
                    }
                    else{
                        System.out.print(Color.RED_BOLD_BRIGHT);
                        System.out.print(a.get(i) + " ");
                        System.out.print(Color.RESET);
                    }
                }
            }
            System.out.println();
            x--;
            n++;
        }

    }

    public int rolldice() {
        Random r = new Random();
        int num = r.nextInt(7 - 1) + 1;
        return num;
    }

    public void step_assign(Player obj, int num) {

        if (obj.step == 0) {
            if (num == 6) {
                obj.step = 1;
            }
        } else if (obj.step + num > 100) {
            System.out.print(Color.RED_BOLD_BRIGHT);
            System.out.println("Can't make the move!");
            System.out.print(Color.RESET);
            return;
        } else if (obj.step + num == 100) {
            System.out.print(Color.GREEN_BRIGHT);
            System.out.print(Color.WHITE_BACKGROUND);
            System.out.println("Player : " + obj.name + " won the game!!!");
            System.out.print(Color.RESET);
            System.exit(0);
        } else {
            // System.out.println(maze.get(obj.step + num));
            if (maze.get(obj.step + num) != -1 && maze.get(obj.step + num) != -2) {

                obj.step = maze.get(obj.step + num);
                // movesnake(obj);

            } else if (maze.get(obj.step + num) == -2) {
                System.out.print(Color.RED);
                System.out.println("HAHAHA!You landed on bomb!");
                System.out.print(Color.RESET);
                obj.step = 0;
            } else {
                obj.step += num;
                // movesnake(obj);

            }
            // movesnake(obj);

        }
    }
    public void step_assign2(Player obj, int num) {

        if (obj.step == 0) {
            if (num == 6) {
                obj.step = 1;
            }
        } else if (obj.step + num > 100) {
            System.out.println("Can't make the move!");
            return;
        } else if (obj.step + num == 100) {
            System.out.println("Player : " + obj.name + " won the game!!!");
            System.exit(0);
        } else {
            // System.out.println(maze.get(obj.step + num));
            if (maze.get(obj.step + num) != -1 && maze.get(obj.step + num) != -2) {

                obj.step = maze.get(obj.step + num);
                movesnake(obj);

            } else if (maze.get(obj.step + num) == -2) {
                System.out.println("HAHAHA!You landed on bomb!");
                maze.put(obj.step+num,-1);

                obj.step = 0;
            } else {
                obj.step += num;
                movesnake(obj);

            }
            // movesnake(obj);

        }
    }

    public void showposition(ArrayList<Player> player) {
        System.out.print(Color.CYAN);
        for (Player p : player) {
            System.out.println("Player " + p.name + " position = " + p.step);
        }
        System.out.print(Color.RESET);
    }

    public void movesnake(Player p) {
        int n = p.step / 10;
        int x = p.step % 10;

        if (x != 0) {
            int snake = p.step;
            for (int i = (n * 10) + 1; i < ((n + 1) * 10) + 1; i++) {
                if (maze.get(i) < i && maze.get(i) > 0) {
                    snake = i;
                }
            }
            if (snake > p.step) {
                maze.put(snake - 1, maze.get(snake));
                maze.put(snake, -1);
                checkstep(p);
            } else if (snake < p.step) {
                maze.put(snake + 1, maze.get(snake));
                maze.put(snake, -1);
                checkstep(p);
            }
        } else if (x == 0) {
            int snake = p.step;
            for (int i = ((n - 1) * 10) + 1; i < (n * 10) + 1; i++) {
                if (maze.get(i) < i && maze.get(i) > 0) {
                    snake = i;
                }
            }
            if (snake > p.step) {
                maze.put(snake - 1, maze.get(snake));
                maze.put(snake, -1);
                checkstep(p);
            } else if (snake < p.step) {
                maze.put(snake + 1, maze.get(snake));
                maze.put(snake, -1);
                checkstep(p);
            }
        }

    }

    public void checkstep(Player p) {
        if (maze.get(p.step) > 0 ) {
            p.step = maze.get(p.step);
        }

    }
    public void findprobabilty(ArrayList <Player> players){
        for (Player player : players) {
        player.movesrequire = ((100-player.step)/6) + 1;
        System.out.print(Color.MAGENTA);
        System.out.println("Minimum number of steps in which Player "+player.name + " can finish game = " + player.movesrequire );
        System.out.print(Color.RESET);
        }
    }
    enum Color {
        //Color end string, color reset
        RESET("\033[0m"),
    
        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m"),    // WHITE
    
        // Bold
        BLACK_BOLD("\033[1;30m"),   // BLACK
        RED_BOLD("\033[1;31m"),     // RED
        GREEN_BOLD("\033[1;32m"),   // GREEN
        YELLOW_BOLD("\033[1;33m"),  // YELLOW
        BLUE_BOLD("\033[1;34m"),    // BLUE
        MAGENTA_BOLD("\033[1;35m"), // MAGENTA
        CYAN_BOLD("\033[1;36m"),    // CYAN
        WHITE_BOLD("\033[1;37m"),   // WHITE
    
        // Underline
        BLACK_UNDERLINED("\033[4;30m"),     // BLACK
        RED_UNDERLINED("\033[4;31m"),       // RED
        GREEN_UNDERLINED("\033[4;32m"),     // GREEN
        YELLOW_UNDERLINED("\033[4;33m"),    // YELLOW
        BLUE_UNDERLINED("\033[4;34m"),      // BLUE
        MAGENTA_UNDERLINED("\033[4;35m"),   // MAGENTA
        CYAN_UNDERLINED("\033[4;36m"),      // CYAN
        WHITE_UNDERLINED("\033[4;37m"),     // WHITE
    
        // Background
        BLACK_BACKGROUND("\033[40m"),   // BLACK
        RED_BACKGROUND("\033[41m"),     // RED
        GREEN_BACKGROUND("\033[42m"),   // GREEN
        YELLOW_BACKGROUND("\033[43m"),  // YELLOW
        BLUE_BACKGROUND("\033[44m"),    // BLUE
        MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
        CYAN_BACKGROUND("\033[46m"),    // CYAN
        WHITE_BACKGROUND("\033[47m"),   // WHITE
    
        // High Intensity
        BLACK_BRIGHT("\033[0;90m"),     // BLACK
        RED_BRIGHT("\033[0;91m"),       // RED
        GREEN_BRIGHT("\033[0;92m"),     // GREEN
        YELLOW_BRIGHT("\033[0;93m"),    // YELLOW
        BLUE_BRIGHT("\033[0;94m"),      // BLUE
        MAGENTA_BRIGHT("\033[0;95m"),   // MAGENTA
        CYAN_BRIGHT("\033[0;96m"),      // CYAN
        WHITE_BRIGHT("\033[0;97m"),     // WHITE
    
        // Bold High Intensity
        BLACK_BOLD_BRIGHT("\033[1;90m"),    // BLACK
        RED_BOLD_BRIGHT("\033[1;91m"),      // RED
        GREEN_BOLD_BRIGHT("\033[1;92m"),    // GREEN
        YELLOW_BOLD_BRIGHT("\033[1;93m"),   // YELLOW
        BLUE_BOLD_BRIGHT("\033[1;94m"),     // BLUE
        MAGENTA_BOLD_BRIGHT("\033[1;95m"),  // MAGENTA
        CYAN_BOLD_BRIGHT("\033[1;96m"),     // CYAN
        WHITE_BOLD_BRIGHT("\033[1;97m"),    // WHITE
    
        // High Intensity backgrounds
        BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     // BLACK
        RED_BACKGROUND_BRIGHT("\033[0;101m"),       // RED
        GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     // GREEN
        YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    // YELLOW
        BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      // BLUE
        MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),   // MAGENTA
        CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      // CYAN
        WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // WHITE
    
        private final String code;
    
        Color(String code) {
            this.code = code;
        }
    
        @Override
        public String toString() {
            return code;
        }
    }
    public static void main(String[] args) {
        System.out.println(Color.RED);
        System.out.println(Color.GREEN_BACKGROUND);
        System.out.println("  _________              __                      _____              .___ .____                .___  .___                           ");
          System.out.println( "/   _____/ ____ _____  |  | __ ____   ______   /  _  \\   ____    __| _/ |    |   _____     __| _/__| _/___________             ");
          System.out.println("\\_____  \\ /    \\__  \\ |  |/ // __ \\ /  ___/  /  /_\\  \\ /    \\  / __ |  |    |   \\__  \\   / __ |/ __ |/ __ \\_  __ \\   ") ;
          System.out.println("/        \\   |  \\/ __ \\|    <\\  ___/ \\___ \\  /    |    \\   |  \\/ /_/ |  |    |___ / __ \\_/ /_/ / /_/ \\  ___/|  | \\/   ");
          System.out.println("/_______  /___|  (____  /__|_ \\___  >____  > \\____|__  /___|  /\\____ |  |_______ (____  /\\____ \\____ |\\___  >__|           ");
          System.out.println("        \\/     \\/     \\/     \\/    \\/     \\/          \\/     \\/      \\/          \\/    \\/      \\/    \\/    \\/    "  );
        System.out.println(Color.RESET);
       
          Game g = new Game();
        // printmaze(maze);
        System.out.println();
        while (0 == 0) {
            printmaze(maze);
            g.showposition(g.players);
            for (Player p : g.players) {
                System.out.print(Color.GREEN_BOLD_BRIGHT);
                System.out.println("Player " + p.name + " turn : ");
                System.out.print(Color.RESET);
                System.out.print(Color.BLUE);
                System.out.println("Press r to roll dice!");
                System.out.print(Color.RESET);
                Scanner sc = new Scanner(System.in);
                String a = sc.next();
                while(!a.equals("r")){
                    System.out.print(Color.BLUE_BOLD);
                    System.out.println("Press r to roll dice!");
                    System.out.print(Color.RESET);
                    a = sc.next();
                }
                if (a.equals("r")) {
                    int num = g.rolldice();
                    System.out.print(Color.RED_BOLD_BRIGHT);
                    System.out.println("Number = " + num);
                    System.out.print(Color.RESET);
                    if (choice == 1) {
                    g.step_assign(p, num);
                    }
                    else{
                    g.step_assign2(p, num);
                    }
                    g.findprobabilty(g.players);
                }

            }
        }
    }
}
