package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.FireBreath;
import com.rpglab.game.battle.moves.Roar;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

/**
 * Represents a Dragon monster in the Dungeon Adventure RPG.
 * Dragons are powerful draconic creatures encountered in the Dark Hallway,
 * serving as formidable mid-game bosses. They possess devastating fire-based
 * attacks and intimidating presence that make them extremely dangerous foes.
 * 
 * <p>Dragons are equipped with two combat actions:</p>
 * <ul>
 *   <li>Roar - An intimidating sound attack that damages through fear and sonic force</li>
 *   <li>Fire Breath - A devastating fire-breathing attack dealing massive damage</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Dragon extends Monster {

    /**
     * Constructs a new Dragon monster with the specified attributes.
     * Automatically equips the dragon with Roar and Fire Breath combat actions.
     * 
     * @param name The dragon's name
     * @param healthPoints The dragon's initial health points
     * @param strength The dragon's strength value
     * @param experience The experience points awarded when this dragon is defeated
     * @param loot Array of weapons this dragon can drop as loot
     */
    public Dragon(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new Roar());
        addAction(new FireBreath());
    }
}
