/**
 * @param {string} s
 * @return {string}
 */
var sortSentence = function(s) {
    s=s.split(' ');
    let str=[];
    let arr=[];
    for(let i=0;i<s.length;i++){
        str.push(s[i].slice(0,s[i].length-1));
        arr.push(s[i].slice(s[i].length-1,s[i].length));
    }
    arr=arr.map(Number);
    let obj={};
    for(let i=0;i<arr.length;i++){
        obj[arr[i]]=str[i];
    }
    mergeSort(arr,0,arr.length-1);
    let newStr="";
    for(let i=0;i<arr.length;i++){
        newStr=newStr+obj[arr[i]]+" ";
    }
    return newStr.trim();
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