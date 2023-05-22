/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    let obj={};
    for(let i=0;i<nums.length;i++){
        if(obj[nums[i]]){
            obj[nums[i]]++;
        }
        else{
            obj[nums[i]]=1;
        }
    }
    let key=[];
    let count=[];
    for(let i in obj){
        key.push(i);
        count.push(obj[i]);
    }
    
    for(let i=0;i<count.length-1;i++){
        let swap=0;
        for(let j=0;j<count.length-i;j++){
            if(count[j]<count[j+1]){
                let temp=count[j];
                count[j]=count[j+1];
                count[j+1]=temp;
                swap=1;

                let t=key[j];
                key[j]=key[j+1];
                key[j+1]=t;
            }
        }
        if(swap==0){
            break;
        }
    }
    return key.slice(0,k);
};