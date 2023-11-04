/**
 * @param {number[]} nums
 * @return {number[]}
 */
var decompressRLElist = function(nums) {
    let ans=[];
    for(let i=0;i<nums.length;i++){
        let j=0;
        while(j<nums[2*i]){
            ans.push(nums[2*i+1]);
            j++;
        }
    }
    return ans;
};