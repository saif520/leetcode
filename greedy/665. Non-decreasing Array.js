/**
 * @param {number[]} nums
 * @return {boolean}
 */
var checkPossibility = function(nums) {
    let modificationCount=0;
    for(let i=1;i<nums.length;i++){
        if(nums[i-1]>nums[i]){
            modificationCount++;
            
            if(i>=2&&nums[i-2]>nums[i]){
                nums[i]=nums[i-1];
            }
            else{
                nums[i-1]=nums[i];
            }
        }
    }
    console.log(nums);
    return modificationCount<=1;
};