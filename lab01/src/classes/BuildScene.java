package classes;

public class BuildScene {

    public BuildScene() {
    }

    public static Scene[] generateScenes(int n) {
        Scene[] scenes = new Scene[n];
        for (int i = 0; i < n; i++) {
            scenes[i] = new Scene(i + 1, new Monster[] {}, "");
        }
        return scenes;
    }
}
