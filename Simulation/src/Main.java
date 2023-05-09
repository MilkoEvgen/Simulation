import game.GameMenu;
import game.Simulation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        loop:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Начать новую симуляцию?(1 - да/0 - нет)");
            switch (scanner.nextLine()) {
                case ("1"):
                    System.out.println("Введите размеры карты через пробел (ширина высота):");
                    try {
                        String [] size = scanner.nextLine().split(" ");
                        int x = Integer.parseInt(size[0]);
                        int y = Integer.parseInt(size[1]);
                        Simulation simulation = new Simulation(x, y);
                        simulation.initActions();
                        GameMenu menu = new GameMenu(simulation);
                        menu.SimulationMenu(scanner);
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                        System.out.println("\u001B[31m" + "Введите 2 числа через пробел!" + "\u001B[0m");
                    }
                    break;
                case ("0"):
                    scanner.close();
                    break loop;
                default:
                    System.out.println("\u001B[31m" + "Неправильный ввод!" + "\u001B[0m");
                    break;
            }
        }
    }
}