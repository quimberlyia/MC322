package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class DarkSlash implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 45; // Powerful dark sword attack
        target.takeDamage(damage);
        System.out.println(user.getName() + " slashed dark enchanted sword on " + target.getName() + " dealing " + damage + " damage!");
    }
}
