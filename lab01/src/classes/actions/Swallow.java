package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class Swallow implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = user.getHealthPoints() / 10; // Damage based on user's health
        target.takeDamage(damage);
        System.out.println(user.getName() + " swallows " + target.getName() + " dealing " + damage + " damage!");
    }
}
