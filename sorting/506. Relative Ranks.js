/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let temp=[];
    for(let i=0;i<score.length;i++){
        temp.push(score[i]);
    }
    let n=score.length;
    mergeSort(score,0,n-1);

    let pos=[];
    for(let i=1;i<=n;i++){
        pos.push(i);
    }
    pos=pos.toString().split(",");
    pos[0]="Gold Medal";
    pos[1]="Silver Medal";
    pos[2]="Bronze Medal";

    let rank={};
    for(let i=0;i<score.length;i++){
        rank[score[i]]=pos[i];
    }

    let t=[];
    for(let i=0;i<temp.length;i++){
        t.push(rank[temp[i]]);
    }
    return t;
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