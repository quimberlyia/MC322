# Dungeon Adventure RPG

A text-based dungeon crawler RPG built in Java featuring turn-based combat, character progression, and multiple difficulty levels. Embark on an epic adventure through progressively challenging dungeon areas, facing various monsters and collecting powerful weapons along the way.

## 🎮 Game Features

### Character Classes
- **Mage**: Master of arcane magic with powerful spell attacks
- **Archer**: Skilled ranged combatant with precise shots

### Combat System
- Turn-based combat mechanics
- Multiple attack types and abilities
- Strategic decision-making in battles
- Experience and leveling system

### Dungeon Exploration
- Three distinct dungeon areas with increasing difficulty
- Environmental effects and atmospheric descriptions
- Progressive monster encounters
- Loot collection and weapon upgrades

### Difficulty Levels
- **Easy**: Reduced monster health and damage
- **Medium**: Balanced challenge
- **Hard**: Maximum difficulty with powerful enemies

## 🏗️ Project Structure

```
src/
├── com/rpglab/game/
│   ├── Main.java                 # Game entry point and main loop
│   ├── battle/moves/             # Combat action implementations
│   │   ├── AcidSpit.java
│   │   ├── ClawSwipe.java
│   │   ├── DarkSlash.java
│   │   ├── DarkSpell.java
│   │   ├── FireBreath.java
│   │   ├── HealingPotion.java
│   │   ├── PetrifyingGaze.java
│   │   ├── PoisonousBite.java
│   │   ├── PowerfulSpell.java
│   │   ├── PreciseShot.java
│   │   ├── Roar.java
│   │   ├── RustySword.java
│   │   ├── Swallow.java
│   │   ├── Tackle.java
│   │   ├── TailSwipe.java
│   │   └── TailWhip.java
│   ├── characters/               # Character hierarchy
│   │   ├── Character.java        # Abstract base class
│   │   ├── Hero.java            # Player character class
│   │   ├── Monster.java         # Enemy character class
│   │   ├── heroes/              # Hero specializations
│   │   │   ├── Archer.java
│   │   │   └── Mage.java
│   │   └── monsters/            # Monster implementations
│   │       ├── Cockatrice.java
│   │       ├── DemonKing.java
│   │       ├── Dragon.java
│   │       ├── Lizardman.java
│   │       ├── Skeleton.java
│   │       └── Slime.java
│   ├── enums/                   # Game enumerations
│   │   ├── Difficulty.java
│   │   └── SceneType.java
│   ├── Exceptions/              # Custom exceptions
│   │   ├── InvalidWeaponException.java
│   │   └── NotEnoughResourceException.java
│   ├── game/                    # Game logic and scenes
│   │   ├── CombatScene.java     # Battle encounters
│   │   ├── DungeonWorld.java    # World management
│   │   └── Menu.java           # UI and menus
│   ├── interfaces/              # Game interfaces
│   │   ├── CombatAction.java
│   │   ├── Combatente.java
│   │   ├── Event.java
│   │   ├── Item.java
│   │   ├── Lootable.java
│   │   ├── Scene.java
│   │   └── World.java
│   ├── items/                   # Item system
│   │   ├── Weapon.java          # Abstract weapon class
│   │   └── weapons/             # Weapon implementations
│   │       ├── Bow.java
│   │       ├── ExtremeSuperBow.java
│   │       ├── MoonStaff.java
│   │       ├── Staff.java
│   │       ├── SuperBow.java
│   │       ├── Sword.java
│   │       └── WillowStaff.java
│   └── utils/                   # Utility classes
│       ├── GameDisplay.java     # ANSI color formatting
│       └── InputManager.java    # Input validation
bin/                             # Compiled class files
docs/                            # Generated Javadoc documentation
lib/                             # Dependencies (if any)
```

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Command line interface (Terminal/PowerShell/Command Prompt)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/quimberlyia/MC322.git
   cd MC322
   ```

2. **Compile the project:**
   ```bash
   javac -d bin -sourcepath src src/com/rpglab/game/Main.java
   ```

### Running the Game

1. **Navigate to the project directory:**
   ```bash
   cd MC322
   ```

2. **Run the game:**
   ```bash
   java -cp bin com.rpglab.game.Main
   ```

## 🎯 How to Play

1. **Start Game**: Choose "Start New Game" from the main menu
2. **Select Difficulty**: Choose Easy, Medium, or Hard difficulty
3. **Choose Hero Class**: Select between Mage or Archer
4. **Combat**: Engage in turn-based battles with monsters
5. **Progress**: Defeat enemies, gain experience, and collect loot
6. **Victory**: Conquer all dungeon areas and defeat the Demon King

### Combat Controls
- Choose actions from the displayed menu
- Different classes have unique abilities
- Manage health and resources strategically
- Collect weapons to improve combat effectiveness

## 📚 Documentation

Complete API documentation is available in the `docs/` directory.

### Generating Documentation
```bash
javadoc -d docs -sourcepath src -subpackages com.rpglab.game -windowtitle "Dungeon Adventure RPG Documentation"
```

### Viewing Documentation
Open `docs/index.html` in your web browser to view the complete API documentation.

## 🛠️ Development

### Building from Source
```bash
# Compile all source files
javac -d bin -sourcepath src src/com/rpglab/game/Main.java

# Run with debugging
java -cp bin com.rpglab.game.Main
```

### Project Architecture

The game follows object-oriented design principles:

- **Interface-based design**: Clean separation of concerns with interfaces like `Combatente`, `CombatAction`, `Scene`, etc.
- **Inheritance hierarchy**: Character classes extend from abstract base classes
- **Strategy pattern**: Combat actions implement the `CombatAction` interface
- **Factory pattern**: Scene and monster creation through the `DungeonWorld` class

### Key Design Patterns Used
- **Template Method**: Character progression and combat flow
- **Strategy**: Different combat actions and abilities
- **Observer**: Event-driven game state changes
- **Factory**: Dynamic scene and monster generation

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Development Guidelines
- Follow Java naming conventions
- Add Javadoc comments to all public methods and classes
- Maintain the existing code style and structure
- Test new features thoroughly
- Update documentation as needed

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **quimberlyia**
- **gaamelu**

## 🙏 Acknowledgments

- Built as part of MC322 course project
- Inspired by classic dungeon crawler RPGs
- Special thanks to the Java community for excellent documentation and resources

---

**Happy adventuring! ⚔️🛡️**