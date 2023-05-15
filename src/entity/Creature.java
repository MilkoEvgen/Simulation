package entity;

import game.GameMap;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Creature extends Entity {
    int speed;
    int hp;
    boolean isAlive;
    int attackPower;


    public Creature(Point point, GameMap map) {
        super(point, map);
        isAlive = true;
    }

    public int getSpeed() {
        return speed;
    }

    public void makeMove() {
        Set<Point> points = map.getEntitiesByClass(this.getTargetType()).keySet();
        if (isAlive && points.size() > 0) {
            List<Point> closestPath = getClosestPath(points, map);
            if (closestPath.size() > 0) {
                map.setMapChanged(true);
                if (closestPath.size() == 1) {
                    attack(closestPath.get(0), attackPower);
                } else {
                    for (int i = 0; i < getSpeed(); i++) {
                        if (i < closestPath.size() - 1) {
                            map.moveEntity(closestPath.get(i), this);
                        } else {
                            int powerAttack;
                            if ((attackPower - i) > 0){
                                powerAttack = attackPower - i;
                            } else powerAttack = 0;
                            attack(closestPath.get(i), powerAttack);
                            break;
                        }
                    }
                }
            }
        }
    }

    protected abstract Class<? extends Entity> getTargetType();

    protected abstract void attack(Point targetPoint, int attackPower);

    private ArrayList<Point> getClosestPath(Set<Point> points, GameMap map) {
        Queue<ArrayList<Point>> listQueue = new LinkedList<>();
        HashSet<Point> visited = new HashSet<>();
        ArrayList<Point> path = new ArrayList<>();

        path.add(point);
        listQueue.add(path);
        visited.add(point);

        while (!listQueue.isEmpty()) {
            ArrayList<Point> currentPath = listQueue.poll();
            Point currentPoint = currentPath.get(currentPath.size() - 1);
            if (points.contains(currentPoint)) {
                currentPath.remove(0);
                return currentPath;
            }
            for (Point neighbor : getNeighbours(currentPoint, map, points)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    ArrayList<Point> newPath = (ArrayList<Point>) currentPath.clone();
                    newPath.add(neighbor);
                    listQueue.add(newPath);
                }
            }
        }
        path.remove(0);
        return path;
    }

    private List<Point> getNeighbours(Point point, GameMap map, Set<Point> points) {
        Set<Point> obstacles = map.getEntitiesByClass(Entity.class).keySet().stream().
                filter(entity -> !(points.contains(entity))).collect(Collectors.toSet());

        List<Point> neighbours = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : dirs) {
            Point neighbour = new Point(point.x + dir[0], point.y + dir[1]);
            if (!obstacles.contains(neighbour) && neighbour.x >= 0 && neighbour.x < map.getWidth() &&
                    neighbour.y >= 0 && neighbour.y < map.getHeight()) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

}
