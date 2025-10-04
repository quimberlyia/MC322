package com.rpglab.game.tests;

import com.rpglab.game.enums.Difficulty;
import com.rpglab.game.game.CombatScene;
import com.rpglab.game.game.DungeonWorld;
import com.rpglab.game.characters.Monster;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to validate difficulty scaling in the game.
 * Verifies that different difficulty levels generate worlds with
 * appropriately scaled characteristics.
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class DifficultyScalingTest {

    /**
     * Tests that health points scale correctly across all difficulty levels.
     * Validates that all monsters have progressively more HP: EASY < MEDIUM < HARD
     * for all scenes in the dungeon.
     */
    @Test
    void testHealthPointsScaling_AcrossDifficulties() {
        // Arrange: Create worlds with all three difficulty levels
        DungeonWorld easyWorld = new DungeonWorld(Difficulty.EASY);
        DungeonWorld mediumWorld = new DungeonWorld(Difficulty.MEDIUM);
        DungeonWorld hardWorld = new DungeonWorld(Difficulty.HARD);

        // Act: Get all scenes from each world
        CombatScene[] easyScenes = easyWorld.getScenes();
        CombatScene[] mediumScenes = mediumWorld.getScenes();
        CombatScene[] hardScenes = hardWorld.getScenes();

        // Assert: Verify progression for ALL monsters in ALL scenes
        for (int sceneIndex = 0; sceneIndex < easyScenes.length; sceneIndex++) {
            Monster[] easyMonsters = easyScenes[sceneIndex].getMonsters();
            Monster[] mediumMonsters = mediumScenes[sceneIndex].getMonsters();
            Monster[] hardMonsters = hardScenes[sceneIndex].getMonsters();

            assertEquals(easyMonsters.length, mediumMonsters.length,
                "Number of monsters should be consistent across difficulties");
            assertEquals(mediumMonsters.length, hardMonsters.length,
                "Number of monsters should be consistent across difficulties");

            for (int monsterIndex = 0; monsterIndex < easyMonsters.length; monsterIndex++) {
                Monster easyMonster = easyMonsters[monsterIndex];
                Monster mediumMonster = mediumMonsters[monsterIndex];
                Monster hardMonster = hardMonsters[monsterIndex];

                // Verify progression: EASY < MEDIUM < HARD
                assertTrue(easyMonster.getHealthPoints() < mediumMonster.getHealthPoints(),
                    String.format("%s HP: MEDIUM (%d) should be > EASY (%d)",
                        easyMonster.getName(), mediumMonster.getHealthPoints(), easyMonster.getHealthPoints()));

                assertTrue(mediumMonster.getHealthPoints() < hardMonster.getHealthPoints(),
                    String.format("%s HP: HARD (%d) should be > MEDIUM (%d)",
                        mediumMonster.getName(), hardMonster.getHealthPoints(), mediumMonster.getHealthPoints()));
            }
        }
    }

    /**
     * Tests that strength points scale correctly across all difficulty levels.
     * Validates that all monsters have progressively more strength: EASY < MEDIUM < HARD
     * for all scenes in the dungeon.
     */
    @Test
    void testStrengthPointsScaling_AcrossDifficulties() {
        // Arrange: Create worlds with all three difficulty levels
        DungeonWorld easyWorld = new DungeonWorld(Difficulty.EASY);
        DungeonWorld mediumWorld = new DungeonWorld(Difficulty.MEDIUM);
        DungeonWorld hardWorld = new DungeonWorld(Difficulty.HARD);

        // Act: Get all scenes from each world
        CombatScene[] easyScenes = easyWorld.getScenes();
        CombatScene[] mediumScenes = mediumWorld.getScenes();
        CombatScene[] hardScenes = hardWorld.getScenes();

        // Assert: Verify progression for ALL monsters in ALL scenes
        for (int sceneIndex = 0; sceneIndex < easyScenes.length; sceneIndex++) {
            Monster[] easyMonsters = easyScenes[sceneIndex].getMonsters();
            Monster[] mediumMonsters = mediumScenes[sceneIndex].getMonsters();
            Monster[] hardMonsters = hardScenes[sceneIndex].getMonsters();

            for (int monsterIndex = 0; monsterIndex < easyMonsters.length; monsterIndex++) {
                Monster easyMonster = easyMonsters[monsterIndex];
                Monster mediumMonster = mediumMonsters[monsterIndex];
                Monster hardMonster = hardMonsters[monsterIndex];

                // Verify progression: EASY < MEDIUM < HARD
                assertTrue(easyMonster.getStrength() < mediumMonster.getStrength(),
                    String.format("%s Strength: MEDIUM (%d) should be > EASY (%d)",
                        easyMonster.getName(), mediumMonster.getStrength(), easyMonster.getStrength()));

                assertTrue(mediumMonster.getStrength() < hardMonster.getStrength(),
                    String.format("%s Strength: HARD (%d) should be > MEDIUM (%d)",
                        mediumMonster.getName(), hardMonster.getStrength(), mediumMonster.getStrength()));
            }
        }
    }
}
