class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted_s = new String(arr);
            if(!map.containsKey(sorted_s)){
                map.put(sorted_s, new ArrayList<>());
            }
            map.get(sorted_s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
