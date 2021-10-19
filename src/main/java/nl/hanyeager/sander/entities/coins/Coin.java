package nl.hanyeager.sander.entities.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.players.CyberMan;
import nl.hanyeager.sander.entities.text.CoinScoreText;

import java.util.Random;

public class Coin extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    public Cyberman cyberman;
    public CoinScoreText coinScoreText;
    public int coin = 0;
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
            case RIGHT -> setAnchorLocationX(-size.width() + 25.0);
        }
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- (int)size.height()));
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().isAssignableFrom(CyberMan.class)) {
            var popSound = new SoundClip("audio/pop.mp3");
            popSound.play();

            remove();
            coinScoreText.setCoinScoreText(++coin);
            System.out.println(coin);

            if (coin == 1) {
                cyberman.setActiveScene(3);
            }
        }
    }
}
