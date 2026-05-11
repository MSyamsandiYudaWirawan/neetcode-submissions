class TimeMap {

    private Map<String,List<Pair>> map;

    private static class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null){
            return "";
        }
        int l=0;
        int r = list.size() - 1;
        String result = "";
        while(l<=r){
            int m = (r-l)/2 + l;
            if(list.get(m).timestamp <= timestamp){
                result = list.get(m).value;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return result;
    }
}
