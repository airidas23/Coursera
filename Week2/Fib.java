import java.util.Scanner;

public class Fib {


    //F0 = 0, F1 = 1, and Fi = Fi−1 + Fi−2 for i ≥ 2

    private static long calc_fib(int n) {

        if (n == 0){
            return 0;
        }

        int fibs[] = new int[n + 1];

        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++){
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[n];

    }


    public static void main(String args[]) {

      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      System.out.println(calc_fib(n));

    }
}
