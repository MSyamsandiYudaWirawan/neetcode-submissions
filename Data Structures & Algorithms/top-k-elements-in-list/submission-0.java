
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of each element
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a List of Lists where the index represents the frequency
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>()); // Initialize each list
        }

        // Populate the List of Lists
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            freq.get(frequency).add(num);
        }

        // Step 3: Collect the top K frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = freq.size() - 1; i >= 0 && result.size() < k; i--) {
            for (int num : freq.get(i)) {
                result.add(num);
                if (result.size() == k) {
                    return result.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        // Convert result list to array and return
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
