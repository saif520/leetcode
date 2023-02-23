/**
 * @param {string} s
 * @return {character}
 */
var repeatedCharacter = function(s) {
    s=s.split('');
    let obj={};
    for(let i=0;i<s.length;i++){
        if(obj[s[i]]){
            obj[s[i]]++;
        }
        else{
            obj[s[i]]=1;
        }
        for(let j in obj){
            if(obj[j]==2){
                return j;
            }
        }
    }
};