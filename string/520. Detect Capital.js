/**
 * @param {string} word
 * @return {boolean}
 */
var detectCapitalUse = function(word) {     
    word=word.split('');
    console.log(word);
    let str="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
    //console.log(str);
    let count=0;
    for(let i=0;i<word.length;i++){
        for(let j=0;j<str.length;j++){
            if(word[i]==str[j]){
                count++;
            }
        }
    }
    if(count==0||count==word.length){
        return true;
    }
    else if(count==1){
        for(let i=0;i<str.length;i++){
            if(word[0]==str[i]){
                return true;
            }
        }
    }
    return false;
};