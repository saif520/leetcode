/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var threeSumClosest = function(nums, target) {
    let result=nums[0]+nums[1]+nums[nums.length-1];
    sortArray(nums);
    for(let i=0;i<nums.length-2;i++){
        let a_pointer=i+1;
        let b_pointer=nums.length-1;
        while(a_pointer<b_pointer){
            let current_sum=nums[i]+nums[a_pointer]+nums[b_pointer];
            if(current_sum>target){
                b_pointer-=1;
            }
            else{
                a_pointer+=1;
            }
            if(Math.abs(current_sum-target)<Math.abs(result-target)){
                result=current_sum;
            }
        }
    }
    return result;
};
var sortArray = function(arr) {
    let n=arr.length;
     mergeSort(arr,0,n-1);
     return arr;
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

let mergeSort=function(arr,lb,ub){

    if(lb<ub){
        let mid=Math.floor((lb+ub)/2);
        mergeSort(arr,lb,mid);
        mergeSort(arr,mid+1,ub);
        merge(arr,lb,mid,ub);
    }
}