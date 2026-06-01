//Q1. print all subsequence whose sum is equal to given sum
import java.util.ArrayList;

public class Main {

    public static void subSeqSum(int ind, ArrayList<Integer> ds, int s,
                                 int sum, int[] arr, int n) {

        if (ind == n) {
            if (s == sum) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

        // Pick the current element
        ds.add(arr[ind]);
        s += arr[ind];

        subSeqSum(ind + 1, ds, s, sum, arr, n);

        // Backtrack
        s -= arr[ind];
        ds.remove(ds.size() - 1);

        // Not pick the current element
        subSeqSum(ind + 1, ds, s, sum, arr, n);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int n = arr.length;
        int sum = 2;

        ArrayList<Integer> ds = new ArrayList<>();

        subSeqSum(0, ds, 0, sum, arr, n);
    }
}


//Q2. print any subsequence whose sum is equal to given sum
import java.util.ArrayList;

public class Main {

    public static boolean subSeqSum(int ind, ArrayList<Integer> ds, int s,
                                    int sum, int[] arr, int n) {

        if (ind == n) {
            // Condition satisfied
            if (s == sum) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
                return true;
            }

            // Condition not satisfied
            return false;
        }

        // Pick the current element
        ds.add(arr[ind]);
        s += arr[ind];

        if (subSeqSum(ind + 1, ds, s, sum, arr, n)) {
            return true;
        }

        // Backtrack
        s -= arr[ind];
        ds.remove(ds.size() - 1);

        // Not pick the current element
        if (subSeqSum(ind + 1, ds, s, sum, arr, n)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int n = arr.length;
        int sum = 2;

        ArrayList<Integer> ds = new ArrayList<>();

        subSeqSum(0, ds, 0, sum, arr, n);
    }
}

//Q3. count the subsequences with sum=k

public class Main {

    public static int subSeqSum(int ind, int s, int sum, int[] arr, int n) {

        if (ind == n) {
            // Condition satisfied
            if (s == sum) {
                return 1;
            }
            // Condition not satisfied
            return 0;
        }

        // Pick the current element
        s += arr[ind];
        int l = subSeqSum(ind + 1, s, sum, arr, n);

        // Backtrack
        s -= arr[ind];

        // Not pick the current element
        int r = subSeqSum(ind + 1, s, sum, arr, n);

        return l + r;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int n = arr.length;
        int sum = 2;

        System.out.println(subSeqSum(0, 0, sum, arr, n));
    }
}


