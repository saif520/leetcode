class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int a:apple){
            sum+=a;
        }
        Arrays.sort(capacity);

        for (int i = 0, j = capacity.length - 1; i < j; i++, j--) {
            int temp = capacity[i];
            capacity[i] = capacity[j];
            capacity[j] = temp;
        }


        int count=0;
        
        for(int i=0;i<capacity.length;i++){
            sum=sum-capacity[i];
            count++;
            if(sum<=0){
                break;
            }
        }
        return count;
    }
}