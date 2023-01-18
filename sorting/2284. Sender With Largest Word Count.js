/**
 * @param {string[]} messages
 * @param {string[]} senders
 * @return {string}
 */
var largestWordCount = function(messages, senders) {
    let newsender=[];
    for(let i=0;i<senders.length;i++){
        newsender.push(senders[i]);
    }
    let carr=[];
    for(let i=0;i<messages.length;i++){
       carr.push(messages[i].split(' ').length);
    }
  
    senders=senders.sort();
    let s=[];
    for(let i=0;i<senders.length;i++){
        if(senders[i]==senders[i+1]){
            continue;
        }
        else{
            s.push(senders[i]);
        }
    }
    let sumobj={};
    for(let i=0;i<s.length;i++){
        let sum=0;
        for(let j=0;j<newsender.length;j++){
            if(s[i]==newsender[j]){
                sum=sum+carr[j];
            }
        }
        sumobj[s[i]]=sum;
    }

    let arr=Object.values(sumobj);
    let min=Math.min(...arr);
    let max=Math.max(...arr);
   
    let ans;
    for(let i in sumobj){
        if(sumobj[i]==max){
            ans=i;
        }
    }
    return ans;

};