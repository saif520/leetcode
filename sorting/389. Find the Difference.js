/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    s=s.split('');
    t=t.split('');
    s=s.sort();
    t=t.sort();
    for(let i=0;i<s.length;i++){
        if(t[i]!=s[i]){
            return t[i];
        }
    }
    return t[t.length-1];
};