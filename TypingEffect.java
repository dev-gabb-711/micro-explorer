public class TypingEffect
{
    private static final int DELAY_MS = 50;

    public static void typeMessage(String text)
    {
        for (char character : text.toCharArray()) {
            System.out.print(character);

            try {
                Thread.sleep(DELAY_MS);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(" [Typing effect was interrupted.] ");
                return;
            }
        }
    }
}