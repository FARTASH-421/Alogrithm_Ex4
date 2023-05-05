import java.util.ArrayList;
import java.util.Scanner;

class NetworkWorld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int[] arr = new int[n];
        int[] result = new int[n];

        int indexL = 0;
        int indexR = 0;
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            arr[i] = input;
            if (left.isEmpty()) {
                left.add(input);
                right.add(input);
                continue;
            }
            if (left.size() < 2) {
                left.add(input);
                indexL++;
                continue;
            }
            if (right.size() < 2) {
                right.add(input);
                indexR++;
                continue;
            } else {
                if (input > right.get(indexR)) {
                    right.add(input);
                    indexR++;
                }
                if (input > left.get(indexL)) {
                    left.add(input);
                    indexL++;
                }


            }
        }
        if (left.size() == right.size()) {
            display(arr,right,left);
        }
        if(left.size() > right.size()){
            display(arr,left);
        }if(left.size() < right.size()){
           display(arr,right);
        }

    }
    private static void display(int arr[],ArrayList<Integer>right, ArrayList<Integer>left){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(check(left,arr[i])) {
                if(check(right,arr[i])) {
                    System.out.print(3);
                    continue;
                }
                else
                    System.out.print(2);
            }if(check(right,arr[i])){
                if(check(left,arr[i]))
                    System.out.print(3);
                else
                    System.out.print(2);
            }


        }
    }
    private static boolean check(ArrayList<Integer> list, int num){
        for(Integer X: list)
            if(X == num)
                return true;
        return false;
    }
    private static void display(int arr[], ArrayList<Integer> list){
        int j = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(list.get(j) == arr[i]) {
                System.out.print(3);
                j++;
            }
            else
                System.out.print(1);
        }
    }
}
