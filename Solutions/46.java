/* 使用boolean array记录每一个num是否已经存在permutation中，排除duplicates */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        dfs(nums, visited, new ArrayList<Integer>(), results);

        return results;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    permutation.add(nums[i]);
                    visited[i] = true;
                    dfs(nums, visited, permutation, results);
                    permutation.remove(permutation.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}

/* 逻辑同上，使用ArrayList.contains来排除duplicates，但是contains method的运行时间为O(n)，更加耗时 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(nums, new ArrayList<Integer>(), results);

        return results;
    }

    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!permutation.contains(nums[i])) {
                    permutation.add(nums[i]);
                    dfs(nums, permutation, results);
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}