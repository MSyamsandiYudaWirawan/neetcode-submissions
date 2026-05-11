class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int cars[][] = new int[n][2];
        Stack<Double> stack = new Stack<>();

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);
        for(int[] car:cars){
            Double time = (double) (target - car[0])/car[1];
            //check if prev car is slower than current if it is continue
            if(!stack.isEmpty() && stack.peek() >= time){
                continue;
            } 
            //else new car fleet
            stack.push(time);
        }
        return stack.size();
        
    }
}
