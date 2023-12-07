
import java.util.Date;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat a, b;
        a = new SimpleDateFormat("yyyy/MMMMM/dd HH;mm;ss");
        System.out.println("Good day!");
        System.out.println("The date today is " + a.format(date));
    }
}
