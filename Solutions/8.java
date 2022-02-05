class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        int index = 0;
        int posOrNeg = 1;
        
        // Remove leading space
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        // Read +/- sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            posOrNeg = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        // Read chars
        boolean outOfBounds = false;
        int digit = 0;
        while (!outOfBounds && index < s.length() && toDigit(s.charAt(index)) >= 0) {
            // Get the next digit
            digit = toDigit(s.charAt(index));
            
            // Check integer overflow/underflow
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) outOfBounds = true;
            
            // Calculate new result
            res = res * 10 + digit;
            index++;
        }
        
        if (outOfBounds) {
            return posOrNeg > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return res * posOrNeg;
    }
    
    private int toDigit(char c) {
        // The result of char - '0' is the corresponding int value
        return (c >= '0' && c <='9') ? c - '0' : -1;
    }
}