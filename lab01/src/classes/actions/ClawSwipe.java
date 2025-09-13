package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class ClawSwipe implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 18; // Claw swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used claw swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
