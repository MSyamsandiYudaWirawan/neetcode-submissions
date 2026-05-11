class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = findMax(piles);
        int res = r;
        while(l<=r){
            int k = (r-l)/2 + l;
            long time = 0;
            for(int p:piles){
                time += Math.ceil((double) p / k);
            }
            if(time <= h){
                res = Math.min(res,k);
                r = k - 1;
            }else {
                l = k + 1;
            }
        }
        return res;

        
    }
    private int findMax(int[] piles){
        int max = piles[0];
        for(int p:piles){
            if(max < p){
                max = p;
            }
        }
        return max;
    }
}
