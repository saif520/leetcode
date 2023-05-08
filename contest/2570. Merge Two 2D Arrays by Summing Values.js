/**
 * @param {number[][]} nums1
 * @param {number[][]} nums2
 * @return {number[][]}
 */
var mergeArrays = function(nums1, nums2) {
    let ans=[];
    let temp=[];
    let n=nums1.length;
    let m=nums2.length;
    let i=0;
    let j=0;
    while(i<n&&j<m){
        temp=[];
        if(nums1[i][0]==nums2[j][0]){
            temp.push(nums1[i][0],(nums1[i][1]+nums2[j][1]));
            i++;
            j++;
        }
        else if(nums1[i][0]<nums2[j][0]){
            temp.push(nums1[i][0],nums1[i][1]);
            i++;
        }
        else{
            temp.push(nums2[j][0],nums2[j][1]);
            j++;
        }
        ans.push(temp);
    }
    while(i<n){
        temp=[];
        temp.push(nums1[i][0],nums1[i][1]);
        i++;
        ans.push(temp);
    }
    while(j<m){
        temp=[];
        temp.push(nums2[j][0],nums2[j][1]);
        j++;
        ans.push(temp);
    }
    return ans;
};