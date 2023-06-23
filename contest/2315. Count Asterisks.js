/**
 * @param {string} s
 * @return {number}
 */
var countAsterisks = function(s) {
    let barcount=0;
    let starcount=0;
    for(let i=0;i<s.length;i++){
        if(s[i]=='|'){
            barcount++;
        }
        if(barcount%2==0&&s[i]=='*'){
            starcount++;
        }
    }
    return starcount;
};