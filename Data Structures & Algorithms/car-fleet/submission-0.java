class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Pair position and speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Step 2: Sort by position descending
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        // Step 3: Calculate time and simulate car fleets
        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // else, this car joins the fleet ahead and doesn't form a new fleet
        }

        return stack.size();
    }
}
