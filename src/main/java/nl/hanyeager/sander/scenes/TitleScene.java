package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.ParallaxBackground;
import nl.hanyeager.sander.entities.buttons.CreditsButton;
import nl.hanyeager.sander.entities.buttons.QuitGameButton;
import nl.hanyeager.sander.entities.buttons.StartButton;
import nl.hanyeager.sander.entities.buttons.TitleSceneButton;

public class TitleScene extends DynamicScene {
    private Cyberman cyberman;

    public TitleScene(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/CyberPunk2077Music.mp3");
        setBackgroundImage("backgrounds/cyberpunk-street.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new ParallaxBackground("backgrounds/back-buildings.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 40, 1.5));
        addEntity(new ParallaxBackground("backgrounds/far-buildings.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 39, 1.75));
        addEntity(new ParallaxBackground("backgrounds/foreground.png", new Coordinate2D(0, 0), new Size(this.getWidth() * 2, this.getHeight()), this, 38, 2.0));

        //TitleScene Text
        var cybermanText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "CyberMan"
        );
        cybermanText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        cybermanText.setFill(Color.DARKMAGENTA);
        cybermanText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(cybermanText);

        //Add StartButton Game
        StartButton startButton = new StartButton(cyberman, new Coordinate2D(getWidth() / 2, getHeight() / 2 + 85));
        addEntity(startButton);

        //Add QuitGameButton Game
        QuitGameButton quitGameButton = new QuitGameButton(cyberman, new Coordinate2D(getWidth() / 2, getHeight() / 2 + 130));
        addEntity(quitGameButton);

        //Add CreditsButton Game
        CreditsButton creditsButton = new CreditsButton(cyberman, new Coordinate2D(713, 31));
        addEntity(creditsButton);
    }

    public void addNewEntity(YaegerEntity entity){
        addEntity(entity);
    }
}
