package com.rpglab.game.utils;

/**
 * Utility class providing console color codes and formatting constants for the Dungeon Adventure RPG.
 * This class contains ANSI escape codes that enable colored terminal output,
 * enhancing the visual presentation of game text and improving user experience.
 * 
 * <p>The class provides various color constants that can be concatenated with text
 * to display colored output in terminals that support ANSI escape codes.
 * All text formatting should be reset using the RESET constant after colored text.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * System.out.println(GameDisplay.RED + "Warning!" + GameDisplay.RESET);
 * System.out.println(GameDisplay.BOLD + GameDisplay.BLUE + "Hero Name" + GameDisplay.RESET);
 * }</pre>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class GameDisplay {
    /** ANSI reset code to return text formatting to normal */
    public static final String RESET = "\u001B[0m";
    
    /** ANSI color code for red text (typically used for monsters/enemies) */
    public static final String RED = "\u001B[31m";
    
    /** ANSI color code for green text (typically used for positive effects) */
    public static final String GREEN = "\u001B[32m";
    
    /** ANSI color code for yellow text (typically used for warnings/stats) */
    public static final String YELLOW = "\u001B[33m";
    
    /** ANSI color code for blue text (typically used for heroes) */
    public static final String BLUE = "\u001B[34m";
    
    /** ANSI color code for purple text (typically used for experience/magic) */
    public static final String PURPLE = "\u001B[35m";
    
    /** ANSI color code for cyan text (typically used for items/weapons) */
    public static final String CYAN = "\u001B[36m";
    
    /** ANSI formatting code for bold text */
    public static final String BOLD = "\u001B[1m";
}
