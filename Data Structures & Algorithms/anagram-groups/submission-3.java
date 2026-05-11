class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<String> list = new ArrayList<>();
       Map<String,List<String>> map = new HashMap<>();
       List<List<String>> result = new ArrayList<>();

       for(String str:strs){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);

        if(!map.containsKey(s)){
            map.put(s,new ArrayList<>());
        }
        map.get(s).add(str);
       }
       result.addAll(map.values());
       return result;

    }
}
