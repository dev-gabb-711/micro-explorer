import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Player
{
    private final String name;
    private int level = 1; // corresponding to the level number
    private int hp;
    private int maxHp;
    private int energy;
    private int maxEnergy;
    private boolean stunned = false;
    private double shieldPercent = 0.0; // 0..1 reduce next hit
    private final List<Move> moves = new ArrayList<>();

    public Player(String name, int maxEnergy)
    {
        this.name = name;
        this.maxHp = 100;
        this.hp = maxHp;
        this.maxEnergy = maxEnergy;
        this.energy = 0;
        // starter kit: 2 attacks + 1 defend
        moves.add(new Move("Particle Beam", MoveType.ATTACK, 12, 0));
        moves.add(new Move("Molecular Shredder", MoveType.ATTACK, 16, 16));
        moves.add(new Move("Force Field Barrier", MoveType.DEFEND, 0, 10));
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean isAlive()
    {
        return hp > 0;
    }

    public boolean isStunned()
    {
        return stunned;
    }

    public void setMapLevel(int lvl)
    {
        this.level = lvl;
        unlockMovesForLevel(lvl);
    }

    public int getMapLevel()
    {
        return level;
    }

    public void setStartingStats(int startEnergy, int startHp)
    {
        // enforce a global cap for max energy
        final int GLOBAL_MAX_ENERGY = 700;

        this.maxEnergy = Math.min(Math.max(this.maxEnergy, startEnergy), GLOBAL_MAX_ENERGY);
        this.energy = Math.min(startEnergy, this.maxEnergy);

        this.maxHp = Math.max(this.maxHp, startHp);
        this.hp = startHp;
        this.stunned = false;
        this.shieldPercent = 0.0;
    }

    private void unlockMovesForLevel(int lvl)
    {
        // Keep existing core moves, but make sure duplication does not happen when unlocking
        boolean has3 = hasMove("Cryo-Pulse");
        boolean has4 = hasMove("Kinetic Ram");
        boolean has5 = hasMove("Anti-Genome Flare");
        boolean hasStun = hasMove("Neural Overload");

        if (lvl >= 3 && !has3) moves.add(new Move("Cryo-Pulse", MoveType.ATTACK, 18, 24));
        if (lvl >= 5 && !hasStun) moves.add(new Move("Neural Overload", MoveType.STUN, 0, 30));
        if (lvl >= 7 && !has4) moves.add(new Move("Kinetic Pulse", MoveType.ATTACK, 24, 34));
        if (lvl >= 8 && !has5) moves.add(new Move("Cryo-Pulse", MoveType.ATTACK, 32, 41));
    }

    private boolean hasMove(String name)
    {
        for (Move m : moves)
        {
            if (m.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public boolean canAffordAnyMove() {
        int min = Integer.MAX_VALUE;
        for (Move m : moves)
        {
            if (m.getEnergyCost() < min)
            {
                min = m.getEnergyCost();
            }
        }

        return energy >= min;
    }

    public List<Move> getMoves()
    {
        return Collections.unmodifiableList(moves);
    }

    public void applyStun()
    {
        stunned = true;
    }
    public void clearStun()
    {
        stunned = false;
    }

    public void setShield(double pct)
    {
        shieldPercent = pct;
    }
    public void clearShield()
    {
        shieldPercent = 0.0;
    }

    public String chooseMove(Scanner sc, Enemy enemy)
    {
        int i;

        System.out.println("\n" + name + " HP: " + hp + "/" + maxHp + " EN: " + energy + "/" + maxEnergy);
        System.out.println(enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.maxHp);
        System.out.println();

        System.out.println("Choose a Move:");

        for (i = 0; i < moves.size(); i++)
        {
            Move m = moves.get(i);
            String damageString;
            if (m.getType() == MoveType.ATTACK)
            {
                damageString = " DMG:" + m.getDamage();
            }
            else
            {
                damageString = "";
            }
            System.out.printf("%d) %s [%s] (EN %d)%s%n", i + 1, m.getName(), m.getType(), m.getEnergyCost(), damageString);
        }
        System.out.print("Choice: ");

        int choice = Utils.readInt(sc, 1, moves.size()) - 1;
        Move selected = moves.get(choice);
        if (selected.getEnergyCost() > energy)
        {
            System.out.println("\nNot enough energy for that move. Turn skipped");
            return "SKIP";
        }
        energy -= selected.getEnergyCost();

        switch(selected.getType())
        {
            case ATTACK:
                int dmg = selected.getDamage();
                System.out.println("\nYou use " + selected.getName() + " for " + dmg + " damage.");
                return "DMG: " + dmg;
            case STUN:
                System.out.println("\nYou use " + selected.getName() + "and stun the enemy.");
                return "STUN";
            case DEFEND:
                setShield(0.5);
                System.out.println("\nYou use " + selected.getName() + " - you will reduce incoming damage by 50%.");
                return "DEF";
            default:
                return "SKIP";
        }
    }

    public void takeDamage(int raw)
    {
        int actual = raw;
        if (shieldPercent > 0.0)
        {
            actual = (int)Math.round(raw * (1.0 - shieldPercent));
            shieldPercent = 0.0;
        }
        hp = Math.max(0, hp - Math.max(0, actual));
        System.out.println(name + " takes " + actual + " damage (HP now " + hp + ")");
    }

    public void gainEnergy(int amt)
    {
        energy = Math.min(maxEnergy, energy + amt);
        System.out.println(name + " gains " + amt + " EN (EN now " + energy + ")");
    }

    public void healHp(int amt)
    {
        hp = Math.min(maxHp, hp + amt);
        System.out.println(name + " heals " + amt + " HP (HP now " + hp + ")");
    }
}