/**
 * @param {string[]} sentences
 * @return {number}
 */
var mostWordsFound = function(sentences) {
    let max=-Infinity;
    for(let i=0;i<sentences.length;i++){
        let str=sentences[i].split(' ');
        if(str.length>max){
            max=str.length;
        }
    }
    return max;
};