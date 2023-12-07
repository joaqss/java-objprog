import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        String userName;
        System.out.print("Please Input your First Name: ");
        userName = inputUser.next();
        System.out.println("Good day " + userName);
    }
}