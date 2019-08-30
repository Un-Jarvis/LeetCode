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

// 第n阶台阶是通过n-1或n-2阶台阶爬上去的
// 但是不能直接 return climbStairs(n - 1) + climbStairs(n - 2); 存在大量重复运算会超时
