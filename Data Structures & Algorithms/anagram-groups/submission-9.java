class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] c_arr = s.toCharArray();
            Arrays.sort(c_arr);
            String key = new String(c_arr);

            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                map.put(key,new ArrayList<>(Arrays.asList(s)));
            }
        }
        return new ArrayList<>(map.values());
     }
}
