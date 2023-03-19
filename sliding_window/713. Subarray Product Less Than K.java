class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <=1)
            return 0;
        
        int i = 0;
		int j = 0;
		int productOfCurrWin = 1;
		int count = 0;
		while(i<nums.length){
			productOfCurrWin*=nums[i];
			while(productOfCurrWin >= k){
				productOfCurrWin /= nums[j];
				j++;
			}
			count += (i-j+1);
			i++;
		}
		return count;
    }
}