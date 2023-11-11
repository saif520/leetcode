class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.get(arr[i])==null?1:map.get(arr[i])+1);
        }
        System.out.println(map);
        int ans=-1;
        for(Map.Entry e:map.entrySet()){
            if((int)e.getKey()==(int)e.getValue()){
                if((int)e.getKey()>ans){
                    ans=(int)e.getKey();
                }
            }
        }
        return ans;
    }
}