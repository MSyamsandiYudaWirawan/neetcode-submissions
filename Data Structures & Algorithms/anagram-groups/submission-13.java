class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] c_arr = str.toCharArray();
            Arrays.sort(c_arr);
            String s = new String(c_arr);

            map.computeIfAbsent(s,(k) -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());

     }
}
