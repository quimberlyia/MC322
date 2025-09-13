package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class TailSwipe implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 25; // Tail swipe damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " used tail swipe on " + target.getName() + " dealing " + damage + " damage!");
    }
}
