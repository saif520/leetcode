/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let bag1=[];
    let bag2=[];
    for(let i=0;i<arr1.length;i++){
        if(checkPresent(arr1[i],arr2)==true){
            bag1.push(arr1[i]);
        }
        else{
           bag2.push(arr1[i]);
        }
    }
    let obj={};
    for(let i=0;i<arr1.length;i++){
        if(obj[arr1[i]]){
            obj[arr1[i]]++;
        }
        else{
            obj[arr1[i]]=1;
        }
    }
    let count=[];
    for(let i=0;i<arr2.length;i++){
        for(let j in obj){
            if(j==arr2[i]){
                count.push(obj[j]);
            }
        }
    }
    let ans=[];
    let j=0;
    for(let i=0;i<arr2.length;i++){
        let k=0;
        while(k<count[j]){
            ans.push(arr2[i]);
            k++;
        }
        j++;
    }
    let obj2={};
    for(let i=0;i<bag2.length;i++){
        if(obj2[bag2[i]]){
            obj2[bag2[i]]++;
        }
        else{
            obj2[bag2[i]]=1;
        }
    }
    let count2=[];
    let bag3=[];
    for(let i in obj2){
        bag3.push(i);
        count2.push(obj2[i]);
    }
    let q=0;
    for(let p=0;p<bag3.length;p++){
        let r=0;
        while(r<count2[q]){
            ans.push(bag3[p]);
            r++;
        }
        q++;
    }
    return ans;
};
function checkPresent(num,arr2){
    for(let i=0;i<arr2.length;i++){
        if(num==arr2[i]){
            return true;
        }
    }
    return false;
}