import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        String userName;
        System.out.print("Please Input your name [Last First Middle Name]: ");
        userName = inputUser.nextLine();

        int space1 = userName.indexOf(" ");
        int space2 = userName.indexOf(" ", space1 + 1);

        String lastNameI = userName.substring(0,1);
        String FirstNameI = userName.substring(space1 + 1, space1 + 2);
        String MiddleNameI = userName.substring(space2 + 1, space2 + 2);

        System.out.println("Good day " + userName + "\n " +
                "Your name initials are as follows " + lastNameI + FirstNameI + MiddleNameI);
    }
}