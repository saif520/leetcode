/**
 * @param {string[]} words1
 * @param {string[]} words2
 * @return {number}
 */
var countWords = function(words1, words2) {
    let obj1={};
        let obj2={};
        for(let i=0;i<words1.length;i++){
            if(obj1[words1[i]]){
                obj1[words1[i]]++;
            }
            else{
                obj1[words1[i]]=1;
            }
        }

        for(let i=0;i<words2.length;i++){
            if(obj2[words2[i]]){
                obj2[words2[i]]++;
            }
            else{
                obj2[words2[i]]=1;
            }
        }

        console.log(obj1);
        console.log(obj2);

        let ans=0;

        for(let i in obj1){
            let count1=obj1[i];
            if(i in obj2){
                let count2=obj2[i];
                if(count1==1&&count2==1){
                    ans++;
                }
            }
        }
        return ans;
};