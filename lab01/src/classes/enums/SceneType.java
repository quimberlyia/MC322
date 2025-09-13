package classes.enums;
import classes.Hero;

public enum SceneType {
    // Implementing description, and method to applyEffect(Hero hero) and describeScene.
    DUNGEON_ENTRANCE("Description 1"),
    DARK_HALLWAY("Description 2"),
    MONSTER_LAIR("Description 3");

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

    public String describeScene() {
        return getDescription();
    }
}
