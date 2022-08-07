import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.Random;

class WaterSort {
    Character top = null;
    // create constants for colors
    static Character red = new Character('r');
    static Character blue = new Character('b');
    static Character yellow = new Character('g');
    // Bottles declaration

    public static void showAll(StackAsMyArrayList bottles[]) {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Bottle " + i + ": " + bottles[i]);
        }
    }

    // Solved Method:
    public static boolean solved(StackAsMyArrayList bottles[]) {
        int test = 0;
        for (int j = 0; j <= 4; j++) {
            if (bottles[j].checkStackUniform() == true && bottles[j].getStackSize() == 4) {
                test++;
            }
        }
        if (test == 3) {
            return true;
        } else {
            test = 0;
            return false;
        }
    }

    public static void main(String args[]) {
        int moves = 0;
        int source = 0;
        int target = 0;
        int max = 4;
        Random randomNum = new Random();
        Scanner scan = new Scanner(System.in);

        StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
        // You can do this with a for also
        for (int i = 0; i <= 4; i++) {
            bottles[i] = new StackAsMyArrayList<Character>();
        }

        // Adding the colours:
        for (int i = 0; i < 4; i++) {
            bottles[0].push(red);
            bottles[1].push(blue);
            bottles[2].push(yellow);
        }

        // To mix the ink in the bottles:
        while (moves <= 100) {
            source = randomNum.nextInt(max);
            while (bottles[source].getStackSize() == 0) {
                source = randomNum.nextInt(max);
            }
            target = randomNum.nextInt(max);
            while (bottles[target].getStackSize() == 4) {
                target = randomNum.nextInt(max);
            }
            bottles[target].push(bottles[source].pop());
            moves++;
        }
        // Intro Message:
        System.out.println("Welcome to Watersort!\nLet The GAME Begin!");
        // While puzzle is not solved:
        while (!solved(bottles)) {
            showAll(bottles);
            System.out.println("Enter source bottle number:");
            int sb = scan.nextInt();
            if (sb > 4 || bottles[sb].getStackSize() == 0) {
                System.out.println("Enter valid bottle number!");
                sb = scan.nextInt();
                System.out.println("Enter target bottle number:");
                int tb = scan.nextInt();
                if (tb > 4 || bottles[tb].getStackSize() == 4) {
                    System.out.println("Enter valid bottle number!");
                    tb = scan.nextInt();
                } else {
                    bottles[tb].push(bottles[sb].pop());
                }
            } else {
                System.out.println("Enter target bottle number:");
                int tb = scan.nextInt();
                if (tb > 4 || bottles[tb].getStackSize() == 4) {
                    System.out.println("Enter valid bottle number!");
                    tb = scan.nextInt();
                    bottles[tb].push(bottles[sb].pop());
                } else {
                    bottles[tb].push(bottles[sb].pop());
                }
            }
        }
        // Once The game is solved:
        showAll(bottles);
        System.out.println("Congratulations, You solved the puzzle!");
        System.out.println("Cool game! Learned alot from this project!");
    }
}// THE END!
