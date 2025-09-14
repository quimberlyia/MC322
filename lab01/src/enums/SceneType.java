package enums;
import classes.Hero;

public enum SceneType {
    DUNGEON_ENTRANCE("Castle of the Demon King") {
        @Override
        public void applyEffect(Hero hero) {
            System.out.println("You feel a chill as you enter the castle.");
        }
    },
    DARK_HALLWAY("Dark Hallway to the Demon King") {
        @Override
        public void applyEffect(Hero hero) {
            System.out.println("You hear eerie sounds echoing through the hallway.");
            hero.takeDamage(10);
            System.out.println("The Hero has taken 10 damage from the eerie atmosphere.");
            
        }
    },
    MONSTER_LAIR("Demon King's Room") {
        @Override
        public void applyEffect(Hero hero) {
            // Example effect: Final battle with the Demon King
            System.out.println("The Demon King appears! Prepare for the final battle!");
            hero.takeDamage(30); 
            System.out.println("The Hero has taken 30 damage from the Demon King.");
        }
    };

    private String description;

    SceneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void applyEffect(Hero hero);
}
