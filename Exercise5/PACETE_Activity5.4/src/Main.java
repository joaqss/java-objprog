import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        String a, b, c, d;

        System.out.print("Please input first string: ");
        a = inputUser.next();

        System.out.print("Please input second string: ");
        b = inputUser.next();

        System.out.print("Please input third string: ");
        c = inputUser.next();

        System.out.print("Please input fourth string: ");
        d = inputUser.next();

        System.out.println("\nThe concatenated word is " + a.toUpperCase() + b.toUpperCase() +
                c.toUpperCase() + d.toUpperCase());
    }
}