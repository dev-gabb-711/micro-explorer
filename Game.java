import java.util.Scanner;
import java.io.IOException;

public class Game
{
    private final Scanner sc;
    private final BattleSystem bs;

    public Game(Scanner sc)
    {
        this.sc = sc;
        this.bs = new BattleSystem(sc);
    }

    public void start()
    {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }

        BackgroundMusic bgm = new BackgroundMusic("resources/BG.wav");
        bgm.playLoop();

        System.out.println("=== MICRO EXPLORER: THE WAR OF THE SMALL WORLD ===");
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine().trim();
        if (playerName.isEmpty())
        {
            playerName = "Explorer";
        }

        Player player = new Player(playerName, 700);

        boolean running = true;
        while (running)
        {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Play");
            System.out.println("2. How to Play");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int c = Utils.readInt(sc, 1, 3);

            if (c == 1)
            {
                playCampaign(player);
            }
            else if (c == 2)
            {
                showHowToPlay();
            }
            else
            {
                running = false;
            }
        }
        System.out.println("Thanks for playing");
        bgm.stop();
        bgm.close();
    }

    private void showHowToPlay() {
        System.out.println("\nHOW TO PLAY:");
        System.out.println("- Each level has 2-3 puzzles, 4-5 enemy groups, then a mini-boss. (In that order)");
        System.out.println("- Players simply use keyboard inputs to solve puzzles, and defeat enemies in a turn-based fashion");
        System.out.println("- Level 10 adds the final boss (The Omega Strain).");
        System.out.println("- Player starts with 2 attacks + 1 defend; unlocks more until full kit by level 8.");
        System.out.println("- Moves cost energy; energy is gained from puzzles, defeating groups, and clearing levels.");
        System.out.println("- If HP or energy are depleted so you cannot use any move, it's GAME OVER.");
        System.out.println();
        System.out.println("Credits to:");
        System.out.println("- Donkey Kong Country on the Game Boy Color for the Main Theme of the Game");
        System.out.println();
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }

    private void playCampaign(Player player)
    {
        System.out.println("\n--- CAMPAIGN ---");
        /*
        Will put prints muna here as I want this segment of prints to be typed as a display, will research about it tomorrow
         */
        TypingEffect.typeMessage("You are a really cool biologist, and I mean REALLY COOL");
        System.out.println();
        TypingEffect.typeMessage("I mean cmon, you've won the Nobel Prize in Biology the year after you graduated college.");
        System.out.println();
        TypingEffect.typeMessage("But lately, you and your team have noticed something odd.");
        System.out.println();
        TypingEffect.typeMessage("Family, friends, acquaintances, and even other organisms have started to grow weak");
        System.out.println();
        TypingEffect.typeMessage("Samples were taken, research was done, energy drained, blood, sweat, and tears were sacrificed");
        System.out.println();
        TypingEffect.typeMessage("Until one day, your team FINALLY discovered the reason why");
        System.out.println();
        System.out.println();
        TypingEffect.typeMessage("A horrific virus that can claim lives of not just humans but every single living organism");
        System.out.println();
        TypingEffect.typeMessage("It clinged to any and every life form it detected");
        System.out.println();
        TypingEffect.typeMessage("And the only way to cure it, is to shrink and delve into the small world of cells in different organisms");
        System.out.println();
        TypingEffect.typeMessage("To discover the true source of the virus, and kill it");
        System.out.println();
        TypingEffect.typeMessage("You may succeed, you may not, but you are the team's best shot at making this happen");
        System.out.println();
        TypingEffect.typeMessage("The world is in your hands, so... are you ready " + player.getName() + "?");
        System.out.println();
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TypingEffect.typeMessage("Then let's do it");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        System.out.println("\n=== MAP SELECT ===");
        Utils.printMapGrid(10, 5);
        System.out.print("Choose map number (1-10): ");
        int map = Utils.readInt(sc, 1, 10);

        Level level = new Level(map, sc, bs);
        level.play(player);
        System.out.println("\nReturning to main menu...");
    }
}
