package game;

import java.awt.*;

public class MapConsoleRenderer {

    public void render (GameMap map){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                if (!map.entities.containsKey(new Point(j, i))){
                    System.out.print("\uD83D\uDFEB");
                } else {
                    map.entities.get(new Point(j, i)).printEntity();
                }
            }
            System.out.println();
        }
    }
}
