class Solution {
    public int totalMoney(int n) {
        int count=0;
        int sum=0;
        for(int i=1;i<=n;i++){
            int j=i;
            while(j<7+i){
                count++;
                sum+=j;
                if(count==n){
                    break;
                }
                j++;
            }
            if(count==n){
                break;
            }
            System.out.println();
        }
        return sum;
    }
}