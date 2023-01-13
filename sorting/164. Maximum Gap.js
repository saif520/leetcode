/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumGap = function(nums) {
    let n=nums.length;
    mergeSort(nums,0,n-1);
    let gap=0;
    for(let i=0;i<n-1;i++){
        if(Math.abs(nums[i]-nums[i+1])>gap){
            gap=Math.abs(nums[i]-nums[i+1]);
        }
    }
    return gap;
};
let mergeSort=function(arr,lb,ub){

    if(lb<ub){
        let mid=Math.floor((lb+ub)/2);
        mergeSort(arr,lb,mid);
        mergeSort(arr,mid+1,ub);
        merge(arr,lb,mid,ub);
    }
}

let merge=function(arr,lb,mid,ub){
    let i=lb;
    let j=mid+1;
    let k=lb;
    let b=[];
    while(i<=mid&&j<=ub){
        if(arr[i]<=arr[j]){
            b[k]=arr[i];
            i++;
            k++;
        }
        else{
            b[k]=arr[j];
            j++;
            k++;
        }
    }
    while(j<=ub){
        b[k]=arr[j];
        j++;
        k++;
    }
    while(i<=mid){
        b[k]=arr[i];
        i++;
        k++;
    }
    for(let k=lb;k<=ub;k++){
        arr[k]=b[k];
    }
}