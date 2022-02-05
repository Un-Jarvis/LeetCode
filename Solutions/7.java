class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10) return x;
        
        int result = 0;
        
        while (x != 0) {
            // Check integer overflow/underflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
                return 0;
            }
            
            result = result * 10 + x % 10;
            x = x / 10;
        }
        
        return result;
    }
}