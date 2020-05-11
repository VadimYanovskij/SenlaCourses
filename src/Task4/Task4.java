package Task4;
//Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
//        Текст и слово вводится вручную.


import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int count = 0;
        System.out.print("Введите предложение: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] wordsArray = str.toLowerCase().replaceAll("[,.!:?]", "").split("\\s");
        System.out.print("Введите слово для поиска: ");
        String word = in.next().trim().toLowerCase();
        for (int i = 0; i <= wordsArray.length-1; i++) {
            if (wordsArray[i].equals(word)) {
                count++;
            }
        }
        System.out.print("Слово " + "\"" + word + "\"" + " встречается в предложении " + count + " раз.");
    }
}
