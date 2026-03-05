import java.util.Random;
import java.util.Scanner;

public class PuzzlePattern extends Puzzle
{
    private final int variant;

    public PuzzlePattern(String beforeText, String afterText)
    {
        super(beforeText, afterText);
        this.variant = new Random().nextInt(3); // 3 different patterns
    }

    @Override
    protected boolean solve(Scanner sc)
    {
        switch (variant)
        {
            case 0:
                System.out.println("Find the missing number in the sequence:");
                System.out.println("2, 4, 6, 8, ?");
                System.out.println("1) 9\n2) 10\n3) 12");
                return getChoice(sc, 3) == 2; // Correct: 10

            case 1:
                System.out.println("What comes next?");
                System.out.println("3, 6, 12, 24, ?");
                System.out.println("1) 36\n2) 48\n3) 50");
                return getChoice(sc, 3) == 2; // Correct: 48

            default:
                System.out.println("Find the missing number:");
                System.out.println("1, 4, 9, 16, ?");
                System.out.println("1) 20\n2) 25\n3) 30");
                return getChoice(sc, 3) == 2; // Correct: 25
        }
    }

    @Override
    public void present()
    {
        System.out.println("Recognize the number pattern and solve!");
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
