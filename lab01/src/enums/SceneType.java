package enums;
import classes.Hero;

public enum SceneType {
    // Implementing description, and method to applyEffect(Hero hero) and describeScene.
    DUNGEON_ENTRANCE("Castle of the Demon King"),
    DARK_HALLWAY("Dark Hallway to the Demon King"),
    MONSTER_LAIR("Demon King's Room");

    private String description;

    SceneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void applyEffect(Hero hero) {
        // Implement effect on hero (undefined)
    }
}
