package nl.hanyeager.sander.entities.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.media.SoundClip;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.players.CyberMan;
import nl.hanyeager.sander.entities.text.CoinScoreText;

public class CoinHard extends Coin {
    public CoinHard(Cyberman cyberman, CoinScoreText coinScoreText, String image, Coordinate2D location, Direction direction, Size size) {
        super(cyberman, coinScoreText, image, location, direction, size);
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
                cyberman.setActiveScene(6);
            }
        }
    }
}
