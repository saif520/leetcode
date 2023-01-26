/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProductDifference = function(nums) {
    mergeSort(nums,0,nums.length-1);
    console.log(nums);
    let n=nums.length;
    return nums[n-1]*nums[n-2]-nums[0]*nums[1];
};
let mergeSort=function(nums,lb,ub){
    if(lb==ub){
        return;
    }
    let mid=Math.floor((lb+ub)/2);
    mergeSort(nums,lb,mid);
    mergeSort(nums,mid+1,ub);
    merge(nums,lb,mid,ub);
}
let merge=function(nums,lb,mid,ub){
    let i=lb;
    let j=mid+1;
    let k=0;
    let arr=[];
    while(i<=mid&&j<=ub){
        if(nums[i]<=nums[j]){
            arr.push(nums[i]);
            i++;
        }
        else{
            arr.push(nums[j]);
            j++;
        }
        k++
    }
    while(i<=mid){
        arr.push(nums[i]);
        i++;
        k++;
    }
    while(j<=ub){
        arr.push(nums[j]);
        j++;
        k++;
    }
    let p=0;
    for(let idx=lb;idx<=ub;idx++){
        nums[idx]=arr[p];
        p++;
    }
}