class Solution {
    public int minimumCoins(int[] prices) {
        int ans=prices[0];
        for(int i=0;i<prices.length-2;i=i+2){
            if(prices[i+1]<prices[i+2]){
                ans+=prices[i+1];
            }
            else{
                ans+=prices[i+2];
            }
        }
        return ans;
    }
}