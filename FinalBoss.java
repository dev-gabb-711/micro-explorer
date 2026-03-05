public class FinalBoss extends Enemy
{
    public FinalBoss(int level)
    {
        super("The Omega Strain", 260 + level * 40);
        {
            int a1 = 22 + level * 4;
            int a2 = 24 + level * 4;
            int a3 = 26 + level * 4;
            int a4 = 28 + level * 4;
            int a5 = 32 + level * 5;

            moves.add(new Move("Genome Overwrite", MoveType.ATTACK, a1, 18));
            moves.add(new Move("Shapeshift", MoveType.ATTACK, a2, 18));
            moves.add(new Move("Reality Glitch", MoveType.ATTACK, a3, 20));
            moves.add(new Move("Corrupted Core", MoveType.ATTACK, a4, 22));
            moves.add(new Move("Final Overrun", MoveType.ATTACK, a5, 30));

            moves.add(new Move("Viral Surge", MoveType.STUN, 0, 24));
            moves.add(new Move("Chaos Field", MoveType.STUN, 0, 26));

            moves.add(new Move("Defensive Form", MoveType.DEFEND, 0, 14));
            moves.add(new Move("Genetic Fortification", MoveType.DEFEND, -30, 20));
        }
    }
}
