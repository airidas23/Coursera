import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {

        int[][][] subseq = new int[a.length + 1][b.length + 1][c.length + 1];

        // Set initial planes to 0. For common subsequence of 2 strings, it will be just setting the x & y axis to 0.
        for(int i = 0; i <= a.length; i++) {
            for(int j = 0; j<= b.length; j++) {
                subseq[i][j][0] = 0;
            }
        }
        for(int i = 0; i <= a.length; i++) {
            for(int j = 0; j<= c.length; j++) {
                subseq[i][0][j] = 0;
            }
        }
        for(int i = 0; i <= b.length; i++) {
            for(int j = 0; j<= c.length; j++) {
                subseq[0][i][j] = 0;
            }
        }

        // Dynamic programming to fill up 3D array.
        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                for(int k = 1; k <= c.length; k++) {
                    int match = subseq[i-1][j-1][k-1] + 1;
                    int mismatch = subseq[i-1][j-1][k-1]; // No need to consider extra mismatch or substitution possibilities. As it does not influence subsequent path calculations (This applies regardless of no. of sequence comparisons)
                    // More insertions and deletion possibilities to consider for 3 sequences vs 2 sequences.
                    int insertBC = subseq[i-1][j][k];
                    int insertAC = subseq[i][j-1][k];
                    int insertAB = subseq[i][j][k-1];
                    // No need to consider 2 string insertions or deletes as well. May need if extending for edit distance problem?
                    // int insertC = subseq[i-1][j-1][k];
                    // int insertB = subseq[i-1][j][k-1];
                    // int insertA = subseq[i][j-1][k-1];

                    int max = Math.max(Math.max(insertAB, insertAC), insertBC);

                    // int max = Math.max(Math.max(Math.max(Math.max(Math.max(insertBC, insertAC), insertAB), insertC), insertB),insertA);

                    if(a[i-1]==b[j-1] && b[j-1] == c[k-1]) { // subseq arr is 1 indexed vs the sequence a,b and c. hence the need to -1.
                        max = Math.max(max, match);
                    } else {
                        max = Math.max(max, mismatch);
                    }
                    subseq[i][j][k] = max;
                }
            }
        }

        return subseq[a.length][b.length][c.length]; // return longest subsequence for full length of a,b,c.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        
        System.out.println(lcs3(a, b, c));
    }
}

