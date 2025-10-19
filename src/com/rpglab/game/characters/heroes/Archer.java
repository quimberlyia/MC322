package com.rpglab.game.characters.heroes;

import com.rpglab.game.battle.moves.HealingPotion;
import com.rpglab.game.battle.moves.PreciseShot;
import com.rpglab.game.characters.Character;
import com.rpglab.game.characters.Hero;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.items.weapons.Bow;
import com.rpglab.game.items.Weapon.WeaponCategory; 

/**
 * Represents an Archer hero class in the Dungeon Adventure RPG.
 * Archers are ranged combat specialists who excel at precise, high-damage attacks
 * from a distance. They have a unique aim attribute that affects their accuracy
 * and combat effectiveness.
 * 
 * <p>Archers start with a bow weapon and have access to precise shot attacks
 * and healing potions. Their special skill allows them to deal double damage
 * with precise shots, though success depends on their luck attribute.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Archer extends Hero {
    /** The archer's aim value, affecting accuracy and precision in combat */
    private int aim;

    // No-arg constructor for JAXB
    protected Archer() {
        super();
    }

    /**
     * Constructs a new Archer with the specified attributes.
     * The archer is automatically equipped with a bow and gains access
     * to precise shot and healing potion combat actions.
     * 
     * @param name The archer's name
     * @param healthPoints The archer's initial health points
     * @param strength The archer's strength value
     * @param aim The archer's aim value for precision attacks
     * @param lucky The archer's luck value affecting special skill success
     */
    public Archer(String name, int healthPoints, int strength, int aim, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.aim = aim;
        setWeapon(new Bow());
        
        // Add combat actions
        addAction(new PreciseShot());
        addAction(new HealingPotion());
    }

    @Override
    public WeaponCategory[] allowedWeaponCategories() {
        return new WeaponCategory[] { WeaponCategory.BOW };
    }

    /**
     * Returns the archer's current aim value.
     * 
     * @return The aim value as an integer
     */
    public int getAim() {
        return aim;
    }

    /**
     * Uses the archer's special skill - a powerful precise shot.
     * The skill deals double the archer's strength in damage but has
     * a chance to fail based on the archer's luck attribute.
     * 
     * @param target The target character to receive the precise shot
     */
    public void useSpecialSkill(Character target) {

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 2;
        target.takeDamage(damage);
        System.out.println(getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
    }

    /**
     * Chooses a random combat action from the archer's available actions.
     * Implements the abstract method from Hero class to provide AI behavior
     * for the archer's combat decision making.
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
