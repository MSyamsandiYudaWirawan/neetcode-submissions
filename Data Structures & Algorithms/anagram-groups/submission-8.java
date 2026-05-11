class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String sortedS = new String(s);

            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
