import actions.GrassSpawnAction;
import game.Simulation;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation(20, 15);
        simulation.startSimulation();
        simulation.mapConsoleRenderer.render(simulation.map);


        while (true) {
            simulation.nextTurn();
        }


    }
}