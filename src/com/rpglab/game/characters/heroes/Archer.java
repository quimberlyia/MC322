package com.rpglab.game.characters.heroes;

import com.rpglab.game.battle.moves.HealingPotion;
import com.rpglab.game.battle.moves.PreciseShot;
import com.rpglab.game.characters.Character;
import com.rpglab.game.characters.Hero;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.items.weapons.Bow;

public class Archer extends Hero {
    private int aim;

    public Archer(String name, int healthPoints, int strength, int aim, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.aim = aim;
        setWeapon(new Bow());
        
        // Add combat actions
        addAction(new PreciseShot());
        addAction(new HealingPotion());
    }

    public int getAim() {
        return aim;
    }

    public void useSpecialSkill(Character target) {

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 2;
        target.takeDamage(damage);
        System.out.println(getName() + " used a precise shot on " + target.getName() + " for " + damage + " damage!");
    }

    @Override
    public CombatAction chooseAction(Combatente target) {
        if (action.isEmpty()) return null;
        int idx = (int) (Math.random() * action.size());
        return action.get(idx);
    }
}
