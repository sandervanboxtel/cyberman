package nl.hanyeager.sander.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.hanyeager.sander.Cyberman;
import nl.hanyeager.sander.entities.cybercar.CyberCar;
import nl.hanyeager.sander.entities.text.HealthText;

import java.util.Random;
import java.util.Set;

public class CyberMan extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Newtonian, Collider, Collided {
    private Cyberman cyberman;
    private HealthText healthText;
    private int health = 3;

    public CyberMan(Coordinate2D location, HealthText healthText, Cyberman cyberman){
        super("sprites/cyberman.png", location, new Size(150,80),  1, 1);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        //Add gravity to CyberMan
        setGravityConstant(0.01);
        setFrictionConstant(0.04);
        this.cyberman = cyberman;
        //Set the HealthText
        this.healthText = healthText;
        healthText.setHealthText(health);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.W)){
            setMotion(2,180d);
        } else if(pressedKeys.contains(KeyCode.S)){
            setMotion(2,0d);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setSpeed(0);
        switch(sceneBorder){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().isAssignableFrom(CyberCar.class)) {
            setAnchorLocation(
                    new Coordinate2D(350, new Random().nextInt((int)(getSceneHeight() - getHeight())))
            );

            //Substract the health by 1 each time there is a collision
            health--;
            healthText.setHealthText(health);

            if (health == 0) {
                cyberman.setActiveScene(2);
            }
        }
    }
}
