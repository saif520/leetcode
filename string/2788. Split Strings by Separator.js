/**
 * @param {string[]} words
 * @param {character} separator
 * @return {string[]}
 */
var splitWordsBySeparator = function(words, separator) {
    let ans=[];
    for(let i=0;i<words.length;i++){
        let word=words[i];
        word=word.split(separator);
        for(let j=0;j<word.length;j++){
            if(word[j]!=''){
                ans.push(word[j]);
            }
        }
    }
    return ans;
};