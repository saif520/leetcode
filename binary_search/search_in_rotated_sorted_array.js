/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var search = function(nums, target) {
    let n=nums.length;
    let minIndex=findMinIndex(nums);
    let index1=leftBinary(nums,0,minIndex-1,target);
    let index2=rightBinary(nums,minIndex,n-1,target);
    if(index1!=-1){
        return index1;
    }
    else if(index2!=-1){
        return index2;
    }
    else{
        return -1;
    }
};
var findMinIndex = function(nums) {
    let lo=0;
    let hi=nums.length-1;
    if(nums[lo]<=nums[hi]){
        return lo;
    }
    while(lo<=hi){
        let mid=Math.floor((lo+hi)/2);
        if(nums[mid]>nums[mid+1]){
            return mid+1;
        }
        else if(nums[mid]<nums[mid-1]){
            return mid;
        }
        else if(nums[lo]<=nums[mid]){
            lo=mid+1;
        }
        else if(nums[mid]<=nums[hi]){
            hi=mid-1;
        }
    }
    return -1;
};
let leftBinary=function(nums,lb,ub,target){
    while(lb<=ub){
        let mid=Math.floor((lb+ub)/2);
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            lb=mid+1;
        }
        else{
            ub=mid-1;
        }
    }
    return -1;
}
let rightBinary=function(nums,lb,ub,target){
    while(lb<=ub){
        let mid=Math.floor((lb+ub)/2);
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            lb=mid+1;
        }
        else{
            ub=mid-1;
        }
    }
    return -1;
}