class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>arr=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            while(n>0){
                dq.addFirst(n%10);
                n=n/10;
            }
            while(dq.size()!=0){
                arr.add(dq.removeFirst());
            }
        }
        int a[]=new int[4];
        int res[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}