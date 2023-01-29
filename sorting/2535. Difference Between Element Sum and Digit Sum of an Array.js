/**
 * @param {number[]} nums
 * @return {number}
 */
var differenceOfSum = function(nums) {
    let esum=0;
    for(let i=0;i<nums.length;i++){
        esum=esum+nums[i];
    }
    let dsum=0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]<10){
            dsum=dsum+nums[i];
        }
        else{
            let n=nums[i]
            while(n>0){
                dsum=dsum+n%10;
                n=Math.floor(n/10);
            }
        }
    }
    return Math.floor(esum-dsum);
};