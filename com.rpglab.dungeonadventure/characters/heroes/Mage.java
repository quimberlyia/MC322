package com.rpglab.dungeonadventure.characters.heroes;

import com.rpglab.dungeonadventure.battle.moves.HealingPotion;
import com.rpglab.dungeonadventure.battle.moves.PowerfulSpell;
import com.rpglab.dungeonadventure.characters.Character;
import com.rpglab.dungeonadventure.characters.Hero;
import com.rpglab.dungeonadventure.interfaces.CombatAction;
import com.rpglab.dungeonadventure.interfaces.Combatente;
import com.rpglab.dungeonadventure.items.weapons.Staff;

public class Mage extends Hero {
    private int mana;

    public Mage(String name, int healthPoints, int strength, int mana, double lucky) {
        super(name, healthPoints, strength, lucky);
        this.mana = mana;
        setWeapon(new Staff());
        
        // Add combat actions
        addAction(new PowerfulSpell());
        addAction(new HealingPotion());
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void useSpecialSkill(Character target) {

        // Check if random number is lower than lucky then use spell, otherwise fails

        if (Math.random() > getLucky()) {
            System.out.println(getName() + " tried to use a special skill but failed due to bad luck!");
            return;
        }

        int damage = getStrength() * 3;
        target.takeDamage(damage);
        setMana(getMana() - 10);
        System.out.println(getName() + " used a powerful spell on " + target.getName() + " for " + damage + " damage! Mana left: " + getMana());
    }

    @Override
    public CombatAction chooseAction(Combatente target) {
        if (action.isEmpty()) return null;
        int idx = (int) (Math.random() * action.size());
        return action.get(idx);
    }
}
