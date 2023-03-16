/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    let ans=[];
    ans.push(words[0]);
    for(let i=1;i<words.length;i++){
        if(checkAnagram(ans[ans.length-1],words[i])==true){
            continue;
        }
        else{
            ans.push(words[i]);
        }
    }
    return ans;
};
var checkAnagram=function(ch1,ch2){
    let obj1={};
    let obj2={};
    ch1=ch1.split('');
    ch2=ch2.split('');
    for(let i=0;i<ch1.length;i++){
        if(obj1[ch1[i]]){
            obj1[ch1[i]]++;
        }
        else{
            obj1[ch1[i]]=1;
        }
    }
    for(let i=0;i<ch2.length;i++){
        if(obj2[ch2[i]]){
            obj2[ch2[i]]++;
        }
        else{
            obj2[ch2[i]]=1;
        }
    }
    var size1 = Object.keys(obj1).length;
    var size2 = Object.keys(obj2).length;
    if(size1!=size2){
        return false;
    }
    let flag;
    for(let i in obj1){
        flag=0;
        for(i in obj2){
            if(obj1[i]==obj2[i]){
                flag=1;
            }
            else{
                flag=0;
                break;
            }
        }
    }
    if(flag==1){
        return true;
    }
    else{
        return false;
    }
}