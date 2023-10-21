/**
 * @param {string[]} words
 * @param {string} pref
 * @return {number}
 */
var prefixCount = function(words, pref) {
    let count=0;
    for(let i=0;i<words.length;i++){
        let str=words[i];
        let flag=true;
        for(let j=0;j<pref.length;j++){
            if(pref[j]!=str[j]){
                flag=false;
                break;
            }
        }
        if(flag==true){
            count++;
        }
    }
    return count;
};