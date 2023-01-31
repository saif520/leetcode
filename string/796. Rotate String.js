/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var rotateString = function(s, goal) {
    s=s.split('');
    let n=s.length;
    for(let i=0;i<n;i++){
        s.push(s.shift());
        s=s.join('');
        if(s==goal){
            return true;
        }
        s=s.split('');
    }
    return false;
};