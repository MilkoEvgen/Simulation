import game.Simulation;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.map.setDefault();
        while (true) {
            simulation.nextTurn();
        }


    }
}