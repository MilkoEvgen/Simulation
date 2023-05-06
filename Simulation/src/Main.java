import game.Simulation;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.map.setDefault();
        simulation.mapConsoleRenderer.render(simulation.map);

        simulation.nextTurn();
        simulation.mapConsoleRenderer.render(simulation.map);

    }
}