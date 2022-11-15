/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
 var findMedianSortedArrays = function(nums1, nums2) {
    let n1=nums1.length;
    let n2=nums2.length;
    let arr=[];
    let i=0;
    let j=0;
    while(i<n1&&j<n2){
        if(nums1[i]<nums2[j]){
            arr.push(nums1[i]);
            i++;
        }
        else if(nums1[i]>nums2[j]){
            arr.push(nums2[j]);
            j++;
        }
        else if(nums1[i]==nums2[j]){
            arr.push(nums1[i]);
            arr.push(nums2[i]);
            i++;
            j++;
        }
    }
    if(i<n1){
        for(let k=i;k<n1;k++){
            arr.push(nums1[k]);
        }
    }
    else if(j<n2){
        for(let k=j;k<n2;k++){
            arr.push(nums2[k])
        }
    }
    let len=arr.length;
    let mid=Math.floor((0+len)/2);
    if(len%2!=0){
        return arr[mid];
    }
    else if(len%2==0){
        return ((arr[Math.floor(len/2)]+arr[Math.floor(len/2)-1])/2);
    }
};