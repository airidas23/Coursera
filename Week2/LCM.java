import java.util.Scanner;

public class LCM {


    private static long lcm(long a, long b) {

        // Equation: LCM(a, b) = (a · b) / GCD(a, b)
        return (a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
