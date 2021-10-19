package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.buttons.PlayNewLevelButton;
import nl.hanyeager.sander.entities.buttons.TitleSceneButton;

public class GameWin extends StaticScene {
    private Cyberman cyberman;

    public GameWin(Cyberman cyberman){
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
                "Congratulations You Made It To Level 2!"
        );
        gameWinText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameWinText.setFill(Color.WHITESMOKE);
        gameWinText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
        addEntity(gameWinText);

        //Add PlayNewLevelButton
        PlayNewLevelButton playNewLevelButton = new PlayNewLevelButton(cyberman, new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50));
        addEntity(playNewLevelButton);

        //Add TitleSceneButton
        TitleSceneButton titleSceneButton = new TitleSceneButton(cyberman, new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100));
        addEntity(titleSceneButton);
    }
}
