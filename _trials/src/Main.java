import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.print("Enter first name: ");
        Scanner input = new Scanner(System.in);
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.println(firstName + " " + lastName);

    }
}