class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.merge(n, 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );

        for(int key:map.keySet()){
            pq.add(key);
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
