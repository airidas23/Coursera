import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int low, int high, int key) {

        // You've reached the end of the array and not found the key; return -1
        if (high < low) {
            return -1;
        }

        // Find the midpoint
        int mid = low + (high - low) / 2;

        // Compare the midpoint to the key, and then do recursion if necessary
        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearch(a, low, mid - 1, key);
        } else {
            return binarySearch(a, mid + 1, high, key);
        }

    }

    static int linearSearch(int[] a, int x) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;

    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }

        // Fixing test case for speed
//        int n = 5;
//        int[] a = {1, 5, 8, 12, 13};
//        int m = 5;
//        int[] b = {8, 1, 23, 1, 11};
//
//        System.out.println("\nYou wanted\n2 0 -1 0 -1");

        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, 0, n - 1, b[i]) + " ");
        }


    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
