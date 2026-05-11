class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>  map = new HashMap<>();
        int[] result = new int[k];

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b)-> map.get(b) - map.get(a)
        );

        for(int n:map.keySet()){
            heap.offer(n);
        }
        for(int i=0; i<k; i++){
            result[i]=heap.poll();
        }
        return result;
    }
}
