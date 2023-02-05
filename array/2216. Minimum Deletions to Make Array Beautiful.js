/**
 * @param {number[]} nums
 * @return {number}
 */
var minDeletion = function(nums) {
    let d=0;
    let n=nums.length;
    for(let i=0;i<n-1;i++){
        let newIndex=i-d;
        if((newIndex%2==0)&&nums[i]==nums[i+1]){
            d++;
        }
    }
    return ((n-d)%2==0)?d:d+1;
};