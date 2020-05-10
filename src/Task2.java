//Создать программу, которая будет вычислять и выводить на экран НОК
//(наименьшее общее кратное) и НОД (наибольший общий делитель) двух целых чисел,
//введенных пользователем.
//Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.


import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Boolean notOK = true;
        Scanner in = new Scanner(System.in);
        do {
            try {
                System.out.print("Введите первое число: ");
                int a = in.nextInt();
                System.out.print("Введите второе число: ");
                int b = in.nextInt();
                System.out.println("Для чисел " + a + " и " + b + " НОД = " + gcd(a, b) + " НОК = " + a * b / gcd(a, b));
                notOK = false;
            } catch (Exception e) {
                System.out.println("Введённые данные не являются целым числом");
                in.nextLine();
            }
        } while (notOK);
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

}