class Solution {
    public int climbStairs(int n) {
        int[] dw = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            if (i <= 2) {
                dw[i] = i;
            } else {
                dw[i] = dw[i - 1] + dw[i - 2];
            }
        }
        
        return dw[n];
    }
}