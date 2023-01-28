/**
 * @param {number[]} nums
 * @return {number}
 */
var specialArray = function(nums) {
    let n=nums.length;
    for(let i=1;i<=n;i++){
        let counter=0;
        for(let j=0;j<n;j++){
            if(nums[j]>=i){
                counter++;
            }
        }
        if(counter==i){
            return i;
        }
    }
    return -1;
};