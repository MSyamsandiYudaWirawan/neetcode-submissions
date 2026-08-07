class Solution {
    Map<String, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        List<String> data = new ArrayList<>();
        for (String d : digits.split("")) {
            data.add(map.get(d));
        }
        StringBuilder sb = new StringBuilder();
        dfs(data, sb, 0);
        return res;
    }
    private void dfs(List<String> data, StringBuilder sb, int idx) {
        if (data.size() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        String letter = data.get(idx);

        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            dfs(data, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
