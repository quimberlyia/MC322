package com.rpglab.game.characters.monsters;

import com.rpglab.game.battle.moves.DarkSlash;
import com.rpglab.game.battle.moves.DarkSpell;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.items.Weapon;

/**
 * Represents the Demon King, the final boss of the Dungeon Adventure RPG.
 * The Demon King is the ultimate antagonist encountered in the Monster Lair,
 * wielding both dark magic and an enchanted sword. Defeating the Demon King
 * is the victory condition for completing the game.
 * 
 * <p>The Demon King is equipped with two powerful combat actions:</p>
 * <ul>
 *   <li>Dark Slash - A devastating dark-enchanted sword attack</li>
 *   <li>Dark Spell - A powerful dark magic spell attack</li>
 * </ul>
 * 
 * <p>As the final boss, the Demon King has significantly higher stats than
 * other monsters and represents the ultimate challenge for heroes.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class DemonKing extends Monster {

    /**
     * Constructs a new Demon King monster with the specified attributes.
     * Automatically equips the Demon King with Dark Slash and Dark Spell
     * combat actions, representing his mastery of both martial and magical combat.
     * 
     * @param name The Demon King's name
     * @param healthPoints The Demon King's initial health points
     * @param strength The Demon King's strength value
     * @param experience The experience points awarded when the Demon King is defeated
     * @param loot Array of weapons the Demon King can drop as loot
     */
    public DemonKing(String name, int healthPoints, int strength, int experience, Weapon[] loot) {
        super(name, healthPoints, strength, experience, loot);
        addAction(new DarkSlash());
        addAction(new DarkSpell());
    }
}
