/**
 * @param {string[]} words
 * @return {number}
 */
var maximumNumberOfStringPairs = function(words) {
    let count=0;
    for(let i=0;i<words.length-1;i++){
        for(let j=i+1;j<words.length;j++){
            if(words[i]==reverseWord(words[j])){
                count++;
            }
        }
    }
    return count;
};
let reverseWord=function(ch){
    ch=ch.split('');
    let first=0;
    let last=ch.length-1;
    while(first<last){
        let temp=ch[first];
        ch[first]=ch[last];
        ch[last]=temp;
        first++;
        last--;
    }
    return ch.join('');
}