package com.rpglab.game.game;

import com.rpglab.game.battle.moves.*;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.characters.monsters.Cockatrice;
import com.rpglab.game.characters.monsters.DemonKing;
import com.rpglab.game.characters.monsters.Dragon;
import com.rpglab.game.characters.monsters.Lizardman;
import com.rpglab.game.characters.monsters.Skeleton;
import com.rpglab.game.characters.monsters.Slime;
import com.rpglab.game.enums.SceneType;
import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.World;
import com.rpglab.game.enums.WeaponType;
import static com.rpglab.game.enums.WeaponType.*;

/**
 * Represents the main dungeon world containing all combat scenes and encounters.
 * This class implements the World interface to create a complete dungeon experience
 * with progressively challenging areas and appropriately scaled rewards.
 * 
 * <p>The dungeon world consists of three main areas:</p>
 * <ul>
 *   <li><strong>Dungeon Entrance:</strong> Contains easier monsters (Slime, Skeleton, Lizardman)</li>
 *   <li><strong>Dark Hallway:</strong> Features mid-level threats (Dragon, Cockatrice)</li>
 *   <li><strong>Monster Lair:</strong> Houses the final boss (Demon King)</li>
 * </ul>
 * 
 * <p>Monster statistics and loot quality are dynamically scaled based on the
 * selected difficulty level, ensuring appropriate challenge and rewards for
 * different player skill levels.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 * @see World
 * @see CombatScene
 * @see Difficulty
 */
public class DungeonWorld implements World {
    /** Array of combat scenes that make up this dungeon world */
    CombatScene[] scenes;

    /**
     * Constructs a new dungeon world with scenes scaled to the specified difficulty.
     * This constructor creates a complete dungeon experience with three distinct areas,
     * each containing appropriately leveled monsters and loot.
     * 
     * <p>The difficulty parameter affects:</p>
     * <ul>
     *   <li>Monster health points (scaled by life multiplier)</li>
     *   <li>Monster damage output (scaled by damage multiplier)</li>
     *   <li>Loot quality and rarity</li>
     * </ul>
     * 
     * <p>This implementation uses shared aggregation for combat actions. Each unique
     * combat action is instantiated only once and shared among all monsters that use it.
     * This design follows the principle that combat actions are generic and reusable,
     * not dependent on specific character instances.</p>
     * 
     * @param Difficulty the difficulty setting that determines monster scaling and loot quality
     */
    public DungeonWorld(Difficulty Difficulty) {
        generateScenes(3);

        double lifeMult = Difficulty.getLifeMult();
        double damageMult = Difficulty.getDamageMult();
        
        // Create shared loot tables for each difficulty tier
        // These arrays are shared (aggregation) among monsters in the same area
        // Weapons are only instantiated when actually dropped via WeaponType.create()
        WeaponType[] easyLoot = new WeaponType[] { BOW, STAFF };
        WeaponType[] mediumLoot = new WeaponType[] { SUPER_BOW, WILLOW_STAFF };
        WeaponType[] hardLoot = new WeaponType[] { EXTREME_SUPER_BOW, MOON_STAFF, SWORD };

        // Create shared combat action instances for reuse across monsters
        // These actions are stateless and can be safely shared
        CombatAction acidSpit = new AcidSpit();
        CombatAction swallow = new Swallow();
        CombatAction rustySword = new RustySword();
        CombatAction tackle = new Tackle();
        CombatAction poisonousBite = new PoisonousBite();
        CombatAction clawSwipe = new ClawSwipe();
        CombatAction tailWhip = new TailWhip();
        CombatAction roar = new Roar();
        CombatAction fireBreath = new FireBreath();
        CombatAction petrifyingGaze = new PetrifyingGaze();
        CombatAction tailSwipe = new TailSwipe();
        CombatAction darkSlash = new DarkSlash();
        CombatAction darkSpell = new DarkSpell();

        scenes[0] = new CombatScene(SceneType.DUNGEON_ENTRANCE, new Monster[] {
            new Slime(
                newValue(50, lifeMult), // adjusted life
                newValue(5, damageMult), // adjusted damage
                40, 
                easyLoot,
                new CombatAction[] { acidSpit, swallow } // shared actions
            ),
            new Skeleton(
                newValue(70, lifeMult),
                newValue(10, damageMult),
                80,
                easyLoot,
                new CombatAction[] { rustySword, tackle } // shared actions
            ),
            new Lizardman(
                newValue(90, lifeMult),
                newValue(15, damageMult),
                100,
                mediumLoot,
                new CombatAction[] { poisonousBite, clawSwipe, tailWhip } // shared actions
            )
        });

        scenes[1] = new CombatScene(SceneType.DARK_HALLWAY, new Monster[] {
            new Dragon(
                newValue(150, lifeMult),
                newValue(35, damageMult),
                150,
                hardLoot,
                new CombatAction[] { roar, fireBreath } // shared actions
            ),
            new Cockatrice(
                newValue(80, lifeMult),
                newValue(30, damageMult),
                150,
                hardLoot, 
                new CombatAction[] { petrifyingGaze, tailSwipe } // shared actions
            )
        });

        scenes[2] = new CombatScene(SceneType.MONSTER_LAIR, new Monster[] {
            new DemonKing(
                newValue(200, lifeMult),
                newValue(50, damageMult),
                200,
                hardLoot,
                new CombatAction[] { darkSlash, darkSpell } // shared actions
            )
        });
    }

    /**
     * Initializes the scenes array with the specified number of combat scenes.
     * This method allocates memory for the combat scenes that will make up
     * the dungeon world structure.
     * 
     * @param scenes_number the number of scenes to create in this world
     */
    public void generateScenes(int scenes_number) {
        this.scenes = new CombatScene[scenes_number];
    }

    /**
     * Returns the array of combat scenes in this dungeon world.
     * This method provides access to all the scenes that make up
     * the complete dungeon experience.
     * 
     * @return the array of combat scenes in this world
     */
    public CombatScene[] getScenes() {
        return scenes;
    }

    /**
     * Calculates a new stat value by applying a difficulty multiplier.
     * This helper method scales monster statistics (health, damage) based
     * on the selected difficulty level to maintain appropriate challenge.
     * 
     * @param baseValue  the original unmodified stat value
     * @param multiplier the difficulty multiplier to apply
     * @return the scaled stat value as an integer
     */
    private int newValue(int baseValue, double multiplier) {
    return (int) (baseValue * multiplier);
}   
}
