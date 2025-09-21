package com.rpglab.game.Exceptions;

/**
 * Exception thrown when an invalid weapon operation is attempted.
 * This exception is used to indicate that a weapon cannot be used,
 * equipped, or accessed due to various validation failures such as
 * level requirements, class restrictions, or other game rules.
 * 
 * <p>Common scenarios that trigger this exception include:</p>
 * <ul>
 *   <li>Attempting to equip a weapon with insufficient character level</li>
 *   <li>Trying to use a weapon incompatible with the character class</li>
 *   <li>Accessing a weapon that doesn't exist or is corrupted</li>
 *   <li>Using a weapon in an invalid game state</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class InvalidWeaponException extends Exception {
    
    /**
     * Constructs a new InvalidWeaponException with the specified detail message.
     * The message should describe the specific reason why the weapon operation
     * is invalid, providing helpful information for debugging or user feedback.
     * 
     * @param message The detail message explaining the invalid weapon operation
     */
    public InvalidWeaponException(String message) {
        super(message);
    }
}
