package classes.actions;

import interfaces.CombatAction;
import interfaces.Combatente;

public class HealingPotion implements CombatAction {
    
    @Override
    public void execute(Combatente user, Combatente target) {
        int healAmount = 30;
        user.heal(healAmount);
        System.out.println(user.getName() + " drinks a healing potion and recovers " + healAmount + " health points!");
    }
}
