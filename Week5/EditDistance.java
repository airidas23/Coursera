import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int sLength = s.length();
    int tLength = t.length();
    int[][] ed = new int[sLength + 1][tLength + 1];

    for(int i = 0; i < sLength + 1; i++) { // initialize first row - comparing against empty string what is the number of operations to convert string s to an empty string? it will be i.
      ed[i][0] = i;
    }

    for(int i = 0; i < tLength + 1; i++) { // initialize first col - same rationale as above
      ed[0][i] = i;
    }

    for(int i = 1; i < sLength + 1; i++) { // start filling matrix
      for(int j = 1; j < tLength + 1; j++) {
        // for string up to of i and 2nd string up to j, you can get there by insertion/deletion/match/mismatch
        int insertion = ed[i-1][j] + 1; 
        int deletion = ed[i][j-1] + 1;
        int match = ed[i-1][j-1]; // no need to add 1 as if character i and j are the same, no operation is required
        int misMatch = ed[i-1][j-1] + 1;
        int min = Math.min(insertion, deletion);

        if(s.charAt(i-1) == t.charAt(j-1)) { // check if character i and j are the same. Using i-1 and j-1 as matrix is 1 indexed vs charAt which is 0 index
          ed[i][j] = Math.min(min, match);
        } else {
          ed[i][j] = Math.min(min, misMatch);
        }
      }
    }

    return ed[sLength][tLength]; // return min edit distance for 2 strings
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
