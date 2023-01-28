/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    s=s.split('');
    let obj=[];
    for(let i=0;i<s.length;i++){
        if(obj[s[i]]){
            obj[s[i]]++;
        }
        else{
            obj[s[i]]=1;
        }
    }
    for(let i=0;i<s.length;i++){
        for(let j in obj){
            if(s[i]==j){
                if(obj[j]==1){
                    return i;
                }
            }
        }
    }
    return -1;
};