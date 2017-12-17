import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
        int numberOfOperations = (exp.length() - 1)/2;
        char[] ops = new char[numberOfOperations];
        long[] nums = new long[numberOfOperations + 1];
        long[][] m = new long[numberOfOperations + 1][numberOfOperations + 1];
        long[][] M = new long[numberOfOperations + 1][numberOfOperations + 1];

        int opIdx = 0;
        int numIdx = 0;
        for(int i = 0; i < exp.length(); i++) {
            if(i % 2 != 0) {
                ops[opIdx++] = exp.charAt(i);
            } else {
                nums[numIdx++] = Character.getNumericValue(exp.charAt(i));
            }
        }

        // for(int i = 0; i<ops.length; i++) {
        //     System.out.print(ops[i] + " ");
        // }

        // System.out.println("");

        // for(int i = 0; i<nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println("");

        for(int s = 0; s < nums.length; s++) { // populate diagonals with respective values
            m[s][s] = nums[s];
            M[s][s] = nums[s];
        }

        for(int s = 1; s < nums.length; s++) {
            for(int l = 0; l < nums.length - s; l++) {
                int j = l + s;
                long[] mm = MinAndMax(l, j, m, M, ops);
                m[l][j] = mm[0];
                M[l][j] = mm[1];
            }
        }

        // System.out.println("Min");
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j< nums.length; j++) {
        //         System.out.print(m[j][i] + " ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("Max");
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j< nums.length; j++) {
        //         System.out.print(M[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        return M[0][numberOfOperations];
    }

    private static long[] MinAndMax(int i ,int j, long[][] min, long[][] max, char[] ops) {
        long[] minMax = new long[2];
        minMax[0] = Long.MAX_VALUE;
        minMax[1] = Long.MIN_VALUE;

        for(int k = i; k < j; k++) {
            long a = eval(min[i][k], min[k+1][j], ops[k]);
            long b = eval(max[i][k], max[k+1][j], ops[k]);
            long c = eval(max[i][k], min[k+1][j], ops[k]);
            long d = eval(min[i][k], max[k+1][j], ops[k]);

            minMax[0] = Math.min(minMax[0], findMin(a,b,c,d));
            minMax[1] = Math.max(minMax[1], findMax(a,b,c,d));
        }

        return minMax;
    }

    private static long findMin(long a, long b, long c, long d) {
        long min = Math.min(a, b);
        min = Math.min(min, c);
        min = Math.min(min, d);

        return min;
    }

    private static long findMax(long a, long b, long c, long d) {
        long max = Math.max(a, b);
        max = Math.max(max, c);
        max = Math.max(max, d);

        return max;
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

