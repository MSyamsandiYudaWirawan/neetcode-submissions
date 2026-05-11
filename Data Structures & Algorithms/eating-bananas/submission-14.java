class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = findMax(piles);
        int res = r;

        while(l<=r){
            int m = l + (r-l)/2;
            double time = 0.0;
            for(int p:piles){
                time = time + ((p + m - 1)/m);
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
    private int findMax(int[] n){
        int res = 0;
        for(int i=0; i<n.length; i++){
            if(n[i] > res){
                res = n[i];
            }
        }
        return res;
    }
}
