class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int totalDiff = 0;
        int lastValidIdx = 0;

        int i = 0;
        while (i < gas.length) {
            int diff = gas[i] - cost[i];
            tank += diff;
            totalDiff += diff;
            // not valid restart from 0
            if (tank < 0) {
                tank = 0;
                lastValidIdx = i + 1;
            }
            i++;
        }
        return totalDiff < 0 ? -1 : lastValidIdx;
    }
}
