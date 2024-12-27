import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms for the Fibonacci series: ");
        int terms = sc.nextInt();

        int a = 0, b = 1, next;
        System.out.print("Fibonacci Series: " + a + ", " + b);

        for (int i = 2; i < terms; i++) {
            next = a + b;
            System.out.print(", " + next);
            a = b;
            b = next;
        }

        sc.close();
    }
}
