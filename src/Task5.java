//Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы
//        (зеркальное значение равно оригинальному).
//        Длина последовательности N вводится вручную и не должна превышать 100.

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        boolean isPalin = false;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину последовательности N: ");
        int n = in.nextInt();
        System.out.println("Числа-палиндромы в последовательности от 1 до " + n + ":");
        for (int i = 10; i <= n; i++) {
            if (Integer.toString(i).equals(new StringBuilder().append(i).reverse().toString())){
                isPalin = true;
                System.out.println(i);
            }
        }
        if (isPalin == false) {
            System.out.println("В последовательности чисел от 1 до " + n + " нет чисел-палиндромов!");
        }

    }
}
