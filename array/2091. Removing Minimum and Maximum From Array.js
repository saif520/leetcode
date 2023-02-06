/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumDeletions = function(nums) {
    let n=nums.length;
    if(n==1)return 1;
    let maxii=0;
    let maxi=nums[0];
    let mini=nums[0];
    let minii=0;
    for(let i=1;i<n;i++){
        if(nums[i]<=mini){
            mini=nums[i];
            minii=i;
        }
        if(nums[i]>=maxi){
            maxi=nums[i];
            maxii=i;
        }
    }
    let x=Math.min(minii,maxii);
    let y=Math.max(maxii,minii)
    let ans=Math.min(n-(y-x-1),y+1,n-x);
    return ans;
};