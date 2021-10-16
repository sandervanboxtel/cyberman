package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.hanyeager.sander.entities.CyberCar;

public class GameLevel extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunkMusic.mp3");
        setBackgroundImage("backgrounds/CyberPunkMain.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(new CyberCar("sprites/ship-01.png", new Coordinate2D(350, 350), Direction.RIGHT, new Size(125, 76)));
        addEntity(new CyberCar("sprites/ship-02.png", new Coordinate2D(350, 350), Direction.LEFT, new Size(125, 76)));
    }
}
