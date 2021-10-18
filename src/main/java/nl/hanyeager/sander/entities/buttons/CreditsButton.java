package nl.hanyeager.sander.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import nl.hanyeager.sander.Cyberman;

public class CreditsButton extends Button implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    public CreditsButton(Cyberman cyberman, Coordinate2D initialLocation){
        super(cyberman, initialLocation);
        setText("Credits");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        cyberman.setActiveScene(3);
    }
}
