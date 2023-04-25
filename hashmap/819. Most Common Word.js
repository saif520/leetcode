/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function(paragraph, banned) {
    let arr = paragraph.toLowerCase().split(/[^a-z]/);
    let myMap = new Map();
    let mySet = new Set(banned);
    let max = 0;
    let result = "";

    arr.forEach(word => {
        if(!mySet.has(word) && word != ''){
            myMap.set(word, myMap.has(word) ? myMap.get(word) + 1 : 1);
            if(max < myMap.get(word)){
                max = myMap.get(word);
                result = word;
            }
        }
    })
    return result
};