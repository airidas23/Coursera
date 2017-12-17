import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0;

        for (int i = 0; i < a.length; i++) {
            result += (long)a[i] * b[b.length - i -1];
//            System.out.printf("a = %d b = %d\n", a[i], b[b.length - i -1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get N - number of items in array
        int n = scanner.nextInt();

        // Get array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Get array b
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(minDotProduct(a, b));
    }
}

