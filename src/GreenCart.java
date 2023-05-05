import java.util.Scanner;

public class GreenCart {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char [] presenter = in.nextLine().toCharArray();
        char [] participant = in.nextLine().toCharArray();
        String boundStr = in.nextLine();
//        dispaly(presenter);
//        dispaly(participant);
        findLCS(participant,presenter);
        System.out.println(boundStr);
    }
    public static String [][] findLCS(char[] pre,char[] part){
        int n = pre.length;
        int m = part.length;
        String [][] route = new String[m][n];
        int [][] cost = new int[m][n];

        for (int i = 0; i < m; i++)
            cost[i][0] = 0;
        for (int i = 0; i < n; i++)
            cost[0][i] = 0;

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                System.out.print("<"+part[i]+","+pre[j]+"> ");
                if(part[i]== pre[j]) {
                    cost[i][j] = 1 + cost[i-1][j - 1];
                    route[i][j] = "RD";
                }else if(cost[i-1][j]> cost[i][j-1]){
                    cost[i][j] = cost[i-1][j];
                    route[i][j] = "D";
                }else{
                    cost[i][j] = cost[i][j-1];
                    route[i][j] = "R";
                }
            }
            System.out.println();
        }
        dispaly(cost);
        return route;
    }
    private static void dispaly(int[] []arr){
        for(int[] x: arr) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
