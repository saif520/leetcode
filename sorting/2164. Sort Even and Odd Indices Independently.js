/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortEvenOdd = function(nums) {
    let odd=[];
    let even=[];
    for(let i=0;i<nums.length;i++){
        if(i%2==0){
            even.push(nums[i]);
        }
        else{
            odd.push(nums[i]);
        }
    }
    mergeSort1(even,0,even.length-1);
    mergeSort2(odd,0,odd.length-1);
    console.log(even);
    console.log(odd);
    let left=0;
    let right=odd.length-1;
    while(left<right){
        let temp=odd[left];
        odd[left]=odd[right];
        odd[right]=temp;
        left++;
        right--;
    }

    let ans=[];
    let i,j;
    for(i=0,j=0;i<even.length&&j<odd.length;i++,j++){
        ans.push(even[i]);
        ans.push(odd[j]);
    }
    if(i<even.length){
        ans.push(even[i]);
    }
    if(j<odd.length){
        ans.push(odd[j]);
    }
    return ans;
};
let mergeSort1=function(temp,lb,ub){
    if(lb<ub){
        let mid=Math.floor((lb+ub)/2);
        mergeSort1(temp,lb,mid);
        mergeSort1(temp,mid+1,ub);
        merge1(temp,lb,mid,ub);
    }
}
let merge1=function(temp,lb,mid,ub){
    let i=lb;
    let j=mid+1;
    let k=0;
    let arr=[];
    while(i<=mid&&j<=ub){
        if(temp[i]<=temp[j]){
            arr.push(temp[i]);
            i++;
        }
        else{
            arr.push(temp[j]);
            j++;
        }
        k++
    }
    while(i<=mid){
        arr.push(temp[i]);
        i++;
        k++;
    }
    while(j<=ub){
        arr.push(temp[j]);
        j++;
        k++;
    }
    let p=0;
    for(let idx=lb;idx<=ub;idx++){
        temp[idx]=arr[p];
        p++;
    }
}

let mergeSort2=function(temp,lb,ub){
    if(lb<ub){
        let mid=Math.floor((lb+ub)/2);
        mergeSort2(temp,lb,mid);
        mergeSort2(temp,mid+1,ub);
        merge2(temp,lb,mid,ub);
    }
}
let merge2=function(temp,lb,mid,ub){
    let i=lb;
    let j=mid+1;
    let k=0;
    let arr=[];
    while(i<=mid&&j<=ub){
        if(temp[i]<=temp[j]){
            arr.push(temp[i]);
            i++;
        }
        else{
            arr.push(temp[j]);
            j++;
        }
        k++
    }
    while(i<=mid){
        arr.push(temp[i]);
        i++;
        k++;
    }
    while(j<=ub){
        arr.push(temp[j]);
        j++;
        k++;
    }
    let p=0;
    for(let idx=lb;idx<=ub;idx++){
        temp[idx]=arr[p];
        p++;
    }
}
