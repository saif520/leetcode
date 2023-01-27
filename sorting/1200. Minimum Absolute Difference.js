/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
    let n=arr.length;
    mergeSort(arr,0,n-1);
    let min=Infinity;
    for(let i=0;i<n-1;i++){
        min=Math.min(min,Math.abs(arr[i+1]-arr[i]));
    }
    let ans=[];
    for(let i=0;i<n-1;i++){
        let temp=[];
        if(min==Math.abs(arr[i+1]-arr[i])){
            temp.push(arr[i],arr[i+1]);
        }
        if(temp.length!=0){
            ans.push(temp);
        }
    }
    return ans;
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