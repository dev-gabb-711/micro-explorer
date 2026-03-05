import java.util.Random;
import java.util.Scanner;

public class PuzzleMemory extends Puzzle
{
    private final int variant;

    public PuzzleMemory(String beforeText, String afterText)
    {
        super(beforeText, afterText);
        this.variant = new Random().nextInt(3); // 3 different memory puzzles
    }

    @Override
    protected boolean solve(Scanner sc)
    {
        switch (variant)
        {
            case 0:
                System.out.println("Memorize this sequence: 7 3 9");
                pause(3000);
                clearScreen();
                System.out.println("What was the sequence?");
                System.out.println("1) 7 3 8\n2) 7 3 9\n3) 9 3 7");
                return getChoice(sc, 3) == 2; // Correct

            case 1:
                System.out.println("Memorize this word: DRAGON");
                pause(3000);
                clearScreen();
                System.out.println("What was the word?");
                System.out.println("1) DRAGNO\n2) DRAGON\n3) DRAGAN");
                return getChoice(sc, 3) == 2; // Correct

            default:
                System.out.println("Memorize this sequence: Red, Blue, Green");
                pause(3000);
                clearScreen();
                System.out.println("Which was the second color?");
                System.out.println("1) Red\n2) Blue\n3) Green");
                return getChoice(sc, 3) == 2; // Correct
        }
    }

    @Override
    public void present()
    {
        System.out.println("Test your memory!");
    }

    private void pause(int ms)
    {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    private void clearScreen()
    {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getChoice(Scanner sc, int max)
    {
        int choice = -1;
        while (choice < 1 || choice > max)
        {
            System.out.print("Enter choice (1-" + max + "): ");
            if (sc.hasNextInt()) choice = sc.nextInt();
            else sc.next();
        }
        return choice;
    }
}
