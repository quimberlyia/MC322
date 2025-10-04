package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A devastating magical attack combat action primarily used by Mage heroes.
 * This spell delivers enhanced magical damage by channeling arcane energy,
 * making it significantly more effective than standard attacks.
 * 
 * <p>The powerful spell calculates damage based on the user's strength with
 * a 1.5x multiplier, representing the concentrated magical force.
 * This makes it particularly effective for mage characters who specialize
 * in magical combat and spellcasting.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class PowerfulSpell implements CombatAction {
    
    /**
     * Executes a powerful magical spell against the target.
     * Calculates damage as 1.5 times the user's strength value,
     * representing the enhanced effectiveness of concentrated magical energy.
     * 
     * @param hero The combatant casting the powerful spell
     * @param monster The combatant receiving the magical attack
     */
    public void execute(Combatente hero, Combatente monster) {
        int damage = (hero.getStrength() * 3 + hero.getWeapon().getDamage()) / 2;
        monster.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " casts a powerful spell on " + monster.getName() + " with " + hero.getWeapon().getName() + " dealing " + damage + " damage!");
    }
}
