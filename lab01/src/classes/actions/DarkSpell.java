package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class DarkSpell implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 40; // Powerful dark magic damage
        target.takeDamage(damage);
        System.out.println(user.getName() + " cast a powerful dark spell on " + target.getName() + " dealing " + damage + " damage!");
    }
}
