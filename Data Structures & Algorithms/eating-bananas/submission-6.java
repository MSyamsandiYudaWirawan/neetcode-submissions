class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = getMaxPiles(piles);
        int min = r;
        while(l<=r){
            int m = (r-l)/2 + l;
            int time = 0;
            for(int p:piles){
                time += Math.ceil((double)p/m);
            }
            if(time <= h){
                min = Math.min(min,m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return min;

    }
    private int getMaxPiles(int[] piles){
        int max = piles[0];
        for(int n:piles){
            if(max < n){
                max = n;
            }
        }
        return max;
    }
}
