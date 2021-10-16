package nl.hanyeager.sander;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.hanyeager.sander.scenes.GameLevel;
import nl.hanyeager.sander.scenes.TitleScene;

public class Cyberman extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("CyberMan");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel());
    }
}
