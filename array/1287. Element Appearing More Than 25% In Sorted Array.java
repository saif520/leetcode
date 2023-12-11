class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.get(arr[i])==null?1:map.get(arr[i])+1);
        }
        System.out.println(map);
        int max=-1;
        int ans=-1;
        for(Map.Entry e:map.entrySet()){
            if((int)e.getValue()>max){
                max=(int)e.getValue();
                ans=(int)e.getKey();
            }
        }
        return ans;
    }
}