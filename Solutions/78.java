/* BFS解法 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());

        for (int num : nums) {
            int resultSize = results.size();
            for (int i = 0; i < resultSize; i++) {
                List<Integer> subset = new ArrayList<>(results.get(i));
                subset.add(num);
                results.add(subset);
            }            
        }
        return results;
    }
}

/* DFS解法 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(nums, 0, new ArrayList<Integer>(), results);

        return results;
    }

    private void dfs(int[] nums, int pos, List<Integer> subset, List<List<Integer>> results) {
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
        results.add(new ArrayList<>(subset));
    }
}

/* 
 * 关于List的注意点：
 * List<List<Integer>> results = new ArrayList<>();
 * List<Integer> subset = new ArrayList<>();
 * 
 * results.add(subset); // 此时results = [[]]
 * subset.add(1); // 此时results = [[1]]
 * // Variable subset和results.get(0)指向同一个object，所以改变subset的值也会改变results中的值
 */