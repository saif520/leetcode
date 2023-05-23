class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double>unique=new HashSet<>();
        int i=0;
        int j=nums.length-1;
        while(i<j){
            unique.add((double)(nums[i]+nums[j])/2);
            i++;
            j--;
        }
        System.out.print(unique);
        return unique.size();
    }
}