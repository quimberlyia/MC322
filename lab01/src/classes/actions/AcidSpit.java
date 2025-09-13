package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class AcidSpit implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 15; // Fixed acid damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used acid spit on " + target.getName() + " dealing " + damage + " damage!");
    }
}
