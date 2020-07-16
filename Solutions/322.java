class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return dfs(coins, amount, dp);
    }

    private int dfs(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (dp[amount] != 0) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int num = dfs(coins, amount - coin, dp);
                if (num != -1) {
                    min = Math.min(min, num + 1);
                }
            }
        }

        if (min == Integer.MAX_VALUE) dp[amount] = -1;
        else dp[amount] = min;

        return dp[amount];
    }
}