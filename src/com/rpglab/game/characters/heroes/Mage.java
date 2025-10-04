package com.rpglab.game.characters.heroes;

import com.rpglab.game.battle.moves.HealingPotion;
import com.rpglab.game.battle.moves.PowerfulSpell;
import com.rpglab.game.characters.Character;
import com.rpglab.game.characters.Hero;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.items.weapons.Staff;

/**
 * Represents a Mage hero class in the Dungeon Adventure RPG.
 * Mages are magical combat specialists who use mana to cast powerful spells
 * and deal significant magical damage to their enemies. They are characterized
 * by their high magical damage output but limited by their mana resource.
 * 
 * <p>Mages start with a staff weapon and have access to powerful spells
 * and healing potions. Their special skill allows them to cast devastating
 * spells that deal triple damage, but consumes mana and depends on luck.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Mage extends Hero {
    /** The mage's current mana points, used for casting spells */
    private int mana;

    /**
     * Constructs a new Mage with the specified attributes.
     * The mage is automatically equipped with a staff and gains access
     * to powerful spell and healing potion combat actions.
     * 
     * @param name The mage's name
     * @param healthPoints The mage's initial health points
     * @param strength The mage's strength value
     * @param mana The mage's initial mana points for casting spells
     * @param lucky The mage's luck value affecting special skill success
     */
    public Mage(String name, int healthPoints, int strength, int mana, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.mana = mana;
        setWeapon(new Staff());
        
        // Add combat actions
        addAction(new PowerfulSpell());
        addAction(new HealingPotion());
    }

    /**
     * Returns the mage's current mana points.
     * 
     * @return The current mana as an integer
     */
    public int getMana() {
        return mana;
    }

    /**
     * Sets the mage's mana to the specified value.
     * 
     * @param mana The new mana value
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Uses the mage's special skill - a devastating magical spell.
     * The skill deals triple the mage's strength in damage and consumes
     * 10 mana points. Success depends on the mage's luck attribute.
     * 
     * @param target The target character to receive the powerful spell
     */
    public void useSpecialSkill(Character target) {

        // Check if random number is lower than lucky then use spell, otherwise fails

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 3;
        target.takeDamage(damage);
        setMana(getMana() - 10);
        System.out.println(getName() + " used a powerful spell on " + target.getName() + " for " + damage + " damage! Mana left: " + getMana());
    }

    /**
     * Chooses a random combat action from the mage's available actions.
     * Implements the abstract method from Hero class to provide AI behavior
     * for the mage's combat decision making.
     * 
     * @param target The target combatant for the action
     * @return A randomly selected CombatAction, or null if no actions are available
     */
    public CombatAction chooseAction(Combatente target) {
        if (action.isEmpty()) return null;
        int idx = (int) (Math.random() * action.size());
        return action.get(idx);
    }
}
