class Solution {
    public double average(int[] salary) {
        int n=salary.length;
        int max=salary[0];
        for(int i=1;i<n;i++){
            if(salary[i]>max){
                max=salary[i];
            }
        }
        int min=salary[0];
        for(int i=1;i<n;i++){
            if(salary[i]<min){
                min=salary[i];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(salary[i]==max||salary[i]==min){
                continue;
            }
            else{
                System.out.print(salary[i]);
                sum+=salary[i];
            }
        }
        return sum/Math.floor(n-2);
    }
}