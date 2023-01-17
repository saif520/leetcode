/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
    let bag=[];
    while(left<=right){
        let num=left;
        let flag=0;
        while(num>0){
            let rem=num%10;
            if(left%rem==0){
                flag=1;
            }
            else{
                flag=0;
                break;
            }
            num=Math.floor(num/10);
        }
        if(flag==1){
            bag.push(left);
        }
        left++;
    }
    return bag;
};