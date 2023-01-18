/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    words=words.sort();
    // console.log(words);

    let varr=[];
    let karr=[];
    let obj={};
    let count=1;
    for(let i=0;i<words.length;i++){
       if(words[i]==words[i+1]){
           count++;
       }
       else{
           varr.push(count);
           karr.push(words[i]);
           obj[words[i]]=count;
           count=1;
       }
    }
    for(let i=0;i<varr.length-1;i++){
        let swap=0;
        for(let j=0;j<varr.length-i-1;j++){
            if(varr[j]<varr[j+1]){
                let temp=varr[j];
                varr[j]=varr[j+1];
                varr[j+1]=temp;
                swap=1;

                let temp1=karr[j];
                karr[j]=karr[j+1];
                karr[j+1]=temp1;
            }
        }
        if(swap==0){
            break;
        }
    }
    let ans=[];
    for(let i=0;i<k;i++){
        ans.push(karr[i]);
    }
    return ans;
};