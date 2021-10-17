package nl.hanyeager.sander.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Coin extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    private Size size;
    private Direction direction;

    public Coin(String image, Coordinate2D location, Direction direction, Size size) {
        super(image, location, size);
        setMotion(1, direction);
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

    }
}
