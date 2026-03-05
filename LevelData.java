import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelData
{
    public static final String[] LEVEL_START = {
            "", // unused index 0
            "Level 1: The Pond Microbe - Small infections first bloom",
            "Level 2: The Plant Cell - Energy is being stolen",
            "Level 3: The Insect Host - Viral replication accelerates",
            "Level 4: The Fish Cell - Oxygen-processing organelles at risk",
            "Level 5: Nesting of the Bird's Host - Spreading faster, time-limited threats",
            "Level 6: The Mammal Host - Organs falter",
            "Level 7: The Human Blood Cell - Viral swarms approach",
            "Level 8: The Human Brain Cell — Signal disruption is next.",
            "Level 9: The Human Heart Cell — Near collapse.",
            "Level 10: The Source — The supervirus reveals itself."
    };

    public static final String[] LEVEL_END = {
            "", // 0
            "You cleared the Pond Microbe.",
            "You restored some photosynthesis.",
            "You disrupted the replication hives.",
            "You protected oxygen processing.",
            "You drove off the aerial carriers.",
            "You salvaged key organelles.",
            "You slowed the blood swarm.",
            "You restored signal paths.",
            "You held the heart's rhythm.",
            "You destroyed the Source — Small World saved."
    };

    // Enemy normal types (rotation)
    public static final String[] NORMAL_TYPES = {
            "Virion Scrapper", "Chlorophage", "Replicator Swarm", "Hemovore", "Neuro-Cyst"
    };

    public static String miniBossNameForLevel(int level)
    {
        return switch (level)
        {
            case 1 -> "Proto-Scourge";
            case 2 -> "Chloroplastus";
            case 3 -> "The Hive-Mind";
            case 4 -> "The Aquamorph";
            case 5 -> "The Aero-Terror";
            case 6 -> "The Organ-Eater";
            case 7 -> "The Sanguine Wraith";
            case 8 -> "The Synaptic Anomaly";
            case 9 -> "Myocardius Prime";
            default -> "Unknown MiniBoss";
        };
    }

    public static String finalBossName()
    {
        return "The Omega Strain";
    }

    // Per-level starting energy and hp
    public static final int[] LEVEL_START_ENERGY =
            {0, 500, 500, 525, 525, 550, 550, 575, 575, 600, 600};
    public static final int[] LEVEL_START_HP =
            {0, 100, 100, 125, 125, 150, 150, 175, 200, 225, 250};

    public static List<Puzzle> buildPuzzle(int level)
    {
        Random r = new Random();
        int i;
        int count = 2 + r.nextInt(2); // 2-3 puzzles per map
        List<Puzzle> list = new ArrayList<>();

        for (i = 0; i < count; i++)
        {
            int choice = r.nextInt(3); // 0 = pattern, 1 = logic, 2 = memory

            if (choice == 0)
            {
                list.addAll(buildPatternPuzzle());
            }
            else if (choice == 1)
            {
                list.addAll(buildLogicPuzzle());
            }
            else
            {
                list.addAll(buildMemoryPuzzle());
            }
        }
        return list;
    }

    private static List<Puzzle> buildPatternPuzzle()
    {
        List<Puzzle> puzzles = new ArrayList<>();
        puzzles.add(new PuzzlePattern("[A small logic puzzle appears]", "[Puzzle concluded]"));
        return puzzles;
    }

    private static List<Puzzle> buildLogicPuzzle()
    {
        List<Puzzle> puzzles = new ArrayList<>();
        puzzles.add(new PuzzleLogic("[A logic challenge appears]", "[Puzzle concluded]"));
        return puzzles;
    }

    private static List<Puzzle> buildMemoryPuzzle()
    {
        List<Puzzle> puzzles = new ArrayList<>();
        puzzles.add(new PuzzleMemory("[A memory challenge appears]", "[Puzzle concluded]"));
        return puzzles;
    }

    public static List<String> buildGroupNames(int level)
    {
        Random r = new Random();
        int i;
        int groups = 4 + r.nextInt(2); // 4-5 groups
        List<String> names = new ArrayList<>();
        for (i = 0; i < groups; i++)
        {
            String t = NORMAL_TYPES[i % NORMAL_TYPES.length];
            names.add(t + " (Group " + (i + 1) + ")");
        }

        return names;
    }
}
