/**
 * @param {number[]} nums
 * @return {number}
 */
 var findMin = function(nums) {
    let lo=0;
    let hi=nums.length-1;
    if(nums[lo]<=nums[hi]){
        return nums[0];
    }
    while(lo<=hi){
        let mid=Math.floor((lo+hi)/2);
        if(nums[mid]>nums[mid+1]){
            return nums[mid+1];
        }
        else if(nums[mid]<nums[mid-1]){
            return nums[mid];
        }
        else if(nums[lo]<=nums[mid]){
            lo=mid+1;
        }
        else if(nums[mid]<=nums[hi]){
            hi=mid-1;
        }
    }
    return -1;
};