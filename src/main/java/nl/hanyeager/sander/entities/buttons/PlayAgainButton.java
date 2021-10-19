package nl.hanyeager.sander.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.hanyeager.sander.Cyberman;

public class PlayAgainButton extends Button {
    public PlayAgainButton(Cyberman cyberman, Coordinate2D initialLocation){
        super(cyberman, initialLocation);
        setText("Play Again");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        cyberman.setActiveScene(1);
    }
}
