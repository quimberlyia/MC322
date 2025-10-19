package com.rpglab.game.enums;

import com.rpglab.game.items.Weapon;
import com.rpglab.game.items.weapons.*;

/**
 * Enumeration of weapon types available in the game.
 * This enum serves as a factory for creating weapon instances, supporting
 * shared aggregation in the loot system.
 * 
 * <p>Instead of monsters storing weapon instances or class references,
 * they store WeaponType values. This allows:</p>
 * <ul>
 *   <li>Loot tables to be shared between multiple monsters (aggregation)</li>
 *   <li>Weapons to be instantiated only when actually dropped</li>
 *   <li>Type-safe weapon references without reflection</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * WeaponType[] lootTable = { WeaponType.BOW, WeaponType.STAFF };
 * Weapon droppedWeapon = lootTable[0].create(); // creates new Bow()
 * </pre>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public enum WeaponType {
    /** Basic bow for archer heroes */
    BOW {
        @Override
        public Weapon create() {
            return new Bow();
        }
    },
    
    /** Upgraded bow with higher damage */
    SUPER_BOW {
        @Override
        public Weapon create() {
            return new SuperBow();
        }
    },
    
    /** Highest tier bow requiring high level */
    EXTREME_SUPER_BOW {
        @Override
        public Weapon create() {
            return new ExtremeSuperBow();
        }
    },
    
    /** Basic staff for mage heroes */
    STAFF {
        @Override
        public Weapon create() {
            return new Staff();
        }
    },
    
    /** Upgraded staff with higher damage */
    WILLOW_STAFF {
        @Override
        public Weapon create() {
            return new WillowStaff();
        }
    },
    
    /** Highest tier staff with powerful magic */
    MOON_STAFF {
        @Override
        public Weapon create() {
            return new MoonStaff();
        }
    },
    
    /** Sword weapon (no hero currently uses this category) */
    SWORD {
        @Override
        public Weapon create() {
            return new Sword();
        }
    };

    /**
     * Creates a new instance of the weapon this type represents.
     * This factory method allows weapons to be instantiated on-demand
     * when monsters drop loot, rather than pre-creating instances.
     * 
     * @return a new weapon instance
     */
    public abstract Weapon create();
}
