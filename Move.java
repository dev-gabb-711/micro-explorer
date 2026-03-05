public class Move
{
    private final String name;
    private final MoveType type;
    private final int damage;
    private final int energyCost;

    public Move(String name, MoveType type, int damage, int energyCost)
    {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public String getName() {
        return name;
    }

    public MoveType getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getEnergyCost() {
        return energyCost;
    }
}
