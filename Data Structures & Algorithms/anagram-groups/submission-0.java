class Solution {
    // This method returns a list of lists of strings, where each list contains anagrams.
    public List<List<String>> groupAnagrams(String[] strs) {
        // A HashMap to store grouped anagrams. The key is a string that represents
        // a signature of character counts, and the value is a list of anagrams with that signature.
        Map<String, List<String>> ans = new HashMap<>();

        // Loop through each string in the input array.
        for (String s : strs) {
            // Create an array to count the frequency of each character (only lowercase letters).
            // The array index represents the character, and the value represents its frequency.
            int[] count = new int[26];

            // Loop through each character in the string.
            for (char c : s.toCharArray()) {
                // Increment the frequency count for the character.
                count[c - 'a']++;
            }

            // Convert the frequency array to a string key to use in the HashMap.
            // This key uniquely identifies the group of anagrams.
            String key = Arrays.toString(count);

            // If the key is not already in the map, add it with an empty list.
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }

            // Add the original string to the list associated with the key.
            ans.get(key).add(s);
        }

        // Return all the grouped anagrams as a list of lists.
        return new ArrayList<>(ans.values());
    }
}
