class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum=0;
        int doubleDigitSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<10){
                singleDigitSum+=nums[i];
            }
            else{
                doubleDigitSum+=nums[i];
            }
        }
        System.out.println(singleDigitSum);
        System.out.println(doubleDigitSum);
        
        if(singleDigitSum==doubleDigitSum){
            return false;
        }
        return true;
    }
}