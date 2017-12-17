import java.util.*;

public class FibonacciLastDigit {

    private static int getFibonacciLastDigit(int n) {

        int fibLastDig[] = new int[n + 1];

        fibLastDig[0] = 0;
        fibLastDig[1] = 1;

        for (int i = 2; i <= n; i++){

            fibLastDig[i] = (fibLastDig[i -1] + fibLastDig[i -2]) % 10;

        }

        return fibLastDig[n];

    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);

    }
}

