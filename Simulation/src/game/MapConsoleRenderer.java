package game;

import java.awt.*;

public class MapConsoleRenderer {
boolean isPaused = false;

    public void render (GameMap map){
        if (!isPaused){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\n\n\n");
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 20; j++) {
                    if (map.checkEntity(new Point(j, i))){
                        map.getEntity(new Point(j, i)).printEntity();
                    } else {
                        System.out.print("\uD83D\uDFEB");
                    }
                }
                System.out.println();
            }
        }

    }
}
