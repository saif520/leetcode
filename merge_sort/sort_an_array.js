/**
 * @param {number[]} nums
 * @return {number[]}
 */
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