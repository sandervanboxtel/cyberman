package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.buttons.CreditsButton;
import nl.hanyeager.sander.entities.buttons.PlayNewLevelButton;
import nl.hanyeager.sander.entities.buttons.TitleSceneButton;

public class GameFinish extends StaticScene {
    private Cyberman cyberman;

    public GameFinish(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/CyberPunkMain.jpg");
    }

    @Override
    public void setupEntities() {
        var gameWinText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Congratulations You Made It!\n" +
                        "You Are A Real CyberMan!!"
        );
        gameWinText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameWinText.setFill(Color.WHITESMOKE);
        gameWinText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
        addEntity(gameWinText);

        //Add CreditsButton Game
        CreditsButton creditsButton = new CreditsButton(cyberman, new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100));
        addEntity(creditsButton);
    }
}
