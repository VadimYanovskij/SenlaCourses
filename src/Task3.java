//Создать программу, которая будет:
//        подсчитывать количество слов в предложении
//        выводить их в отсортированном виде
//        делать первую букву каждого слова заглавной.
//        Предложение вводится вручную. (Разделитель пробел (“ ”)).


import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("Введите предложение: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] wordsArray = str.split("[\\s]+");
        System.out.println("Количество слов в предложении: " + wordsArray.length);
        Arrays.sort(wordsArray);
        System.out.print("Отсортированное предложение: ");
        for (int i = 0; i <= wordsArray.length-1; i++) {
            wordsArray[i] = firstUpperCase(wordsArray[i]);
            System.out.print(wordsArray[i] + " ");
        }
    }

    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}