package game;

import java.awt.*;

public class MapConsoleRenderer {

    public void render (GameMap map){
        System.out.println("\n\n\n\n");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                if (map.checkEntity(new Point(j, i)) && map.getEntity(new Point(j, i)).isAlive()){
                    map.getEntity(new Point(j, i)).printEntity();
                } else {
                    System.out.print("\uD83D\uDFEB");
                }
            }
            System.out.println();
        }
    }
}
