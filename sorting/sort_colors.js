/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 var sortColors = function(nums) {
    
    //approach 1: using counting sort
    /*
    let count0=0;
    let count1=0;
    let count2=0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]==0){
            count0++;
        }
        else if(nums[i]==1){
            count1++;
        }
        else{
            count2++;
        }
    }
    let i=0;
    while(count0>0){
        nums[i]=0;
        i++;
        count0--;
    }
    while(count1>0){
        nums[i]=1;
        i++;
        count1--;
    }
    while(count2>0){
        nums[i]=2;
        i++;
        count2--;
    }
    */
    
    //approach 2: using dutch national flag algorithm
    
    let low=0;
    let mid=0;
    let high=nums.length-1;
    while(mid<=high){
        if(nums[mid]==0){
            let temp=nums[mid];
            nums[mid]=nums[low];
            nums[low]=temp;
            low++;
            mid++;
        }
        else if(nums[mid]==1){
            mid++;
        }
        else{
            let temp=nums[mid];
            nums[mid]=nums[high];
            nums[high]=temp;
            high--;
        }
    }
};