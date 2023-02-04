/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    let vowel=[];
    s=s.split('');
    for(let i=0;i<s.length;i++){
        if(checkVowel(s[i])){
            vowel.push(s[i]);
        }
    }
    vowel=vowel.reverse();
    let j=0;
    for(let i=0;i<s.length;i++){
        if(checkVowel(s[i])){
            s[i]=vowel[j];
            j++;
        }
    }
    return s.join('');
};
let checkVowel=function(ch){
    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
}