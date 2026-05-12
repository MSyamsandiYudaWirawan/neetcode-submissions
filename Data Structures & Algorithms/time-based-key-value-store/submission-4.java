class TimeMap {
    private static class Pair{
        int timestamp;
        String value;

        private Pair(int t, String v){
            this.timestamp = t;
            this.value = v;
        }
    }

    private Map<String,List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null || list.size() == 0){
            return "";
        }

        int l = 0;
        int r = list.size() - 1;
        String res = "";

        while(l<=r){
            int m = l + (r-l)/2;
            if(list.get(m).timestamp == timestamp){
                return list.get(m).value;
            }
            if(list.get(m).timestamp <= timestamp){
                //valid 
                res = list.get(m).value;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }
}
