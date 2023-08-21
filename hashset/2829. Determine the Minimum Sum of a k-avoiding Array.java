class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer>skip=new HashSet<>();
        int size=0;
        int num=1;
        int sum=0;
        while(size<n){
            if(skip.contains(num)){
                num++;
                continue;
            }
            sum+=num;
            size++;
            int diff=k-num;
            
            if(diff>0){
                skip.add(diff);
            }
            num++;
        }
        return sum;
    }
}