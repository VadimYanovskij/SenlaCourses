//        Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
//        чётным или нечётным, простым или составным.  Если пользователь введёт не целое число,
//        то сообщать ему об ошибке.

import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите число : ");
            int number = in.nextInt();
            if (number % 2 == 0) {
                System.out.println("Число " + number + " чётное");
            } else {
                System.out.println("Число " + number + " нечётное");
            }
        } catch (Exception e) {
            System.out.println("Введённые данные не являются целым числом");
        }


    }
}
