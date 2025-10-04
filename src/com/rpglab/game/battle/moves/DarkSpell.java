package com.rpglab.game.battle.moves;

import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;

/**
 * A devastating dark magic spell used by powerful evil spellcasters.
 * This combat action channels malevolent arcane energies to inflict
 * significant magical damage on the target through dark sorcery.
 * 
 * <p>This spell is typically cast by high-level monsters with magical
 * abilities, such as the Demon King, representing advanced dark magic
 * that can bypass physical defenses.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class DarkSpell implements CombatAction {
    
    /**
     * Executes the dark spell attack on the specified target.
     * The spell deals 40 points of dark magical damage, representing
     * powerful sorcery that channels malevolent arcane forces.
     * 
     * @param user   the combatant casting the dark spell (typically powerful magic users)
     * @param target the combatant receiving the dark magical damage
     */
    public void execute(Combatente user, Combatente target) {
        int damage = 40; // Powerful dark magic damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " cast a powerful dark spell on " + target.getName() + " dealing " + damage + " damage!");
    }
}
