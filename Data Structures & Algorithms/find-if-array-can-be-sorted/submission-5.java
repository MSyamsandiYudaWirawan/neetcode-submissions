class Solution {
    public boolean canSortArray(int[] nums) {
        int groupMax = 0;
        int prevMax = 0;
        int prevBits = -1;

        for(int x:nums){
            int bits = Integer.bitCount(x);

            if(bits != prevBits){
                //close group
                prevMax = Math.max(prevMax,groupMax);
                // new group
                groupMax = x;
                prevBits = bits;
            }
            else{
                groupMax = Math.max(groupMax,x);
            }

            if(x < prevMax){
                return false;
            }
        }
        return true;
    }
}
