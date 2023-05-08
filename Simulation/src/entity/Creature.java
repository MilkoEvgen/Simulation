package entity;

import game.GameMap;
import game.Simulation;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Creature extends Entity {
    int speed;
    int hp;


    public Creature(Point point, GameMap map) {
        super(point, map);
    }

    public int getSpeed(){
        return speed;
    }

    public void makeMove(Simulation simulation) {
        Set<Point> points = this.getTargetPoints();
        List<Point> closestPath = getClosestPath(points, map);
        if (closestPath.size() == 1) {
            attack(closestPath.get(0));
        } else {
            for (int i = 0; i < getSpeed(); i++) {
                if (i == closestPath.size() - 1) {
                    attack(closestPath.get(i));
                    simulation.mapConsoleRenderer.render(map);
                    break;
                } else {
                    map.moveEntity(closestPath.get(i), this);
                }
                simulation.mapConsoleRenderer.render(map);
            }
        }
    }

    public abstract Set<Point> getTargetPoints();

    protected abstract void attack(Point targetPoint);

    public ArrayList<Point> getClosestPath(Set<Point> points, GameMap map) {
        Queue<Point> pointQueue = new LinkedList<>();
        HashMap<Point, Point> previous = new HashMap<>();
        HashSet<Point> visited = new HashSet<>();
        ArrayList<Point> path = new ArrayList<>();

        pointQueue.add(point);
        visited.add(point);

        while (!pointQueue.isEmpty()) {
            Point current = pointQueue.poll();
            if (points.contains(current)) {
                while (current != this.point) {
                    path.add(current);
                    current = previous.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (Point neighbor : getNeighbors(current, map, points)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    pointQueue.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }
        return path;
    }

    private List<Point> getNeighbors(Point point, GameMap map, Set<Point> points) {
        Set<Point> obstacles = map.getEntitiesMap().keySet().stream().
                filter(entity -> !(points.contains(entity))).collect(Collectors.toSet());

        List<Point> neighbors = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : dirs) {
            Point neighbour = new Point(point.x + dir[0], point.y + dir[1]);
            if (!obstacles.contains(neighbour) && neighbour.x >= 0 && neighbour.x <= map.width &&
                    neighbour.y >= 0 && neighbour.y <= map.height) {
                neighbors.add(neighbour);
            }
        }
        return neighbors;
    }

}
