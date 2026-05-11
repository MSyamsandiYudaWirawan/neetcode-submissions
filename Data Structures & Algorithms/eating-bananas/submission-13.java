class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find the max piles for max k
        // loop 0..k find the minimum with binary search
        // find the minimum with if valid then lower k else increase k
        int l = 1;
        int r = findMax(piles);
        int res = r;
        while(l<=r){
            int m = l + (r-l)/2;
            long time = 0;

            for(int pile:piles){
                time = time + ((pile + m - 1)/m);
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
    private int findMax(int[] num){
        int res = 0;
        for(int i=0; i<num.length; i++){
            if(num[i] > res){
                res = num[i];
            }
        }
        return res;
    }
}
