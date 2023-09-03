package Seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в произвольном порядке, разделенные пробелом:");
        String input = scanner.nextLine();

        String[] inputData = input.split(" ");

        // Проверка количества данных
        if (inputData.length != 6) {
            System.err.println("Ошибка: Неверное количество данных. Введите Фамилия Имя Отчество ДатаРождения НомерТелефона Пол.");
            return;
        }

        String lastName = inputData[0];
        String firstName = inputData[1];
        String middleName = inputData[2];
        String birthDateStr = inputData[3];
        String phoneNumberStr = inputData[4];
        String genderStr = inputData[5];

        try {
            // Парсинг даты
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate = dateFormat.parse(birthDateStr);

            // Парсинг номера телефона
            long phoneNumber = Long.parseLong(phoneNumberStr);

            // Проверка пола
            if (!genderStr.equals("m") && !genderStr.equals("f")) {
                System.err.println("Ошибка: Неверное значение пола. Используйте 'm' или 'f'.");
                return;
            }

            // Создание строки для записи в файл
            String dataToWrite = lastName + firstName + middleName + birthDateStr + " " + phoneNumber + genderStr;

            // Создание или открытие файла для записи
            FileWriter fileWriter = new FileWriter(lastName + ".txt");
            fileWriter.write(dataToWrite + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл " + lastName + ".txt");

        } catch (ParseException e) {
            System.err.println("Ошибка: Неверный формат даты рождения. Используйте формат dd.MM.yyyy.");
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат номера телефона. Используйте целое беззнаковое число без форматирования.");
        } catch (IOException e) {
            System.err.println("Ошибка: при записи данных в файл: " + e.getMessage());
        }
    }
}

