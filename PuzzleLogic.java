import java.util.Random;
import java.util.Scanner;

public class PuzzleLogic extends Puzzle
{
    private final int variant;

    public PuzzleLogic(String beforeText, String afterText)
    {
        super(beforeText, afterText);
        this.variant = new Random().nextInt(3); // 3 different logic puzzles
    }

    @Override
    protected boolean solve(Scanner sc)
    {
        switch (variant)
        {
            case 0:
                System.out.println("A farmer has 17 sheep, and all but 9 run away. How many are left?");
                System.out.println("1) 9\n2) 8\n3) 17");
                return getChoice(sc, 3) == 1; // Correct: 9

            case 1:
                System.out.println("Which one is the odd one out?");
                System.out.println("1) Dog\n2) Cat\n3) Car");
                return getChoice(sc, 3) == 3; // Correct: Car

            default:
                System.out.println("If you rearrange the letters 'CIFAIPC', you get the name of a:");
                System.out.println("1) Ocean\n2) Country\n3) City");
                return getChoice(sc, 3) == 1; // Correct: Pacific (Ocean)
        }
    }

    @Override
    public void present()
    {
        System.out.println("Solve the logic challenge!");
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
