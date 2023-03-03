class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        double sum=0d, cnt=0;
        for(int i=n/20;i<n-n/20;i++){
            sum=sum+arr[i];
            cnt++;
        }
        return sum/cnt;
    }
}