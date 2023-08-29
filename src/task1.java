import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        double number = getDoubleInput("Введите дробное число: ");
        System.out.println("Вы ввели число: " + number);
    }

    public static double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }
    }
}
