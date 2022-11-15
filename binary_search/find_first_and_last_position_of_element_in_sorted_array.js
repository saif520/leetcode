/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var searchRange = function(nums, target) {
    let ans=find(nums,target);
    return ans;
};
var find=function(arr,target){
    let ans=[-1,-1];
    let lo=0;
    let hi=arr.length-1;
    while(lo<=hi){
        let mid=Math.floor((lo+hi)/2);
        if(arr[mid]==target){
            ans[0]=mid;
            hi=mid-1;
        }
        else if(arr[mid]<target){
            lo=mid+1;
        }
        else{
            hi=mid-1;
        }
    }
    lo=0;
    hi=arr.length-1;
    while(lo<=hi){
        let mid=Math.floor((lo+hi)/2);
        if(arr[mid]==target){
            ans[1]=mid;
            lo=mid+1;
        }
        else if(arr[mid]<target){
            lo=mid+1;
        }
        else{
            hi=mid-1;
        }
    }
    return ans;
}