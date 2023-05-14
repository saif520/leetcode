/**
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var circularGameLosers = function(n, k) {
    
    let bag=[];
    let len=0;
    for(let i=1;i<=n;i++){
        bag.push(i*k);
        len+=i*k;
    }
    let obj={};
    for(let i=1;i<=n;i++){
        if(i==1){
            obj[i]=1;
        }
        else if(obj[i]){
            obj[i]++;
        }
        else{
            obj[i]=0;
        }
    }
    
    let arr=[];
    for(let i=1;i<=n;i++){
        arr.push(i);
    }

    let count=0;
    let newarr=[];
    for(let i=0;i<arr.length;i++){
        newarr.push(arr[i]);
        if(i==arr.length-1){
            i=-1;
        }
        count++;
        if(count==len){
            break
        }
    }
    let sum=0;
    console.log(obj);
    for(let i=0;i<bag.length;i++){
        sum+=bag[i];
        if(sum==len){
            break;
        }
        obj[newarr[sum]]++;
        if(obj[newarr[sum]]==2){
            break;
        }
    }
    let ans=[];
    for(let i in obj){
        if(obj[i]==0){
            ans.push(i);
        }
    }
    return ans;
};