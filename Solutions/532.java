    public int findPairs(int[] nums, int k) {
        int numOfPairs = 0;
        Set<Integer> set = new HashSet<>();
        
        if (k == 0) {
            Set<Integer> repeated = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) repeated.add(nums[i]);
                set.add(nums[i]);
            }
            numOfPairs = repeated.size();
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i]) && set.contains(nums[i] + k)) numOfPairs++;
                if (!set.contains(nums[i]) && set.contains(nums[i] - k)) numOfPairs++;
                set.add(nums[i]);
            }
        }
        
        return numOfPairs;
    }
}

/* 超时 */
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Set<Integer>> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Create a set for nums[i] if it does not exist
            if (!pairs.containsKey(nums[i])) {
                pairs.put(nums[i], new HashSet<>());
            }
            // Get the set for nums[i]
            Set<Integer> set = pairs.get(nums[i]);
            for (int j = 0; j < nums.length; j++) {
                /* 
                 * j != i: a value cannot pair itself
                 * !set.contains(nums[j]): look only for unique pairs
                 * nums[j] - nums[i] == k: k-diff pairs
                 */
                if (j != i && !set.contains(nums[j]) && nums[j] - nums[i] == k) {
                    set.add(nums[j]);
                }
            }
        }
        int numOfPairs = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : pairs.entrySet()) {
            numOfPairs += entry.getValue().size();
        }
        return numOfPairs;
    }
}