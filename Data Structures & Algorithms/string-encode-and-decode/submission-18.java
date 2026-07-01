class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            String lenStr = str.substring(i,j);
            int len = Integer.parseInt(lenStr);
            i=j+1;
            String s = str.substring(i,i+len);
            i = i + len;
            res.add(s);
        }
        return res;
    }
}
