import java.util.Scanner;

public abstract class Puzzle
{
    private final String beforeText;
    private final String afterText;

    public Puzzle(String beforeText, String afterText)
    {
        this.beforeText = beforeText;
        this.afterText = afterText;
    }

    public boolean run(Scanner sc)
    {
        if (beforeText != null && !beforeText.isEmpty())
        {
            System.out.println(beforeText);
        }
        boolean ok = solve(sc);
        if (ok)
        {
            System.out.println("\n>> Puzzle solved!");
        }
        else
        {
            System.out.println("\n>> Puzzle failed!");
        }
        if (afterText != null && !afterText.isEmpty())
        {
            System.out.println(afterText);
        }

        return ok;
    }

    protected abstract boolean solve(Scanner sc);

    public abstract void present();
}
