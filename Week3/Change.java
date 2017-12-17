import java.util.Scanner;

public class Change {
    private static int getChange(int n) {

        int answer;

        answer = n / 10;
        n = n % 10;
        answer += n / 5;
        n = n % 5;
        answer += n;

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

