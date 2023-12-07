import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        String a, b;
        boolean wordSearch = true;

        System.out.print("Please input a phrase: ");
        a = inputUser.nextLine();

        System.out.print("Enter the word to search: ");
        b = inputUser.next();

        if (a.indexOf(b) == -1) {
            wordSearch = false;
        }

        System.out.println("Is there a word [" + b + "] in the phrase? " + wordSearch);
    }
}
