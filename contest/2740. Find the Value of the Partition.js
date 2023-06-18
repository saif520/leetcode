/**
 * @param {number[]} nums
 * @return {number}
 */
var findValueOfPartition = function(nums) {
    nums=nums.sort(function(a,b){
        return a-b;
    });
    let min=Infinity;
    for(let i=0;i<nums.length-1;i++){
        if((Math.abs(nums[i]-nums[i+1]))<min){
            min=Math.abs(nums[i]-nums[i+1]);
        }
    }
    return min;
};