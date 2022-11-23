import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    static HashMap<Integer, Integer> maze;

    public Game() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of players : ");
        int NoOfplayer = input.nextInt();
        for (int i = 0; i < NoOfplayer; i++) {
            System.out.print("Enter the name of  Player#" + (i + 1) + " : ");
            Player a = new Player(input.next());
            players.add(a);
        }
        System.out.println("Select Difficulty :\n1.Easy\n2.Medium\n3.Hard");
        int choice = input.nextInt();
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
            maze.put(99, 4);
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
            maze.put(99, 4);
            maze.put(57, 85);
            maze.put(68, 93);
            maze.put(95, -2);
            maze.put(81, -2);
            maze.put(96, -2);
            maze.put(83, -2);

        }
    }

    public void createmaze() {
        maze = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            maze.put((i + 1), -1);
        }
    }

    static public void printmaze(HashMap<Integer, Integer> a) {
        int n = 0;
        int x = 100;
        while (n < 5) {
            // n = x-11;
            for (int i = x; i > x - 10; i--) {
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
                obj.step = 0;
            } else {
                obj.step += num;
                movesnake(obj);

            }
            // movesnake(obj);

        }
    }

    public void showposition(ArrayList<Player> player) {
        for (Player p : player) {
            System.out.println("Player " + p.name + " position = " + p.step);
        }
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

    public static void main(String[] args) {
        Game g = new Game();
        printmaze(maze);

        while (0 == 0) {
            printmaze(maze);
            g.showposition(g.players);
            for (Player p : g.players) {
                System.out.println("Player " + p.name + " turn : ");
                System.out.println("Press r to roll dice!");
                Scanner sc = new Scanner(System.in);
                String a = sc.next();
                if (a.equals("r")) {
                    int num = g.rolldice();
                    System.out.println("Number = " + num);
                    g.step_assign(p, num);
                }

            }
        }
    }
}
