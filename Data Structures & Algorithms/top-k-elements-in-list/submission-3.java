class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );
        for(int key:map.keySet()){
            queue.offer(key);
        }
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            result[i] = queue.poll();
        }

        return result;

    }
}
