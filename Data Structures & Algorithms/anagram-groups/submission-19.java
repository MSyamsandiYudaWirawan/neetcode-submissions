class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String sortedS = new String(carr);
            if(!map.containsKey(sortedS)){
                map.put(sortedS, new ArrayList<>());
            }
            map.get(sortedS).add(str);
        }
        return new ArrayList<>(map.values());

    }
}
