package game;

import java.util.Scanner;

public class GameMenu {
    Simulation simulation;

    public GameMenu(Simulation simulation) {
        this.simulation = simulation;
    }

    public void printMenu(){
        System.out.println("Выберите действие:");
        System.out.println("1) Запустить цикл симуляции");
        System.out.println("2) Сделать ход всеми существами");
        System.out.println("3) Завершить симуляцию");
    }

    public void SimulationMenu(Scanner scanner) {
        loop:
        while (true) {
            printMenu();
            switch (scanner.nextLine()) {
                case ("1"):
                    simulation.startSimulation();
                    break loop;
                case ("2"):
                    if (simulation.makeOneMoveAllCreatures()){
                        break;
                    } else {
                        break loop;
                    }
                case ("3"):
                    break loop;
                default:
                    System.out.println("\u001B[31m" + "Неправильный ввод!" + "\u001B[0m");
                    break;
            }
        }
    }
}
