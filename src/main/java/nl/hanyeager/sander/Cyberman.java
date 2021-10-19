package nl.hanyeager.sander;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.hanyeager.sander.scenes.*;

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
        addScene(1, new GameLevel(this));
        addScene(2, new GameOver(this));
        addScene(3, new GameWin(this));
        addScene(4, new CreditsScene(this));
        addScene(5, new GameLevelHard(this));
        addScene(6, new GameFinish(this));
    }
}
