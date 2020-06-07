/* 用 (x / root) 判断大小 */
class Solution {
    public int mySqrt(int x) {
        int min = 0, root = 0, max = x;

        if (x == 0) return 0;
        if (x == 1) return 1;

        while (max - min > 1) {
            root = (min + max) / 2;

            if (root == x / root) {
                return root;
            } else if (root < x / root) {
                min = root;
            } else if (root > x / root) {
                max = root;
            }
        }

        root = min;

        return root;
    }
}

/* 用 (root ^ 2) 判断大小，需要处理超过max int的x值，可以用long */
class Solution {
    public int mySqrt(int x) {
        int min = 0, root = 0, max = x;

        if (x == 0) return 0;
        if (x == 1) return 1;

        while (max - min > 1) {
            root = (min + max) / 2;

            int square = root * root;
            if (square == x) {
                return root;
            } else if (square < x && root <= 46340) {
                min = root;
            } else if (square > x || root > 46340) {
                max = root;
            }
        }

        root = min;

        return root;
    }
}