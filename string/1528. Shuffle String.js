/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
var restoreString = function(s, indices) {
    let obj={};
    for(let i=0;i<indices.length;i++){
        obj[indices[i]]=s[i];
    }
    let str="";
    for(let i in obj){
        str=str+obj[i];
    }
    return str;
};