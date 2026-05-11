class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<>();

       for(String str:strs){
        char[] c_arr = str.toCharArray();
        Arrays.sort(c_arr);
        String sKey = new String(c_arr);
        
        if(map.containsKey(sKey)){
            map.get(sKey).add(str);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(sKey,list);
        }
       } 
       return new ArrayList<List<String>>(map.values());

    }
}
