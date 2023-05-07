import game.Simulation;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.map.setDefault();

        try {
            simulation.nextTurn();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}