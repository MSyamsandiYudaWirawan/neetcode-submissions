class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        record Pair(int val, int idx) {}
        Stack<Pair> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek().val) {
                Pair p = stack.pop();
                res[p.idx] = i - p.idx;
            }
            stack.push(new Pair(temp, i));
        }
        return res;
    }
}
