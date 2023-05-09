package game;

import entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameMap {
    public int width;
    public int height;
    private boolean isMapChanged = true;
    private final HashMap<Point, Entity> entities = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isMapChanged() {
        return isMapChanged;
    }

    public void setMapChanged(boolean mapChanged) {
        isMapChanged = mapChanged;
    }

    public int getMapSize(){
        return width* height;
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

    public ArrayList<Creature> getCreaturesList() {
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Point point : entities.keySet()) {
            if ((entities.get(point) instanceof Herbivore) || (entities.get(point) instanceof Predator)) {
                creatures.add((Creature) entities.get(point));
            }
        }
        return creatures;
    }

    public <T extends Entity> Set<Point> getCreaturePoints(Class<T> objectClass) {
        Set<Point> points = new HashSet<>();
        for (Point point : entities.keySet()) {
            if (objectClass.isInstance(entities.get(point))) {
                points.add(point);
            }
        }
        return points;
    }

}
