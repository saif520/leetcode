class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int n=happiness.length;
        long sum=0;
        int count=0;
        for(int i=n-1;i>=n-k;i--){
            if(happiness[i]-count>=0){
                sum+=happiness[i];
                sum-=count;
                count++;
            }
        }
        return sum;
    }
}