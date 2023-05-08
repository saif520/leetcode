/**
 * @param {number[]} nums
 * @return {number[]}
 */
var leftRigthDifference = function(nums) {
    let leftSum=[];
    let rightSum=[];
    leftSum[0]=0;
    rightSum[nums.length-1]=0;
    for(let i=1;i<nums.length;i++){
        leftSum[i]=leftSum[i-1]+nums[i-1];
    }

    for(let i=nums.length-2;i>=0;i--){
        rightSum[i]=rightSum[i+1]+nums[i+1];
    }

    let ans=[];
    for(let i=0;i<nums.length;i++){
        ans.push(Math.abs(leftSum[i]-rightSum[i]));
    }
    return ans;
};