/**
 * @param {number[]} nums
 * @return {number}
 */
var findNonMinOrMax = function(nums) {
    if(nums.length==1||nums.length==2){
        return -1;
    }
    nums=nums.sort(function(a,b){
        return a-b;
    });
    
    return nums[1];
};