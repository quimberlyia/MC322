package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class PreciseShot implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 15;
        target.takeDamage(damage);
        System.out.println(user.getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
    }
}
