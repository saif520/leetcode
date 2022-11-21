/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
 var fourSum = function(nums, target) {
    let ans=[];
    if(nums==null||nums.length<4)
        return ans;
    sortArray(nums);
    let n=nums.length;
    for(let i=0;i<nums.length-3;i++){
        if(i!=0&&nums[i]==nums[i-1])
            continue;
        for(let j=i+1;j<nums.length-2;j++){
            if(j!=i+1&&nums[j]==nums[j-1])
                continue;
            let k=j+1;
            let l=nums.length-1;
            while(k<l){
                if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                    k++;
                }
                else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                    l--;
                }
                else{
                    let temp=[];
                    temp.push(nums[i],nums[j],nums[k],nums[l]);
                    ans.push(temp);
                    k++;
                    l--;
                    while(k<l&&nums[l]==nums[l+1]){
                        l--;
                    }
                    while(k<l&&nums[k]==nums[k-1]){
                        k++;
                    }
                }
            }
        }
    }
    return ans;
    
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