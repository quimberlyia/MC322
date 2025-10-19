package com.rpglab.game.tests;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.interfaces.Combatant;
import com.rpglab.game.interfaces.Lootable;
import com.rpglab.game.enums.WeaponType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CombatantTest {

    @Test
    void testHeroImplementsCombatant() {
        CombatAction[] moves = new CombatAction[0];
        Hero hero = new Hero("Herói", 100, 20, 0.5, moves) {
            @Override
            public void useSpecialSkill(com.rpglab.game.characters.Character target) {
                System.out.println("Usando habilidade especial no alvo: " + target.getName());
            }

            @Override
            public com.rpglab.game.interfaces.CombatAction chooseAction(Combatant target) {
                return null; // Implementação de teste
            }
        };
        assertTrue(hero instanceof Combatant, "Herói deve implementar a interface Combatant");
    }

    @Test
    void testMonsterImplementsCombatant() {
        WeaponType[] lootTable = new WeaponType[0];
        CombatAction[] moves = new CombatAction[0];
        Monster monster = new Monster("Monstro", 80, 15, 50, lootTable, moves);
        assertTrue(monster instanceof Combatant, "Monstro deve implementar a interface Combatant");
    }

    @Test
    void testHeroReceivesDamageAndAttacks() {
        CombatAction[] heroMoves = new CombatAction[0];
        Hero hero = new Hero("Herói", 100, 20, 0.5, heroMoves) {
            @Override
            public void useSpecialSkill(com.rpglab.game.characters.Character target) {
                System.out.println("Usando habilidade especial no alvo: " + target.getName());
            }

            @Override
            public com.rpglab.game.interfaces.CombatAction chooseAction(Combatant target) {
                return null; // Implementação de teste
            }
        };
        WeaponType[] lootTable = new WeaponType[0];
        CombatAction[] monsterMoves = new CombatAction[0];
        Monster monster = new Monster("Monstro", 80, 15, 50, lootTable, monsterMoves);

        // Herói ataca o monstro
        monster.takeDamage(hero.getStrength());
        assertEquals(60, monster.getHealthPoints(), "Monstro deve perder 20 de vida após ataque do Herói");

        // Monstro ataca o herói
        hero.takeDamage(monster.getStrength());
        assertEquals(85, hero.getHealthPoints(), "Herói deve perder 15 de vida após ataque do Monstro");
    }

    @Test
    void testMonsterReceivesDamageAndAttacks() {
        WeaponType[] lootTable = new WeaponType[0];
        CombatAction[] monsterMoves = new CombatAction[0];
        Monster monster = new Monster("Monstro", 80, 15, 50, lootTable, monsterMoves);
        CombatAction[] heroMoves = new CombatAction[0];
        Hero hero = new Hero("Herói", 100, 20, 0.5, heroMoves) {
            @Override
            public void useSpecialSkill(com.rpglab.game.characters.Character target) {
                System.out.println("Usando habilidade especial no alvo: " + target.getName());
            }

            @Override
            public com.rpglab.game.interfaces.CombatAction chooseAction(Combatant target) {
                return null; // Implementação de teste
            }
        };

        // Monstro ataca o herói
        hero.takeDamage(monster.getStrength());
        assertEquals(85, hero.getHealthPoints(), "Herói deve perder 15 de vida após ataque do Monstro");

        // Herói ataca o monstro
        monster.takeDamage(hero.getStrength());
        assertEquals(60, monster.getHealthPoints(), "Monstro deve perder 20 de vida após ataque do Herói");
    }

    @Test
    void testMonsterIsLootable() {
        WeaponType[] lootTable = new WeaponType[0];
        CombatAction[] moves = new CombatAction[0];
        Monster monster = new Monster("Monstro", 80, 15, 50, lootTable, moves);
        assertTrue(monster instanceof Lootable, "Monstro deve implementar a interface Lootable");
    }
}