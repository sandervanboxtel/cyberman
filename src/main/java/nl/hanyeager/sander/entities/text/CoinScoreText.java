package nl.hanyeager.sander.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CoinScoreText extends TextEntity {
    public CoinScoreText(Coordinate2D initialLocation){
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKMAGENTA);
    }

    public void setCoinScoreText(int coin){
        setText("Coins: " + coin);
    }
}
