/*
 * Binary Search Tree - logarithmic time complexity
 */
class Solution {
    public int hIndex(int[] citations) {
        int left = 0, mid = 0, right = citations.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else if (citations[mid] > citations.length - mid) {
                right = mid - 1;
            } else {
                return citations.length - mid;
            }
        }
        return citations.length - left;
    }
}

/*
 * 粗暴解法
 */
class Solution {
    public int hIndex(int[] citations) {
        int h = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[citations.length - 1 - i] >= i + 1) h++;
            else return h;
        }
        
        return h;
    }
}