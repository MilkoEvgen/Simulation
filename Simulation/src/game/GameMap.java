package game;

import entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameMap {
    HashMap<Point, Entity> entities = new HashMap<>();

    public void setEntity(Point point, Entity entity) {
        entity.point = point;
        entities.put(point, entity);
    }

    public Entity getEntity(Point point){
        return entities.get(point);
    }

    public HashMap<Point, Entity> getEntities(){
        return entities;
    }

    public void moveEntity(Point point, Entity entity){
        entities.remove(entity.point);
        setEntity(point, entity);
    }

    public void removeEntity (Point point){
        entities.remove(point);
    }

    public boolean checkEntity(Point point){
        return entities.containsKey(point);
    }

    public ArrayList<Predator> returnPredators() {
        ArrayList<Predator> predators = new ArrayList<>();
        for (Point point : entities.keySet()) {
            if (entities.get(point) instanceof Predator) {
                predators.add((Predator) entities.get(point));
            }
        }
        return predators;
    }

    public ArrayList<Herbivore> returnHerbivores() {
        ArrayList<Herbivore> herbivores = new ArrayList<>();
        for (Point point : entities.keySet()) {
            if (entities.get(point) instanceof Herbivore) {
                herbivores.add((Herbivore) entities.get(point));
            }
        }
        return herbivores;
    }

    public Set<Point> getHerbivorePoints() {
        Set<Point> points = new HashSet<>();
        for (Point point : entities.keySet()) {
            if (entities.get(point) instanceof Herbivore) {
                points.add(point);
            }
        }
        return points;
    }

    public Set<Point> getGrassPoints() {
        Set<Point> points = new HashSet<>();
        for (Point point : entities.keySet()) {
            if (entities.get(point) instanceof Grass) {
                points.add(point);
            }
        }
        return points;
    }

    public void setDefault() {
        entities.put(new Point(1, 2), new Predator(new Point(1, 2)));
        entities.put(new Point(2, 10), new Predator(new Point(2, 10)));
        entities.put(new Point(1, 3), new Herbivore(new Point(1, 3)));
        entities.put(new Point(2, 4), new Rock(new Point(2, 4)));
        entities.put(new Point(15, 3), new Rock(new Point(15, 3)));
        entities.put(new Point(10, 8), new Rock(new Point(10, 8)));
        entities.put(new Point(0, 12), new Rock(new Point(0, 12)));
        entities.put(new Point(5, 10), new Rock(new Point(5, 10)));

        entities.put(new Point(3, 15), new Rock(new Point(3, 15)));
        entities.put(new Point(1, 6), new Rock(new Point(1, 6)));
        entities.put(new Point(3, 7), new Rock(new Point(3, 7)));
        entities.put(new Point(10, 12), new Rock(new Point(10, 12)));
        entities.put(new Point(15, 8), new Rock(new Point(15, 8)));
        entities.put(new Point(16, 5), new Rock(new Point(16, 5)));

        entities.put(new Point(17, 4), new Grass(new Point(17, 4)));
        entities.put(new Point(2, 2), new Grass(new Point(2, 2)));
        entities.put(new Point(4, 8), new Grass(new Point(4, 8)));
        entities.put(new Point(12, 5), new Grass(new Point(12, 5)));
        entities.put(new Point(10, 14), new Grass(new Point(10, 14)));
        entities.put(new Point(7, 1), new Tree(new Point(7, 1)));
        entities.put(new Point(7, 2), new Tree(new Point(7, 2)));
        entities.put(new Point(8, 3), new Tree(new Point(8, 3)));
        entities.put(new Point(8, 8), new Tree(new Point(8, 8)));
        entities.put(new Point(9, 9), new Tree(new Point(9, 9)));

        entities.put(new Point(5, 13), new Tree(new Point(5, 13)));
        entities.put(new Point(6, 14), new Tree(new Point(6, 14)));
        entities.put(new Point(14, 10), new Tree(new Point(14, 10)));
        entities.put(new Point(15, 11), new Tree(new Point(15, 11)));
        entities.put(new Point(12, 12), new Tree(new Point(12, 12)));

        entities.put(new Point(5, 1), new Tree(new Point(5, 1)));
        entities.put(new Point(16, 0), new Tree(new Point(16, 0)));
        entities.put(new Point(16, 2), new Tree(new Point(16, 2)));

        entities.put(new Point(14, 13), new Herbivore(new Point(14, 13)));
        entities.put(new Point(18, 4), new Herbivore(new Point(18, 4)));
    }
}
