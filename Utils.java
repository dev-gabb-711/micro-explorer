import java.util.Scanner;

public class Utils
{
    public static int readInt(Scanner sc, int min, int max)
    {
        while(true) {
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < min || v > max) {
                    throw new NumberFormatException();
                }
                return v;
            }
            catch (Exception e)
            {
                System.out.print("Enter a number [" + min + "-" + max + "]: ");
            }
        }
    }

    public static void printMapGrid(int total, int cols)
    {
        int rows = (int)Math.ceil(total / (double)cols);
        int n = 1;
        int r;

        for (r = 0; r < rows; r++)
        {
            StringBuilder sb = new StringBuilder();
            int c;
            for (c = 0; c < cols && n <= total; c++)
            {
                sb.append(String.format("[%2d] ", n++));
            }
            System.out.println(sb.toString().trim());
        }
    }
}
