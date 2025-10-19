package com.rpglab.game.items;
import com.rpglab.game.interfaces.Item;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({
    com.rpglab.game.items.weapons.Bow.class,
    com.rpglab.game.items.weapons.Staff.class,
    com.rpglab.game.items.weapons.SuperBow.class,
    com.rpglab.game.items.weapons.WillowStaff.class,
    com.rpglab.game.items.weapons.MoonStaff.class,
    com.rpglab.game.items.weapons.ExtremeSuperBow.class,
    com.rpglab.game.items.weapons.Sword.class
})

/**
 * Abstract base class for all weapons in the Dungeon Adventure RPG.
 * Weapons are items that can be equipped by characters to increase their
 * combat effectiveness. Each weapon has damage output, level requirements,
 * and a unique name for identification.
 * 
 * <p>Weapons implement the Item interface and provide the foundation for
 * all combat equipment in the game. Different weapon types extend this
 * class to provide specialized functionality for various character classes.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public abstract class Weapon implements Item {
    /** The damage value this weapon adds to attacks */
    private int damage;
    
    /** The minimum character level required to equip this weapon */
    private int minLevel;
    
    /** The name of this weapon */
    private String name;

    // This constructor is required for JAXB to instantiate the class during XML deserialization
    public Weapon() {
    }

    /**
     * Category of the weapon used to identify compatible hero classes.
     * Default implementations return OTHER; concrete weapon base classes
     * (e.g., Bow, Staff) should override getCategory() so all their
     * subclasses inherit the correct category.
     */
    public enum WeaponCategory { BOW, STAFF, SWORD, OTHER }

    /**
     * Constructs a new Weapon with the specified attributes.
     * 
     * @param damage The damage value this weapon provides
     * @param minLevel The minimum level required to equip this weapon
     * @param name The name of this weapon
     */
    public Weapon(int damage, int minLevel, String name) {
        this.damage = damage;
        this.minLevel = minLevel;
        this.name = name;
    }

    /**
     * Returns the damage value of this weapon.
     * This value is typically added to the character's base attack damage.
     * 
     * @return The weapon's damage as an integer
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the minimum level required to equip this weapon.
     * Characters below this level cannot use this weapon.
     * 
     * @return The minimum level requirement as an integer
     */
    public int getMinLevel() {
        return minLevel;
    }

    /**
     * Returns the name of this weapon.
     * Implementation of the Item interface method.
     * 
     * @return The weapon's name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the category of this weapon. By default returns OTHER.
     * Subclasses like Bow and Staff override this so checks can be
     * performed against weapon categories instead of concrete classes.
     *
     * @return WeaponCategory for this weapon
     */
    public WeaponCategory getCategory() {
        return WeaponCategory.OTHER;
    }
}

