//package nl.hanyeager.sander.entities.spawners;
//
//import com.github.hanyaeger.api.Coordinate2D;
//import com.github.hanyaeger.api.entities.EntitySpawner;
//import nl.hanyeager.sander.entities.coins.Coin;
//
//import java.util.Random;
//
//public class CoinSpawner extends EntitySpawner {
//    private final double sceneWidth;
//    private final double sceneHeight;
//
//    public CoinSpawner(double sceneWidth, double sceneHeight) {
//        super(1000);
//        this.sceneWidth = sceneWidth;
//        this.sceneHeight = sceneHeight;
//    }
//
//    @Override
//    protected void spawnEntities() {
//        spawn(new Coin(randomLocation(), 2));
//    }
//
//    private Coordinate2D randomLocation() {
//        double x = new Random().nextInt((int) sceneWidth);
//        return new Coordinate2D(x, sceneHeight);
//    }
//}
