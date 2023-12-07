import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        // A = Monthly amortization, P = loan amount, n = years of payment
        // x = number of paying period per year, i = interest rate
        double A, P, n, x, i;
        double baseExponent, common;

        // user input
        System.out.println("Loan Calculator");
        System.out.print("Please input loan amount: ");
        P = inputUser.nextDouble();

        System.out.print("Please input payment years: ");
        n = inputUser.nextDouble();

        System.out.print("Please input number of payment per year: ");
        x = inputUser.nextDouble();

        System.out.print("Please input interest rate: ");
        i = inputUser.nextDouble();

        // compute for monthly amortization of a loan
        common = i/x;
        baseExponent = Math.pow(1+common, n*x);
        A = P / ((1/common) - (1 / (common*baseExponent)));

        // result
        System.out.println("The amortization amount is: " + A);
        table(A, P, n, x, i);
    }

    public static void table(double A, double P, double n, double x, double i) {

        int aa, ab, paymentNum, paymentYear;
        paymentNum = 1;
        paymentYear = 1;
        double beginningBalance = P;

        System.out.println("Payment Year\t" + "Payment #\t" + "Beginning Balance\t" + "Amortization\t"
                + "Incurred Interest\t" + "Ending Balance");
        for (aa=1; aa<=n; aa++) {
            for (ab=1; ab<=4; ab++) {
                double incurredInterest = beginningBalance*(i/x);
                double endingBalance = beginningBalance-(A+incurredInterest);

                // avoid negative numbers;
                if (endingBalance <= 0) {
                    endingBalance = 0;
                }

                System.out.println("\t" + Integer.toString(paymentYear) + "\t\t\t\t" + Integer.toString(paymentNum) +
                        "\t\t\t" + String.format("%.3f", beginningBalance) + "\t\t\t" + String.format("%.2f", A) +
                        "\t\t\t" + String.format("%.2f", incurredInterest) + "\t\t\t" + String.format("%.2f", endingBalance));
                paymentNum++;
                beginningBalance = beginningBalance - (A-incurredInterest);
            }

            paymentYear++;

        }

    }
}
