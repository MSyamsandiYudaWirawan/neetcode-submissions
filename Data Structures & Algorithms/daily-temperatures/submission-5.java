class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] temp = stack.pop();
                res[temp[1]] = i - temp[1];
            }
            stack.add(new int[]{temperatures[i], i});
        }
        return res;
        
    }
}
