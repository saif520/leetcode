/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
    let i;
    for(i=0;i<letters.length;i++){
        if(letters[i]>target){
            break;
        }
    }
    if(i==letters.length){
        return letters[0];
    }
    return letters[i];
};