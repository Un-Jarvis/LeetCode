/*
 * m = strLength, n = strCount
 * Time Complexity: O(m * n)
 * 
 * Compare to ajacent strings.
 * boolean[] rank is used to record the rank previous characters in a string.
 * 
 * Reference: https://www.youtube.com/watch?v=AtzATu9SrUc
 */

class Solution {
    
    public int minDeletionSize (String[] A) {
        int strCount = A.length;
        int strLength = A[0].length();

        boolean[] rank = new boolean[strCount];

        int count = 0;

        // For each position of a string
        for (int i = 0; i < strLength; i++) {
            boolean breakLoop = false;
            // For each string
            for (int j = 1; j < strCount; j++) {
                if (rank[j]) continue;
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    count++;
                    breakLoop = true;
                    break;
                }
            }

            // Update the rank if the current column is not removed
            if (!breakLoop) {
                for (int j = 1; j < strCount; j++) {
                    if (!rank[j] && A[j - 1].charAt(i) < A[j].charAt(i)) rank[j] = true;
                }
            }
        }

        return count;
    }

}