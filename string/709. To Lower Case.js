/**
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function(s) {
    s=s.split('');
    let str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
    let str2="abcdefghijklmnopqrstuvwxyz".split('');
    for(let i=0;i<s.length;i++){
        for(let j=0;j<str1.length;j++){
            if(s[i]==str1[j]){
                s[i]=str2[j];
            }
        }
    }
    s=s.join('');
    return s;
};