class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        double y = myPow(x, n / 2);
        
        if (n % 2 == 0) {
            return y * y;
        } else if (n % 2 == 1 && n > 0) {
            return y * y * x;
        } else { // if (n % 2 == 1 && n < 0)
            return y * y * 1 / x;
        }
    }

    // 错误：使用太多次 myPow(x, n / 2) 导致超时
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else if (n % 2 == 1 && n > 0) {
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
        } else { // if (n % 2 == 1 && n < 0)
            return myPow(x, n / 2) * myPow(x, n / 2) * 1 / x;
        }
    }
}
