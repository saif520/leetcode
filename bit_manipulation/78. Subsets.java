class Solution {
    public static boolean jthBitIsSet(int n,int j){
        int mask=1<<j;
        if((n&mask)>0) return true;
        return false;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        int power=(int)Math.pow(2,n);
        for(int i=0;i<power;i++){
            List<Integer>curr=new ArrayList<>();
            int j=0;
            while(j<n){
                if(jthBitIsSet(i,j))curr.add(nums[j]);
                j++;
            }
            res.add(curr);
        }
        return res;
    }
}