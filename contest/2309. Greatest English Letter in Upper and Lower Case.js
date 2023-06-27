/**
 * @param {string} s
 * @return {string}
 */
var greatestLetter = function(s) {
    let obj={};
    let obj1={};
    let obj2={};
    let s1="abcdefghijklmnopqrstuvwxyz".split('');
    let s2="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
    for(let i=0;i<s1.length;i++){
        obj1[s1[i]]=i+1;
        obj2[s2[i]]=i+1;
    }
    for(let i=0;i<s.length;i++){
        if(obj[s[i]]){
            obj[s[i]]++;
        }
        else{
            obj[s[i]]=1;
        }
    }
    let ans=[];
    for(let i in obj1){
        if(i in obj&& i.toUpperCase() in obj){
            ans.push(i.toUpperCase());
        }
    }
    if(ans.length==0){
        return "";
    }
    return ans[ans.length-1];
};