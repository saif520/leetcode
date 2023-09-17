/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var sumIndicesWithKSetBits = function(nums, k) {
    let sum=0;
    for(let i=0;i<nums.length;i++){
        if(countSetBit(i)==k){
            sum+=nums[i];
        }
    }
    return sum;
};
let countSetBit=function(n){
    let count = 0;
    while (n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}