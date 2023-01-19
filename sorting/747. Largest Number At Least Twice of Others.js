/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
    let max=-Infinity;
    let idx=0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]>max){
            max=nums[i];
            idx=i;
        }
    }
    mergeSort(nums,0,nums.length-1);
    let flag=0;
    for(let i=0;i<nums.length-1;i++){
        if(2*nums[i]<=max){
            flag=1;
        }
        else{
            flag=0;
            break;
        }
    }
    if(flag==1){
        return idx;
    }
    else{
        return -1;
    }
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