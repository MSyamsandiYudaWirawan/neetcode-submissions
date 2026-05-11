class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=0;
        int r=findMax(piles);
        int res = 0;
        while(l<=r){
            int k = (r-l)/2 +l;
            long totalTime = 0;
            for(int p:piles){
                totalTime += Math.ceil((double) p / k);
            }
            if(totalTime <= h){
                res = k;
                r = k - 1;
            }else {
                l = k + 1;
            }
        }
        return res;
    }
    private int findMax(int[] arr){
        int max = 0;
        for(int n:arr){
            if(max < n){
                max = n;
            }
        }
        return max;
    }
}
