package game;

import entity.*;

import java.awt.*;
import java.util.*;

public class GameMap {
    private int width;
    private int height;
    private boolean isMapChanged = true;
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

    public boolean isMapChanged() {
        return isMapChanged;
    }

    public void setMapChanged(boolean mapChanged) {
        isMapChanged = mapChanged;
    }

    public HashMap<Point, Entity> getEntitiesMap(){
        return entities;
    }

    public void setEntity(Point point, Entity entity) {
        entity.point = point;
        entities.put(point, entity);
    }

    public Entity getEntity(Point point){
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

    public boolean checkEntity(Point point){
        return entities.containsKey(point);
    }

    public <T extends Entity> HashMap<Point, T> getCreaturesByClass(Class<T> objectClass) {
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
