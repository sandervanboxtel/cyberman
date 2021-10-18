package nl.hanyeager.sander.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.text.CoinScoreText;

import java.util.Random;

public class Coin extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private Cyberman cyberman;
    private CoinScoreText coinScoreText;
    private int coin = 0;
    private Size size;
    private Direction direction;

    public Coin(Cyberman cyberman, CoinScoreText coinScoreText, String image, Coordinate2D location, Direction direction, Size size) {
        super(image, location, size);
        setMotion(1, direction);
        this.cyberman = cyberman;
        this.coinScoreText = coinScoreText;
        coinScoreText.setCoinScoreText(coin);
        this.size = size;
        this.direction = direction;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (direction) {
            case LEFT -> setAnchorLocationX(getSceneWidth());
            case RIGHT -> setAnchorLocationX(-size.width() + 25.0); // Quick fix for cars not displaying on screen after crossing boundary
        }

        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- (int)size.height()));
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().isAssignableFrom(CyberMan.class)) {
            var popSound = new SoundClip("audio/coin-pickup-sound.mp3");
            popSound.play();

            remove();
            coin++;
            coinScoreText.setCoinScoreText(coin);

            if (coin == 3) {
                cyberman.setActiveScene(2);
            }
        }
    }
}
