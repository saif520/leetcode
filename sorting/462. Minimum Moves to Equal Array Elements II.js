/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function(nums) {
    let n=nums.length;
    mergeSort(nums,0,n-1);
    let mid=Math.floor(n/2);
    let count=0;
    let start=0;
    let end=n-1;
    while(start<mid){
        count=count+(nums[mid]-nums[start]);
        start++;
    }
    while(end>mid){
        count=count+(nums[end]-nums[mid]);
        end--;
    }
    return count;
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