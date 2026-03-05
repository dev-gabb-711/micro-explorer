# MICRO EXPLORER THE WAR OF THE SMALL WORLD
Micro Explorer is a Java based command line interface adventure game where players shrink to a microscopic level to battle a supervirus. This project demonstrates object oriented design through a complex battle system and dynamic level progression. This is an entry for the 1 "TOO" Jam: Game Jam held from August 16 to August 30, 2025.

## STORY
The world is under threat from a mutated virus that clings to every life form it detects. As the best hope for the team you must delve into the world of cells. Your mission is to discover the true source of the virus and eliminate it before the host organisms collapse.

## GAME MECHANICS
### COMBAT SYSTEM
The turn based battle system features strategic energy management:
- ATTACK Deals direct damage to the target.
- STUN Force the enemy to skip their next turn.
- DEFEND Deploy a shield to reduce incoming damage by 50 percent for one turn.

### STATS
- HP Your health points. If these reach zero the game ends.
- ENERGY Required for special moves. Energy is gained by defeating enemy groups or solving puzzles.

### PROGRESSION
The game features 10 unique levels:
1. The Pond Microbe
2. The Plant Cell
3. The Insect Host
4. The Fish Cell
5. Nesting of the Birds Host
6. The Mammal Host
7. The Human Blood Cell
8. The Human Brain Cell
9. The Human Heart Cell
10. The Source

## TECHNICAL ARCHITECTURE
### CLASS OVERVIEW
- MAIN The entry point that initializes the game engine.
- GAME Handles the primary game loop map selection and background music.
- PLAYER Manages player attributes moves and state tracking for shields and stuns.
- BATTLE SYSTEM Logic controller for encounters ensuring proper turn order and win loss conditions.
- LEVEL AND LEVEL DATA Separates level configuration and story text from game logic.
- ENEMY HIERARCHY Uses inheritance for NormalEnemy MiniBoss and FinalBoss types with scaling stats.
- PUZZLE SYSTEM An abstract base class for Logic Memory and Pattern puzzles.

### KEY TECHNICAL FEATURES
- SCALING ALGORITHMS Enemy health and damage values are calculated using level based formulas.
- TYPE EFFECT A custom utility that prints characters with a delay for immersive storytelling.
- AUDIO INTEGRATION Uses the javax sound sampled library to play looped background music.
- STATUS EFFECTS Implementation of boolean flags and multipliers to handle stuns and defensive shielding.

### INSTALLATION AND RUNNING
#### PREREQUISITES
- Java Development Kit JDK 8 or higher.

#### CLONING THE REPOSITORY
- First,  clone the project using the following command:
```
git clone https://github.com/dev-gabb-711/micro-explorer.git
```

Navigate into the directory:
```
cd micro-explorer
```

#### COMPILING
Compile all source files from the root directory:
```
javac *.java
```

Run the application:
```
java Main
```

Note: Ensure the resources folder containing BG.wav is in the correct path relative to your execution directory to enable background music.

Thank you and enjoy playing this little CLI game I've made :))
