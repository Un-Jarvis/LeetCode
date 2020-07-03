class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0 || k <= 0) return result;

        int left = 0, right = arr.length - 1;

        // 如果x不在arr范围内，则返回arr中最左/最右的k个值
        if (arr[left] > x) return subarrayToList(arr, left, left + k - 1);
        if (arr[right] < x) return subarrayToList(arr, right - k + 1, right);

        while (right - left >= k) {
            // 比较两个顶点与x的绝对值
            if (Math.abs(x - arr[left]) > Math.abs(arr[right] - x)) left++;
            else right--;
        }
        
        return subarrayToList(arr, left, right);
    }

    public List<Integer> subarrayToList(int[] arr, int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}