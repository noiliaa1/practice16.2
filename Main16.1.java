import java.io.*;

public class Config {
    public static String player1 = "Гравець 1";
    public static String player2 = "Гравець 2";
    public static int fieldSize = 3;

    public static void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            player1 = br.readLine();
            player2 = br.readLine();
            fieldSize = Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            System.out.println("Налаштування не знайдено, використовуються стандартні.");
        }
    }

    public static void save() {
        try {
            PrintWriter pw = new PrintWriter("config.txt");
            pw.println(player1);
            pw.println(player2);
            pw.println(fieldSize);
            pw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження налаштувань.");
        }
    }

    public static void update(Scanner scanner) {
        System.out.print("Ім’я першого гравця: ");
        player1 = scanner.nextLine();
        System.out.print("Ім’я другого гравця: ");
        player2 = scanner.nextLine();
        System.out.print("Розмір поля (наприклад 3): ");
        fieldSize = scanner.nextInt();
        scanner.nextLine();
        save();
    }
}