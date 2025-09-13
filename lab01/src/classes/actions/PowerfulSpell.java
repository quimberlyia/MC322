package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class PowerfulSpell implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int damage = 40;
        target.takeDamage(damage);
        System.out.println(user.getName() + " casts a powerful spell on " + target.getName() + " dealing " + damage + " damage!");
    }
}
