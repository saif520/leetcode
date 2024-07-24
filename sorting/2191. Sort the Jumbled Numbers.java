class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            char[] digits=String.valueOf(nums[i]).toCharArray();
            for(char digit:digits){
                sb.append(mapping[digit-'0']);
            }
            int value=Integer.parseInt(sb.toString());
            map.put(i,value);
        }

        List<Map.Entry<Integer,Integer>>sortedList=new ArrayList<>(map.entrySet());

        Collections.sort(sortedList,(entry1,entry2)->{
            int compareValue=entry1.getValue().compareTo(entry2.getValue());
            if(compareValue!=0){
                return compareValue;
            }
            else{
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });

        int[]sorted=new int[n];
        int finalIndex=0;
        for(Map.Entry<Integer,Integer>entry:sortedList){
            sorted[finalIndex++]=nums[entry.getKey()];
        }

        return sorted;
    }
}