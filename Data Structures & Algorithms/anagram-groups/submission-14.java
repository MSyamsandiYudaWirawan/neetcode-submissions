class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedS = new String(arr);

            if(!map.containsKey(sortedS)){
                map.put(sortedS, new ArrayList<>());
            }
            map.get(sortedS).add(s);
            
        }
        return new ArrayList<>(map.values());
    }
}
