import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy
{
    protected final String name;
    protected int hp;
    protected int maxHp;
    protected boolean stunned = false;
    protected double shieldPercent = 0.0;
    protected final List<Move> moves = new ArrayList<>();
    protected final Random rng = new Random();

    public Enemy(String name, int baseHp)
    {
        this.name = name;
        this.maxHp = baseHp;
        this.hp = baseHp;
    }

    public String getName()
    {
        return name;
    }

    public int getHp()
    {
        return hp;
    }

    public boolean isAlive()
    {
        return hp > 0;
    }

    public boolean isStunned()
    {
        return stunned;
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

    public void takeDamage(int raw) {
        int actual = raw;
        if (shieldPercent > 0.0)
        {
            actual = (int)Math.round(raw * (1.0 - shieldPercent));
            shieldPercent = 0.0;
        }
        hp = Math.max(0, hp - Math.max(0, actual));
        System.out.println(name + " takes " + actual + " damage (HP now " + hp + ")");
    }

    protected Move chooseRandomMove()
    {
        return moves.get(rng.nextInt(moves.size()));
    }

    public String act(Player player)
    {
        if (stunned)
        {
            System.out.println(name + " is stunned and cannot act.");
            stunned = false;
            return "STUNNED";
        }

        Move m = chooseRandomMove();
        switch (m.getType())
        {
            case ATTACK:
                int dmg = m.getDamage();
                System.out.println(name + " uses " + m.getName() + " for " + dmg + " damage.");
                player.takeDamage(dmg);
                return "DMG: " + dmg;
            case STUN:
                System.out.println(name + " uses " + m.getName() + " and stuns you.");
                player.applyStun();
                return "STUN";
            case DEFEND:
                System.out.println(name + " uses " + m.getName() + " and braces (reducing next damage).");
                setShield(0.5);
                return "DEF";
            default:
                return "PASS";
        }
    }
}
