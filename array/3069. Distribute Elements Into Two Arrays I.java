class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        list1.add(nums[0]);
        int l1=0;
        list2.add(nums[1]);
        int l2=0;
        for(int i=2;i<nums.length;i++){
            if(list1.get(l1)>list2.get(l2)){
                list1.add(nums[i]);
                l1++;
            }
            else{
                list2.add(nums[i]);
                l2++;
            }
        }
        int i=0;
        while(i<list2.size()){
            list1.add(list2.get(i));
            i++;
        }
        int ans[]=new int[nums.length];
        int j=0;
        while(j<list1.size()){
            ans[j]=list1.get(j);
            j++;
        }
        return ans;
    }
}