class Solution {
    public int mostFrequentEven(int[] nums) {
        int freq[]=new int[100001];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int maxFreq=0;
        int ans=-1;
        for(int i=0;i<freq.length;i++){
            if(i%2==0&&freq[i]>maxFreq){
                maxFreq=freq[i];
                ans=i;
            }
        }
        return ans;
    }
}