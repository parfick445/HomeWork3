import java.util.Scanner;

public class HomeWorkThree {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        guessTheNumber();
        guessTheWord();
    }

    private static void guessTheNumber() {
        method();
        repeat();
    }

    public static void method() {
        byte randomNumber = (byte) (Math.random() * 9);
        System.out.println("У вас есть 3 попытки, угадайте число от 0 до 9");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nПопытка " + i);
            if (!scanner.hasNextByte()) {
                i--;
                System.err.println("Вводите числа");
                scanner.nextLine();
                continue;
            }
            byte enterNumber = scanner.nextByte();
            if (i == 3 && enterNumber != randomNumber) System.err.println("Вы проиграли");
            else if (enterNumber == randomNumber) {
                System.out.println("Вы угадали");
                break;
            } else if (enterNumber < randomNumber) System.out.println("Загаданное число больше введенного");
            else System.out.println("Загаданное число меньше введенного");
        }
    }

    private static void repeat() {
        while (true) {
            System.out.println("Повторить игру еще раз?\n 1. еще\n 0. нет");
            byte choice = scanner.nextByte();
            if (choice == 1) method();
            else if (choice == 0) break;
            else System.err.println("не верная операция");
        }
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        int a = (int) (Math.random() * 24);
        String randomWord = words[a];
        System.out.print("Угадайте загаданное слово \n\nСлова: ");
        for (int i = 0; i < words.length; i++) {
            if (i % 5 == 0 && i != 0) System.out.println();
            if (i == words.length - 1) System.out.printf("%s.", words[i]);
            else System.out.printf("%s, ", words[i]);
        }
        System.out.println();
        while (true) {
            String enterWord = scanner.next();
            if (randomWord.equals(enterWord)) {
                System.out.printf("Вы угадали!\nЗагаданное слово: %s", randomWord);
                break;
            } else {
                String grid = "###############";
                for (int i = 0; i < grid.length(); i++) {
                    char oneGrid = grid.charAt(i);
                    if (i < enterWord.length() && i < randomWord.length() && randomWord.charAt(i) == enterWord.charAt(i)) {
                        oneGrid = randomWord.charAt(i);
                    }
                    System.out.print(oneGrid);
                }
                System.out.println();
            }
        }
    }
}