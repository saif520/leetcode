class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] src, int[] dest) {
        TreeSet<Integer>set=new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        
        int n=src.length;
        for(int i=0;i<n;i++){            
            int l1=src[i];
            int l2=dest[i];
            
            set.remove(l1);
            set.add(l2);
        }
        
        List<Integer> ans=new ArrayList<>();
        ans.addAll(set);
        return ans;
    }
}
