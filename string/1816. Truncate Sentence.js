/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var truncateSentence = function(s, k) {
    s=s.split(" ");
    let str="";
    for(let i=0;i<k;i++){
        str=str+s[i]+" ";
    }
    return str.trim();
};