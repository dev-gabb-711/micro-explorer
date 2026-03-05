import java.util.Scanner;

public class BattleSystem
{
    private final Scanner sc;

    public BattleSystem(Scanner sc) {
        this.sc = sc;
    }

    // Returns true if player survives and wins, returns false if player dies
    public boolean fight(Player player, Enemy enemy)
    {
        System.out.println("Encounter: " + enemy.getName());
        while (player.isAlive() && enemy.isAlive())
        {
            // Player turn
            if (player.isStunned())
            {
                System.out.println("\nYou are stunned! Turn is skipped");
                player.clearStun();
            }
            else
            {
                if (!player.canAffordAnyMove())
                {
                    System.out.println("\nYou do not have enough energy for any move. GAME OVER.");
                    return false;
                }
                String result = player.chooseMove(sc, enemy);
                if (result.startsWith("DMG:"))
                {
                    int dmg = Integer.parseInt(result.substring(4).trim());
                    enemy.takeDamage(dmg);
                }
                else if (result.equals("STUN"))
                {
                    enemy.applyStun();
                } // DEF handled in player state
            }

            if (!enemy.isAlive()) break;

            // Enemy turn
            if (!player.isAlive()) break;
            enemy.act(player);
            if (!player.isAlive()) break;
        }

        if (!player.isAlive())
        {
            System.out.println("\nYou have been defeated by " + enemy.getName() + ".");
            return false;
        }
        else
        {
            System.out.println("\nEnemy " + enemy.getName() + " defeated.");
            player.healHp(100);
            return true;
        }
    }
}
