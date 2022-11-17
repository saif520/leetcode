/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
 var minSubArrayLen = function(target, nums) {
    let n=nums.length;
    let sum=0;
    let left=0;
    let right=0;
    let shortest=Infinity;
    while(right<n){
        sum+=nums[right];
        if(sum>=target){
            while(sum>=target){
                sum-=nums[left];
                left++;
            }
            shortest=Math.min(shortest,right-left+2);
        }
        right++;
    }
    return shortest==Infinity?0:shortest;
};