/**
 * @param {number[]} nums
 * @return {number}
 */
var xorBeauty = function(nums) {
    let ans=0;
    nums.forEach(function(a){
        ans=ans^a;
    })
    return ans;
};