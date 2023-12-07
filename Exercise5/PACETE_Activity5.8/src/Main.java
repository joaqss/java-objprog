import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        Double a, b, c, AC, BC;

        System.out.println("Triangle!!");
        System.out.print("Please input the height of the triangle: ");
        a = inputUser.nextDouble();

        System.out.print("Please input the base of the triangle: ");
        b = inputUser.nextDouble();

        c = Math.sqrt((a*a) + (b*b));
        BC = Math.atan(b/a);
        AC = Math.acos(b/c);

        System.out.println("THe hypotenuse of the triangle (C) is: " + c);
        System.out.println("The angle AC is: " + Math.toDegrees(AC));
        System.out.println("The angle BC is: " + Math.toDegrees(BC));
    }
}
