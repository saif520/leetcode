class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(
            (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]
        );
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }
        Set<Integer> set=new HashSet<>();
        long score=0;
        while(!pq.isEmpty()&&set.size()!=nums.length){
            int[] top=pq.poll();
            if(set.contains(top[1])){
                continue;
            }
            score+=top[0];
            if(top[1]-1>=0){
                set.add(top[1]-1);
            }
            if(top[1]+1<nums.length){
                set.add(top[1]+1);
            }
        }
        return score;
    }
}