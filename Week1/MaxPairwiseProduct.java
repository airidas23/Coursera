import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * numbers[j] > result) {
                    result = (long)numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        int maxIndex1 = -1;
        int maxIndex2 = -1;

        for(int i = 0; i < n; i++) {
            if(maxIndex1 == -1 || numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }

        for(int i = 0; i< n; i++) {
            if((maxIndex1 != i) && ((maxIndex2 == -1) || (numbers[i] > numbers[maxIndex2]))) {
                maxIndex2 = i;
            }
        }

        return (long)numbers[maxIndex1] * numbers[maxIndex2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
        
        // Stress Testing....
        /*
        while(true) {
            int min = 2;
            int max = 11;
            int n = ThreadLocalRandom.current().nextInt(min, max + 1);

            int[] numberArr = new int[n];
            for(int i = 0; i < n; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
                numberArr[i] = randomNumber;
            }
            long result1 = getMaxPairwiseProduct(numberArr);
            long result2 = getMaxPairwiseProductFast(numberArr);
            if(result1 != result2) {
                for(int i = 0; i < n; i++) {
                    System.out.print(numberArr[i] + " ");
                }
                System.out.print("\n");
                System.out.println("Results not equal: " + result1 + " vs "+ result2);
                break;
            } else {
                System.out.println("OK!");
            }
        }
        */

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