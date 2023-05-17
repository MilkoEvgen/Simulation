package game;

import entity.*;

import java.awt.*;
import java.util.*;

public class GameMap {
    private final int width;
    private final int height;
    private final HashMap<Point, Entity> entities = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMapSize(){
        return width* height;
    }

    public void setEntity(Point point, Entity entity) {
        entity.point = point;
        entities.put(point, entity);
    }

    public Entity getEntityByPoint(Point point){
        return entities.get(point);
    }

    public void moveEntity(Point newPoint, Entity entity){
        entities.remove(entity.point);
        setEntity(newPoint, entity);
        MapConsoleRenderer.render(this);
    }

    public void removeEntity (Point point){
        entities.remove(point);
    }

    public boolean isPointHaveEntity(Point point){
        return entities.containsKey(point);
    }

    public <T extends Entity> HashMap<Point, T> getEntitiesByClass(Class<T> objectClass) {
        HashMap<Point, T> entityHashMap = new HashMap<>();
        for (Map.Entry <Point, Entity> e : entities.entrySet()) {
            if (objectClass.isInstance(e.getValue())) {
                Map.Entry<Point, T> cellEntry = (Map.Entry<Point, T>) e;
                entityHashMap.put(cellEntry.getKey(), cellEntry.getValue());
            }
        }
        return entityHashMap;
    }
}
