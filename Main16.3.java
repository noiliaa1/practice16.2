import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Config.load();  // Зчитуємо налаштування при старті
        while (true) {
            System.out.println("\n--- Хрестики-Нулики ---");
            System.out.println("1. Грати");
            System.out.println("2. Налаштування");
            System.out.println("3. Переглянути статистику");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Game.playGame(scanner);
            } else if (choice == 2) {
                Config.update(scanner);
            } else if (choice == 3) {
                Stats.show();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Невірний вибір.");
            }
        }
    }
}