import java.io.*;
import java.time.LocalDateTime;

public class Stats {
    public static void save(String winner, int size) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("stats.txt", true));
            pw.println("Дата: " + LocalDateTime.now());
            pw.println("Гравець: " + Config.player1 + " vs " + Config.player2);
            pw.println("Переможець: " + winner);
            pw.println("Розмір поля: " + size);
            pw.println("---");
            pw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження статистики.");
        }
    }

    public static void show() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("stats.txt"));
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (IOException e) {
            System.out.println("Статистика ще не створена.");
        }
    }
}