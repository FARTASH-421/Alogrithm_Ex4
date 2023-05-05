import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Apply {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        List<Integer>[] graph = new List[n+1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int day = input.nextInt() ;
            graph[day].add(input.nextInt());
            Collections.sort(graph[day]);
        }
        for (int i = 1; i <= n; i++) {

            for (Integer x : graph[i]) {
                System.out.print(x +" ");
            }
            System.out.println("");
        }
    }
}
