/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function(s) {
    s=s.split('')
    s=s.sort();
    let obj={};
    for(let i=0;i<s.length;i++){
        if(obj[s[i]]){
            obj[s[i]]++;
        }
        else{
            obj[s[i]]=1;
        }
    }
    let arr=[];
    let str=[];
    for(i in obj){
        arr.push(obj[i]);
        str.push(i);
    }
    //mergeSort(arr,0,arr.length-1);
    for(let i=0;i<arr.length-1;i++){
        let swap=0;
        for(let j=0;j<arr.length-i-1;j++){
            if(arr[j]<arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swap=1;

                let temp1=str[j];
                str[j]=str[j+1];
                str[j+1]=temp1;
            }
        }
        if(swap==0){
            break;
        }
    }
    let ans=[];
    for(let i=0;i<arr.length;i++){
        let n=arr[i];
        for(let j=0;j<n;j++){
            ans.push(str[i]);
        }
    }
    return ans.join('');
    
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