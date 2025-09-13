package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class RustySword implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 12; // Rusty sword damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used rusty sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
