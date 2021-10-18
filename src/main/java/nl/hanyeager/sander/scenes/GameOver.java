package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.buttons.PlayAgainButton;
import nl.hanyeager.sander.entities.buttons.TitleSceneButton;

public class GameOver extends StaticScene {
    private Cyberman cyberman;

    public GameOver(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/CyberPunkMenu.jpg");
    }

    @Override
    public void setupEntities() {
        var gameoverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        gameoverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameoverText.setFill(Color.DARKMAGENTA);
        gameoverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameoverText);

        //Add PlayAgain
        PlayAgainButton playAgainButton = new PlayAgainButton(cyberman, new Coordinate2D(350, 350 ));
        addEntity(playAgainButton);

        //Add TitleSceneButton
        TitleSceneButton titleSceneButton = new TitleSceneButton(cyberman, new Coordinate2D(350, 450 ));
        addEntity(titleSceneButton);
    }
}
