import static java.util.Collections.swap;

public class Codility1 {

    public static void main(String[] args) {
        //int[] A = {10, -10, -1, -1, 10};
        int[] A = {-1, 1, -1, -2, 1, -1, 1};
        int n = A.length;
        int st = 0;
        int e = n - 1;
        int k = 0;
        int profit = 0;
        while (st < e) {
            if ((profit + A[st]) < 0) {
                while (profit + A[e] < 0) {
                    e--;
                }

                swap(A, st, e);
                k++;
            }
            profit += A[st++];
        }
        System.out.println(k);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}