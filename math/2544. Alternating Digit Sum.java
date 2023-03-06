class Solution {
    public int alternateDigitSum(int n) {
        int sum=0;
        Deque<Integer> dq=new ArrayDeque<>();
        while(n>0){
            dq.addFirst(n%10);
            n=n/10;
        }
        while(dq.size()!=0){
            if(dq.size()!=0){
                sum=sum+dq.removeFirst();
            }
            if(dq.size()!=0){
                sum=sum-dq.removeFirst();
            }
        }
        return sum;
    }
}