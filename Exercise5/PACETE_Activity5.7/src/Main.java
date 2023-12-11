import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        Double a, b;
        Double area;

        System.out.println("Area of a Rectangle!!");
        System.out.print("Please input the height of the rectangle: ");
        a = inputUser.nextDouble();

        System.out.print("Please inpust the width of the rectangle: ");
        b = inputUser.nextDouble();

        area = a*b;
        System.out.println("The area of the rectangle is " + area);
    }
}
