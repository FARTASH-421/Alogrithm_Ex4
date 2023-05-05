import java.util.Scanner;

public class MaxPain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] maxPain = new int[m][n];
        int input = in.nextInt();
        maxPain[0][0] = input;


        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                input = in.nextInt();
                if (i == 0) {
                    maxPain[i][j] = maxPain[i][j - 1] + input;
                } else if (i > 0)
                    maxPain[i][j] = Math.max(maxPain[i-1][j] + input,  maxPain[i][j-1] + input);

            }
            if (i + 1 < m) {
                input = in.nextInt();
                maxPain[i + 1][0] = maxPain[i][0] + input;
            }
        }

        System.out.println(maxPain[m - 1][n - 1]);
    }
}
