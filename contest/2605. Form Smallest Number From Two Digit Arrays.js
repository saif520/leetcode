/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minNumber = function(nums1, nums2) {
    let arr1=nums1.sort(function(a,b){
        return a-b;
    })
    console.log(arr1);
    let arr2=nums2.sort(function(a,b){
        return a-b;
    })
    console.log(arr2);
    for(let i=0;i<arr1.length;i++){
        for(let j=0;j<arr2.length;j++){
            if(arr1[i]==arr2[j]){
                return arr1[i];
            }
        }
    }
    if(arr1[0]>arr2[0]){
        return arr2[0]+""+arr1[0];
    }
    else{
        return arr1[0]+""+arr2[0];
    }
};