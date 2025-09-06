package classes;

public class Scene {

    int level;
    Monster[] monsters;
    String enviroment;

    public Scene(int level, Monster[] monsters, String enviroment) {
        setLevel(level);
        setMonsters(monsters);
        setEnvironment(enviroment);
    }

    public int getLevel() {
        return level;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public String getEnvironment() {
        return enviroment;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public void setEnvironment(String enviroment) {
        this.enviroment = enviroment;
    }
}
