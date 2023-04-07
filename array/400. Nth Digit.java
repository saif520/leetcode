class Solution {
    public int findNthDigit(int m) {
        long n=m;
        ArrayList<Integer> arr=new ArrayList<>();
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            int temp=i;
            while(temp>0){
                int rem=temp%10;
                dq.addFirst(rem);
                temp=temp/10;
            }
            while(dq.size()>0){
                arr.add(dq.removeFirst());
            }
        }
        int ans=arr.get(m-1);
        return ans;
    }
}