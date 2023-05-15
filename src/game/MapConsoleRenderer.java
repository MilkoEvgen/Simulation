package game;

import java.awt.*;

public class MapConsoleRenderer {

    public static void render(GameMap map) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n\n");
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Point point = new Point(j, i);
                if (map.isPointHaveEntity(point)) {
                    System.out.print(map.getEntityByPoint(point).getSprite() + " ");
                } else {
                    System.out.print("\uD83D\uDFEB" + " ");

                }
            }
            System.out.println();
        }
    }
}
