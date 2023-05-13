class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int result=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(nums1[i]<result){
                    result=nums1[i];
                }
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
        }
        if(result==Integer.MAX_VALUE) return -1;
        return result;
        
    }
}