class Solution {
    private final int MOD=1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] result=new int[(n*(n+1))/2];
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=(sum+nums[j])%MOD;
                result[k++]=sum;
            }
        }
        Arrays.sort(result);
        int finalSum=0;
        for(int i=left-1;i<right;i++){
            finalSum=(finalSum+result[i])%MOD;
        }
        return finalSum;
    }
}