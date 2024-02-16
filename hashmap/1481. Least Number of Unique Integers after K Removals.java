class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.get(arr[i])==null?1:map.get(arr[i])+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(Map.Entry e:map.entrySet()){
            pq.add((int)e.getValue());
        }
        int i=0;
        while(i<k){
            if(pq.peek()==1){
                pq.poll();
            }
            else{
                int temp=pq.poll();
                temp=temp-1;
                pq.add(temp);
            } 
            i++;
        }
        // System.out.println(pq);
        return pq.size();
    }
}