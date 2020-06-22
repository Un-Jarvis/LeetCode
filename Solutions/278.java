/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, mid = 0, right = n;
        int version = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
                version = mid;
            } else {
                left = mid + 1;
            }
        }

        return version;
    }
}