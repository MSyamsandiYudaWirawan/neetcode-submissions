class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] temp_c = s.toCharArray();
            Arrays.sort(temp_c);
            String sortedS = new String(temp_c);
            map.computeIfAbsent(sortedS,k->new ArrayList<>()).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
