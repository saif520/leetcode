/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
var shuffle = function(nums, n) {
    let l=1;
    let r=n;
    while(l!=r){
        let temp=nums[r];
        let i=r;
        while(i>l){
            nums[i]=nums[i-1];
            i--;
        }
        nums[l]=temp;
        l=l+2;
        r=r+1;
    }
    return nums;
};