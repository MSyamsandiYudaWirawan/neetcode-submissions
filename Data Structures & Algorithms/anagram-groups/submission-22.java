class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);
            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());

        
    }
}
