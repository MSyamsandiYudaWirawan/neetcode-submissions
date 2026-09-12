class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int res = 0;
        int totalDiff = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += (gas[i] - cost[i]);
            totalDiff += (gas[i] - cost[i]);

            if (tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }
        return totalDiff < 0 ? -1 : res;
    }
}
