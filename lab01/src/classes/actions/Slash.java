package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class Slash implements CombatAction {
    @Override
    public void executar(Combatente user, Combatente target) {
        int damage = 30; // Fixed damage for Slash
        user.takeDamage(damage);
        System.out.println(user.getName() + " casts Slash on " + target.getName() + " for " + damage + " damage!");
    }
}
