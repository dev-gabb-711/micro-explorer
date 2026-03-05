import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Level {
    private final int levelNum;
    private final Scanner sc;
    private final BattleSystem bs;

    public Level(int levelNum, Scanner sc, BattleSystem bs) {
        this.levelNum = levelNum;
        this.sc = sc;
        this.bs = bs;
    }

    public void play(Player player)
    {
        System.out.println("\n=== LEVEL " + levelNum + " ===");
        TypingEffect.typeMessage(LevelData.LEVEL_START[levelNum]);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        player.setMapLevel(levelNum);
        player.setStartingStats(LevelData.LEVEL_START_ENERGY[levelNum], LevelData.LEVEL_START_HP[levelNum]);

        // Puzzles first
        int i;
        List<Puzzle> puzzles = LevelData.buildPuzzle(levelNum);
        Collections.shuffle(puzzles);

        for (i = 0; i < puzzles.size(); i++)
        {
            System.out.println("\n--- Puzzle " + (i + 1) + " ---");
            boolean ok = puzzles.get(i).run(sc);

            if (ok)
            {
                player.gainEnergy(25);
            }
            else
            {
                player.takeDamage(10);
                if (!player.isAlive())
                {
                    System.out.println("You fell during the puzzle. Game over.");
                    return;
                }
            }
        }

        // Enemy groups
        List<String> groups= LevelData.buildGroupNames(levelNum);
        Collections.shuffle(groups);
        for (i = 0; i < groups.size(); i++)
        {
            String groupName = groups.get(i);
            System.out.println("\n --- Approaching Enemy Group " + (i + 1) + ": " + groupName + " ---");
            Enemy enemy = new NormalEnemy(groupName.split("\\(")[0].trim(), levelNum); // use base type
            boolean survived = bs.fight(player, enemy);
            if (!survived)
            {
                return;
            }
            player.gainEnergy(100);
        }

        // Mini-boss
        System.out.println("\n --- MINI BOSS APPROACHING ---");
        String mbName = LevelData.miniBossNameForLevel(levelNum);
        System.out.println(LevelData.LEVEL_START[levelNum].replace("Start", "") + " " + "[Mini-boss: " + mbName + "]");
        Enemy mini = new MiniBoss(mbName, levelNum);
        boolean mbSurvived = bs.fight(player, mini);
        if (!mbSurvived)
        {
            return;
        }

        // Final-boss
        if (levelNum == 10)
        {
            System.out.println("\n --- FINAL BOSS: " + LevelData.finalBossName() + " ---");
            Enemy finalBoss = new FinalBoss(levelNum);
            boolean finalSurv = bs.fight(player, finalBoss);
            if (!finalSurv)
            {
                return;
            }
        }

        // level clear reward
        player.gainEnergy(50);
        System.out.println(LevelData.LEVEL_END[levelNum]);
    }

}
