package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class PowerfulSpell implements CombatAction {
    
    @Override
    public void execute(Combatente hero, Combatente monster) {
        int damage = (hero.getStrength() * 3) / 2;
        monster.takeDamage(damage);
        System.out.println("The hero " + hero.getName() + " casts a powerful spell on " + monster.getName() + " dealing " + damage + " damage!");
    }
}
