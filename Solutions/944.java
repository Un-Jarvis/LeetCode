class Solution {
    public int minDeletionSize (String[] A) {
        // Corner case
        if (A == null || A.length == 0 || A[0].length() == 0) return 0;

        int count = 0;
        // For each column
        for (int i = 0; i < A[0].length(); i++) {
            // For each string
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}