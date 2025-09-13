package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class Fireball implements CombatAction {
    @Override
    public void executar(Combatente user, Combatente target) {
        int damage = 30; // Fixed damage for Fireball
        user.takeDamage(damage);
        System.out.println(user.getName() + " casts Fireball on " + target.getName() + " for " + damage + " damage!");
    }
}
