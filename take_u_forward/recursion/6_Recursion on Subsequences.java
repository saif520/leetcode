// print all subsequences
import java.util.ArrayList;

public class Main {

    public static void subSeq(int ind, ArrayList<Integer> ds, int[] arr, int n) {

        if (ind == n) {
            for (int it : ds) {
                System.out.print(it + " ");
            }
            if(ds.size()==0){
                System.out.println("{}");
            }
            System.out.println();
            return;
        }

        // Take the current element
        ds.add(arr[ind]);
        subSeq(ind + 1, ds, arr, n);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Do not take the current element
        subSeq(ind + 1, ds, arr, n);
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 2};
        int n = arr.length;

        ArrayList<Integer> ds = new ArrayList<>();

        subSeq(0, ds, arr, n);
    }
}