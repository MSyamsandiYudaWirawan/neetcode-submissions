class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );
        for(int n:map.keySet()){
            queue.offer(n);
        }
        
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
