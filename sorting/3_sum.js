/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var threeSum = function(nums) {
    sortArray(nums);
    let bag=[];
    let n=nums.length;
    for(let i=0;i<n-2;i++){
        if(i==0||(i>0&&nums[i]!=nums[i-1])){
            let low=i+1;
            let high=n-1;
            let sum=0-nums[i];
            while(low<high){
                let temp=[];
                if(nums[low]+nums[high]==sum){
                    temp.push(nums[i],nums[low],nums[high]);
                    bag.push(temp);
                    while(low<high&&nums[low]==nums[low+1])low++;
                    while(low<high&&nums[high]==nums[high-1])high--;
                    low++;
                    high--;
                }
                else if(nums[low]+nums[high]>sum){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
    }
    return bag;
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