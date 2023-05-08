package actions;

import entity.Entity;
import game.GameMap;

import java.awt.*;
import java.util.Random;

public abstract class SpawnAction<T extends Entity> extends Action {
    protected double rate;

    public SpawnAction(GameMap map) {
        super(map);
    }

    @Override
    public void perform() {
        int currentRate = 0;
        while (currentRate < rate){
            Point point = getEmptyRandomPoint();
            map.setEntity(point, spawnEntity(point));
            currentRate++;
        }
    }

    protected Point getEmptyRandomPoint() {
        Random r = new Random();
        while (true) {
            int x = r.nextInt(map.width);
            int y = r.nextInt(map.height);
            Point point = new Point(x, y);
            if (!map.checkEntity(point)){
                return point;
            }
        }
    }

    protected abstract T spawnEntity(Point point);

}
