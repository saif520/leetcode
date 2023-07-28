/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
    s1=s1.split(" ");
    s2=s2.split(" ");
    let objs1={};
    let objs2={};

    for(let i=0;i<s1.length;i++){
        if(objs1[s1[i]]){
            objs1[s1[i]]++;
        }
        else{
            objs1[s1[i]]=1;
        }
    }
    for(let i=0;i<s2.length;i++){
        if(objs2[s2[i]]){
            objs2[s2[i]]++;
        }
        else{
            objs2[s2[i]]=1;
        }
    }
    let ans=[];
    for(let i in objs1){
        if(objs1[i]==1&&!objs2[i]){
            ans.push(i);
        }
    }
    for(let i in objs2){
        if(objs2[i]==1&&!objs1[i]){
            ans.push(i);
        }
    }
    return ans;
};