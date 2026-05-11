class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find max piles for max k 
        // e.g max k = 4 loop=1,2,3,4
        // use binary search
        // calclate time to finish all the pile
        // if valid shift left
        // if not valid shift right
        int l = 1;
        int r = maxPiles(piles);
        int res = r;
        while(l<=r){
            int m = (r-l)/2 + l;
            long time = 0;
            for(int p:piles){
                time += (p+m-1)/m;
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
