/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximizeSum = function(nums, k) {
    let arr=nums.sort(function(a,b){
        return a-b;
    });
    let max=0;
    let i=0;
    while(i<k){
        max+=arr[arr.length-1];
        arr[arr.length-1]=arr[arr.length-1]+1;
        i++;
    }
    return max;
};