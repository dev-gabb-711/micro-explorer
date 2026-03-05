public class NormalEnemy extends Enemy
{
    // typeName must be one of: Virion Scrapper, Chlorophage, Replicator Swarm, Hemovore, Neuro-Cyst
    public NormalEnemy(String typeName, int level)
    {
        super(typeName.trim(), 60 + level * 12); // hp scales with level
        // 3 attacks + 1 stun + 1 defend (damage scales with level)
        int a1 = 8 + level * 2;
        int a2 = 10 + level * 2;
        int a3 = 12 + level * 2;

        switch (typeName)
        {
            case "Virion Scrapper":
                moves.add(new Move("Fragment Swarm", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Static Puncture", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Corrupting Strand", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Toxin Cloud", MoveType.STUN, 0, 12));
                moves.add(new Move("Defensive Shroud", MoveType.DEFEND, 0, 6));
                break;
            case "Chlorophage":
                moves.add(new Move("Photosynthesis Drain", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Energy Siphon", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Spore Blight", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Light Absorption", MoveType.STUN, 0, 12));
                moves.add(new Move("Cellulose Shield", MoveType.DEFEND, 0, 6));
                break;
            case "Replicator Swarm":
                moves.add(new Move("Swarm Rush", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Rapid Division", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Viral Spikes", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Replication Spores", MoveType.STUN, 0, 12));
                moves.add(new Move("Covalent Shell", MoveType.DEFEND, 0, 6));
                break;
            case "Hemovore":
                moves.add(new Move("Oxygen Starve", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Bloodstream Rush", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Hemoglobin Theft", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Circulation Lock", MoveType.STUN, 0, 12));
                moves.add(new Move("Bio-Barrier", MoveType.DEFEND, 0, 6));
                break;
            case "Neuro-Cyst":
                moves.add(new Move("Signal Jam", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Synaptic Lash", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Pathway Scramble", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Neural Feedback", MoveType.STUN, 0, 12));
                moves.add(new Move("Mutated Carapace", MoveType.DEFEND, 0, 6));
                break;
            default:
                // fallback generic normal enemy
                moves.add(new Move("Scratch", MoveType.ATTACK, a1, 6));
                moves.add(new Move("Bite", MoveType.ATTACK, a2, 7));
                moves.add(new Move("Lash", MoveType.ATTACK, a3, 8));
                moves.add(new Move("Daze", MoveType.STUN, 0, 12));
                moves.add(new Move("Harden", MoveType.DEFEND, 0, 6));
                break;
        }
    }
}
