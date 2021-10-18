package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.buttons.TitleSceneButton;

public class CreditsScene extends StaticScene {
    private Cyberman cyberman;

    public CreditsScene(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/CyberPunkMain.jpg");
    }

    @Override
    public void setupEntities() {
        //TitleScene Text
        var creditsText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                """
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."""
        );
        creditsText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        creditsText.setFill(Color.WHITESMOKE);
        creditsText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 13));
        addEntity(creditsText);

        //Add TitleSceneButton Game
        TitleSceneButton titleSceneButton = new TitleSceneButton(cyberman, new Coordinate2D(350, 350 ));
        addEntity(titleSceneButton);
    }
}
