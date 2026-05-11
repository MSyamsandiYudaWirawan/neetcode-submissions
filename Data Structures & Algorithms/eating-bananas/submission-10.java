class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = maxPiles(piles);
        int res = r;
        while(l<=r){
            int m = (r-l)/2 + l;
            long time = 0;
            for(int p:piles){
                time += Math.ceil((double)p/m); 
            }
            if(time <= h){
                res = Math.min(res,m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return res;
    }
    private int maxPiles(int[] piles){
        int res = piles[0];
        for(int p:piles){
            if(res < p){
                res = p;
            }
        }
        return res;
    }
}
