/**
 * @param {string} s
 * @return {boolean}
 */
var areNumbersAscending = function(s) {
    s=s.split(' ');

    let arr=[];
    for(let i=0;i<=100;i++){
        arr.push(i.toString());
    }
    let bag=[];
    for(let i=0;i<s.length;i++){
        for(let j=0;j<arr.length;j++){
            if(s[i]==arr[j]){
                bag.push(s[i]);
            }
        }
    }
    bag=bag.map(Number);
    for(let i=0;i<bag.length-1;i++){
        if(bag[i]>=bag[i+1]){
            return false;
        }
    }
    return true;
};