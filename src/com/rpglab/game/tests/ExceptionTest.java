package com.rpglab.game.tests;

import com.rpglab.game.Exceptions.InvalidWeaponException;
import com.rpglab.game.Exceptions.NotEnoughResourceException;
import com.rpglab.game.characters.Hero;
import com.rpglab.game.items.weapons.Sword;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    void testInvalidWeaponException() {
        Hero hero = new Hero("Hero", 100, 20, 0.5) {
            @Override
            public void useSpecialSkill(com.rpglab.game.characters.Character target) {
                System.out.println("Using special skill on target: " + (target != null ? target.getName() : "N/A"));
            }

            @Override
            public com.rpglab.game.interfaces.CombatAction chooseAction(com.rpglab.game.interfaces.Combatente target) {
                return null; // Implementação de teste
            }
        };

        Sword sword = new Sword();

        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(sword);
        });

        assertEquals("Cannot equip weapon: level too low.", exception.getMessage());
    }

    @Test
    void testNotEnoughResourceException() {
        Hero hero = new Hero("Hero", 100, 20, 0.5) {
            @Override
            public void useSpecialSkill(com.rpglab.game.characters.Character target) {
                if (target == null) {
                    throw new NotEnoughResourceException("Resources are insufficient to perform this action.");
                }
                System.out.println("Using special skill on target: " + target.getName());
            }
            @Override
            public com.rpglab.game.interfaces.CombatAction chooseAction(com.rpglab.game.interfaces.Combatente target) {
                return null; // Test implementation
            }
        };

        Exception exception = assertThrows(NotEnoughResourceException.class, () -> {
            hero.useSpecialSkill(null); // Simulates lack of resources
        });

        assertEquals("Resources are insufficient to perform this action.", exception.getMessage());
    }
}