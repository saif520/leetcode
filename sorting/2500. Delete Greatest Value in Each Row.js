/**
 * @param {number[][]} grid
 * @return {number}
 */
var deleteGreatestValue = function(grid) {
    let m=grid.length;
    let n=grid[0].length;
    for(let i=0;i<m;i++){
        let bag=[];
        for(let j=0;j<n;j++){
            bag.push(grid[i][j]);
        }
        mergeSort(bag,0,bag.length-1);
        for(let k=0;k<n;k++){
            grid[i][k]=bag[k];
        }
    }
    let sum=0;
    for(let i=n-1;i>=0;i--){
        let max=grid[0][i];
        for(let j=1;j<m;j++){
            if(grid[j][i]>max){
                max=grid[j][i];
            }
        }
        sum=sum+max;
    }
    return sum;
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