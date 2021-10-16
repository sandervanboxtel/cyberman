package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.buttons.StartButton;

public class TitleScene extends StaticScene {

    private Cyberman cyberman;

    public TitleScene(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/CyberPunkMenu.jpg");
    }

    @Override
    public void setupEntities() {
        //TitleScene Text
        var waterworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "CyberMan"
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.DARKMAGENTA);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterworldText);

        //Add StartButton Game
        StartButton startButton = new StartButton(cyberman, new Coordinate2D(350, 350 ));
        addEntity(startButton);
    }
}
