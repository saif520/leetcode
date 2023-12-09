class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1=set(nums1)
        s2=set(nums2)
        
        ans=[0,0]
        for x in nums1:
            if x in s2:
                ans[0]+=1
        for x in nums2:
            if x in s1:
                ans[1]+=1
        return ans