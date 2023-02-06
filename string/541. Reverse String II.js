/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    s=s.split('');
    if(s.length<k){
        callSwap(s);
        return s.join('');
    }
    let arr=[];
    for(let i=0;i<s.length;i=i+k){
        let bag=[]
        for(let j=i;j<k+i;j++){
            if(s[j]!=undefined){
                bag.push(s[j]);
            }
        }
        arr.push(bag);
    }
    for(let i=0;i<arr.length;i++){
        if(i%2==0){
            callSwap(arr[i]);
        }
    }
    for(let i=0;i<arr.length;i++){
        arr[i]=arr[i].join('');
    }
    return arr.join('');
};

let callSwap=function(str){
    let left=0;
    let right=str.length-1;
    while(left<right){
        let temp=str[left];
        str[left]=str[right];
        str[right]=temp;
        left++;
        right--;
    }
}