public class MiniBoss extends Enemy
{
    /*
    Types:
    L1: Proto-Scourge
    L2: Chloroplastus
    L3: The Hive-Mind
    L4: The Aquamorph
    L5: The Aero-Terror
    L6: The Organ-Eater
    L7: The Sanguine Wraith
    L8: The Synaptic Anomaly
    L9: Myocardius Prime
     */
    public MiniBoss(String typeName, int level)
    {
        super(typeName, 120 + level * 2);
        int b1 = 14 + level * 3;
        int b2 = 16 + level * 3;
        int b3 = 18 + level * 3;
        int b4 = 20 + level * 3;

        switch (typeName)
        {
            case "Proto-Scourge":
                moves.add(new Move("Amoebic Consume", MoveType.ATTACK, b1, 10));
                moves.add(new Move("Tentacle Lash", MoveType.ATTACK, b2, 12));
                moves.add(new Move("Viral Sprout", MoveType.ATTACK, b3, 12));
                moves.add(new Move("Toxin Blast", MoveType.ATTACK, b4, 14));
                moves.add(new Move("Slime Blind", MoveType.STUN, 0, 18));
                moves.add(new Move("Aqeous Shield", MoveType.DEFEND, 0, 10));
                break;
            case "Chloroplastus":
                moves.add(new Move("Photosynthesis Siphon", MoveType.ATTACK, b1, 10));
                moves.add(new Move("Energy Burn", MoveType.ATTACK, b2, 12));
                moves.add(new Move("Root-like Grasp", MoveType.ATTACK, b3, 12));
                moves.add(new Move("Nutrient Drain", MoveType.ATTACK, b4, 14));
                moves.add(new Move("Photosynthesis Inversion", MoveType.STUN, 0, 16));
                moves.add(new Move("Energy Sap", MoveType.STUN, 0, 18));
                moves.add(new Move("Root-like Defense", MoveType.DEFEND, 0, 10));
                break;
            case "The Hive-Mind":
                moves.add(new Move("Mass Replication", MoveType.ATTACK, b1, 11));
                moves.add(new Move("Swarm Devour", MoveType.ATTACK, b2, 13));
                moves.add(new Move("Colony Assault", MoveType.ATTACK, b3, 13));
                moves.add(new Move("Queen's Sting", MoveType.ATTACK, b4, 15));
                moves.add(new Move("Pheromone Confusion", MoveType.STUN, 0, 18));
                moves.add(new Move("Hive Mind", MoveType.STUN, 0, 18));
                moves.add(new Move("Chitinous Barrier", MoveType.DEFEND, 0, 12));
                break;
            case "The Aquamorph":
                moves.add(new Move("Gill Corrosion", MoveType.ATTACK, b1, 10));
                moves.add(new Move("Watery Grasp", MoveType.ATTACK, b2, 12));
                moves.add(new Move("Oxygen Starve", MoveType.ATTACK, b3, 13));
                moves.add(new Move("Cellular Rupture", MoveType.ATTACK, b4, 15));
                moves.add(new Move("Suffocation Cloud", MoveType.STUN, 0, 16));
                moves.add(new Move("Viral Spikes", MoveType.STUN, 0, 18));
                moves.add(new Move("Aquatic Evasion", MoveType.DEFEND, 0, 10));
                break;
            case "The Aero-Terror":
                moves.add(new Move("Winged Assault", MoveType.ATTACK, b1, 11));
                moves.add(new Move("Accelerated Spore", MoveType.ATTACK, b2, 12));
                moves.add(new Move("Spreading Blight", MoveType.ATTACK, b3, 13));
                moves.add(new Move("Mutagenic Storm", MoveType.ATTACK, b4, 15));
                moves.add(new Move("Spore Eruption", MoveType.STUN, 0, 18));
                moves.add(new Move("Airflow Block", MoveType.STUN, 0, 18));
                moves.add(new Move("Flight Maneuver", MoveType.DEFEND, 0, 12));
                break;
            case "The Organ-Eater":
                moves.add(new Move("Organ Collapse", MoveType.ATTACK, b1, 12));
                moves.add(new Move("Toxin Burst", MoveType.ATTACK, b2, 13));
                moves.add(new Move("Hepatic Corruption", MoveType.ATTACK, b3, 14));
                moves.add(new Move("Cellular Decay", MoveType.ATTACK, b4, 16));
                moves.add(new Move("Metabolic Stun", MoveType.STUN, 0, 18));
                moves.add(new Move("Toxin Injection", MoveType.STUN, 0, 18));
                moves.add(new Move("Regenerative Coat", MoveType.DEFEND, 0, 12));
                break;
            case "The Sanguine Wraith":
                moves.add(new Move("Hemoglobin Drain", MoveType.ATTACK, b1, 12));
                moves.add(new Move("Cellular Siphon", MoveType.ATTACK, b2, 13));
                moves.add(new Move("Bloodstream Swarm", MoveType.ATTACK, b3, 14));
                moves.add(new Move("Vascular Web", MoveType.ATTACK, b4, 16));
                moves.add(new Move("Circulation Stasis", MoveType.STUN, 0, 18));
                moves.add(new Move("Blood-Clot", MoveType.STUN, 0, 18));
                moves.add(new Move("Hemoglobin Shield", MoveType.DEFEND, 0, 12));
                break;
            case "The Synaptic Anomaly":
                moves.add(new Move("Signal Jam", MoveType.ATTACK, b1, 12));
                moves.add(new Move("Neural Shock", MoveType.ATTACK, b2, 13));
                moves.add(new Move("Pathway Scramble", MoveType.ATTACK, b3, 14));
                moves.add(new Move("Mind-Warp", MoveType.ATTACK, b4, 16));
                moves.add(new Move("Synaptic Echo", MoveType.STUN, 0, 18));
                moves.add(new Move("Cognitive Feedback", MoveType.STUN, 0, 18));
                moves.add(new Move("Cognitive Block", MoveType.DEFEND, 0, 12));
                break;
            case "Myocardius Prime":
                moves.add(new Move("Cardiac Arrest", MoveType.ATTACK, b1, 12));
                moves.add(new Move("Heart Strangle", MoveType.ATTACK, b2, 13));
                moves.add(new Move("Rhythmic Disruption", MoveType.ATTACK, b3, 14));
                moves.add(new Move("Mitochondrial Drain", MoveType.ATTACK, b4, 16));
                moves.add(new Move("Stasis Pulse", MoveType.STUN, 0, 20));
                moves.add(new Move("Adrenaline Surge", MoveType.STUN, 0, 20));
                moves.add(new Move("Tissue Hardening", MoveType.DEFEND, 0, 12));
                break;
            default:
                moves.add(new Move("Heavy Slash", MoveType.ATTACK, b1, 10));
                moves.add(new Move("Rend", MoveType.ATTACK, b2, 12));
                moves.add(new Move("Crush", MoveType.ATTACK, b3, 14));
                moves.add(new Move("Stun Wave", MoveType.STUN, 0, 16));
                moves.add(new Move("Fortify", MoveType.DEFEND, 0, 10));
                break;
        }
    }
}
