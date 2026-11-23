class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotions = (success + spells[i] - 1) / spells[i];

            // find lower bound idx
            int l = 0;
            int r = potions.length;

            while(l<r){
                int m = l + (r-l)/2;

                if(potions[m] < minPotions){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
            res[i] = potions.length - l;
        }

        return res;
    }
}
