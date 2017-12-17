import java.util.*;

public class FibonacciHuge {

    private static long getFibonacciHuge(long n, int m) {

        ArrayList<Integer> fibs= new ArrayList<>();
        ArrayList<Integer> mods = new ArrayList<>();

        // Nothing to do if n = 0
        if (n == 0){
            return 0;
        }

        // Set up index 0 & 1
        mods.add(0, 0);
        mods.add(1, 1);
        fibs.add(0, 0);
        fibs.add(1, 1);
        //System.out.printf("%d, %d, ", mods.get(0), mods.get(1));

        for (int i = 2; true; i++){
            fibs.add(i, mods.get(i - 1) + mods.get(i - 2));
            mods.add(i, fibs.get(i) % m);
            //System.out.printf("%d, ", mods.get(i));

            // check if pattern repeats 0, 1
            if (mods.get(i - 1) == 0 && mods.get(i) == 1){
                mods.remove(i);
                mods.remove(i -1);
                break;
            }
        }

        //System.out.println("PISANO PERIOD LENGTH " + mods.size());
        int remainder = (int) (n % mods.size());
        return fibs.get(remainder) % m;

    }


    // Examples calculated Pisano numbers:
    // http://willnicholes.com/math/pisano.htm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();

        System.out.println(getFibonacciHuge(n, m));
    }
}

