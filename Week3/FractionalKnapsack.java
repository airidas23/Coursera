import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;


        // This is a really ugly solution data structure wise - though the data structure course is next!
        // would have been better off using objects and linked lists
        // First make array with comparable values and sort them
        double[][] compares = new double[values.length][2];
        for (int i = 0; i < compares.length; i++) {
            compares[i][0] = (double)values[i] / weights[i];
            compares[i][1] = i;
        }

        Arrays.sort(compares, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0], o1[0]);
            }
        });


        // then fill the thing up..
        for (int i = 0; i < compares.length; i++){

            if (capacity == 0) {
                break;
            }

            // if we're filling up only take some
            if (capacity <= weights[(int)compares[i][1]]) {
                value += compares[i][0] * capacity;
                break;
            }

            // if we're not filling up...
            value += values[(int)compares[i][1]];
            capacity -= weights[(int)compares[i][1]];

        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter n Number of items and W capacity of bag");
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();


        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
//            System.out.println("Enter $ and weight item " + i);
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.printf("%.4f\n",getOptimalValue(capacity, values, weights));

    }
} 
