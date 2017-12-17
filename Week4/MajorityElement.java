import java.util.*;
import java.io.*;

public class MajorityElement {

    // Use HashMap
    // http://www.tutorialspoint.com/java/java_hashmap_class.htm
    private static boolean getMajorityElement(Integer[] a) {

        HashMap hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {

            Integer key = a[i];

            if (hm.containsKey(key)) {
                Integer addMe = (Integer)hm.get(key);
                hm.put(key, addMe + 1);
            } else {
                hm.put(key, 1);
            }
        }

        double majority = Math.ceil(a.length / 2);

        for (Object val : hm.values()) {

            if ((int)val > majority) {
//                System.out.println("Majority Found " + (int)val + " Is >=" + majority);
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        Integer n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }


        if (getMajorityElement(a)) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

