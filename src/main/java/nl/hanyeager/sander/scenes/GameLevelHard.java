package nl.hanyeager.sander.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.coins.Coin;
import nl.hanyeager.sander.entities.coins.CoinHard;
import nl.hanyeager.sander.entities.players.CyberMan;
import nl.hanyeager.sander.entities.cybercar.CyberCar;
import nl.hanyeager.sander.entities.text.CoinScoreText;
import nl.hanyeager.sander.entities.text.HealthText;

public class GameLevelHard extends DynamicScene {
    private Cyberman cyberman;

    public GameLevelHard(Cyberman cyberman){
        this.cyberman = cyberman;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/cyberpunkmusic.mp3");
        setBackgroundImage("backgrounds/CyberPunkMain.jpg");
    }

    @Override
    public void setupEntities() {
        //GameLevelHardText
        var gameLevelText = new TextEntity(
                new Coordinate2D(getWidth() / 2, 31),
                "Boss Level"
        );
        gameLevelText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameLevelText.setFill(Color.WHITESMOKE);
        gameLevelText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 31));
        addEntity(gameLevelText);

        //Add the Cyber Cars
        addEntity(new CyberCar("sprites/ship-01.png", new Coordinate2D(550, 350), Direction.RIGHT, new Size(125, 76)));
        addEntity(new CyberCar("sprites/ship-02.png", new Coordinate2D(250, 350), Direction.LEFT, new Size(125, 76)));
        addEntity(new CyberCar("sprites/ship-03.png", new Coordinate2D(150, 350), Direction.LEFT, new Size(125, 76)));

        //Add the CoinScoreText
        CoinScoreText coinScoreText = new CoinScoreText(new Coordinate2D(650, 50));
        addEntity(coinScoreText);

        //Add the Coin
        addEntity(new CoinHard(cyberman, coinScoreText, "sprites/cybercoin.png", new Coordinate2D(350, 350), Direction.LEFT, new Size(40, 80)));

        //Add the HealthText
        HealthText healthText = new HealthText(new Coordinate2D(650, 13));
        addEntity(healthText);

        //Add the CyberMan
        addEntity(new CyberMan(new Coordinate2D(getWidth() / 2, getHeight() / 2), healthText, cyberman));
    }
}
