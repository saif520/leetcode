class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer>res=new ArrayList();
        int[][]cnt=new int[3][101];
        for(int num:nums1){
            cnt[0][num]=1;
        }
        for(int num:nums2){
            cnt[1][num]=1;
        }
        for(int num:nums3){
            cnt[2][num]=1;
        }
        for(int i=1;i<101;i++){
            if(cnt[0][i]+cnt[1][i]+cnt[2][i]>=2){
                res.add(i);
            }
        }
        return res;
    }
}