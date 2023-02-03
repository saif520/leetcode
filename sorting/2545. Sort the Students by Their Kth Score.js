/**
 * @param {number[][]} score
 * @param {number} k
 * @return {number[][]}
 */
var sortTheStudents = function(score, k) {
    let m=score.length;
    let n=score[0].length;
    let bag=[];
    let idx=[];
    for(let i=0;i<m;i++){
        bag.push(score[i][k]);
        idx.push(i);
    }
    let obj={};
    for(let i=0;i<bag.length;i++){
        obj[bag[i]]=idx[i];
    }
    mergeSort(bag,0,bag.length-1);
    let temp=[];
    for(let i=0;i<bag.length;i++){
        temp.push(obj[bag[i]]);
    }
    let ans=[];
    for(let i=0;i<temp.length;i++){
        let t=[];
        for(let j=0;j<n;j++){
            t.push(score[temp[i]][j]);
        }
        ans.push(t);
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
        if(nums[i]>=nums[j]){
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