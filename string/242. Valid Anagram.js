/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    s=s.split('');
    t=t.split('');
    s=s.sort();
    t=t.sort();
    s=s.join('');
    t=t.join('');
    if(s==t){
        return true;
    }
    else{
        return false;
    }

};