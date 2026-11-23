class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];

            int l = 0;
            int r = potions.length;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (minPotion > potions[mid]) {
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            res[i] = potions.length - l;
        }
        return res;
    }
}
