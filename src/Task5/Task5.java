package Task5;
//Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы
//        (зеркальное значение равно оригинальному).
//        Длина последовательности N вводится вручную и не должна превышать 100.

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        boolean isPalin = false;
        int n = 0;
        Scanner in = new Scanner(System.in);
        do {
            try {
                System.out.print("Введите длину последовательности N (не больше 100): ");
                n = in.nextInt();
                if (n > 100 || n < 0)
                    System.out.println("Недопустимое значение N");
            } catch (Exception e) {
                System.out.println("Введённые данные не являются целым числом");
                in.nextLine();
                }
        } while (n > 100 || n < 1);
        System.out.println("Числа-палиндромы в последовательности от 1 до " + n + ":");
        for (int i = 10; i <= n; i++) {
            if (Integer.toString(i).equals(new StringBuilder().append(i).reverse().toString())){
                isPalin = true;
                System.out.println(i);
            }
        }
        if (!isPalin) {
            System.out.println("В последовательности чисел от 1 до " + n + " нет чисел-палиндромов!");
        }

    }
}
