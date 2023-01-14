/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    let n=nums.length;
    mergeSort(nums,0,n-1);
    
    let bag=[];
    let count=1;
    for(let i=0;i<n;i++){
        if(nums[i]==nums[i+1]){
            count++;
        }
        else{
            if(count>Math.floor(n/3)){
                bag.push(nums[i]);
            }
            count=1;
        }
    }
    return bag;
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