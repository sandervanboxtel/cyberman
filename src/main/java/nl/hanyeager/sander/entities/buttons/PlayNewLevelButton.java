package nl.hanyeager.sander.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.hanyeager.sander.Cyberman;

public class PlayNewLevelButton extends Button {
    public PlayNewLevelButton(Cyberman cyberman, Coordinate2D initialLocation){
        super(cyberman, initialLocation);
        setText("Play New Level");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        cyberman.setActiveScene(5);
    }
}
