import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {

//        initially we have k = n and l = 1. To solve a (k, l)-subproblem, we do the following. If
//        k ≤ 2l, we output just one summand k. Otherwise we output l and then solve the subproblem (k−l, l+ 1).
        int k = n;
        int l = 1;

        List<Integer> summands = new ArrayList<>();

        while (k > 0) {

//            System.out.printf("k = %d l = %d\n", k, l);

            if (k <= 2 * l) {
                summands.add(k);
                k -= k;
            } else {
                summands.add(l);
                k -= l;
                l += 1;
            }

        }

        return summands;
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);

        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

