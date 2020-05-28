class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || k <= 0 || n < k) return result;

        dfs(n, k, 1, new ArrayList<>(), result);
        
        return result;
    }

    private void dfs(int n, int k, int pos, List<Integer> combination, List<List<Integer>> result) {
        /*
         * k is the size of a combination.
         * If the combination has a size of k, add it to the result list.
         */
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = pos; i <= n; i++) {
                combination.add(i);
                dfs(n, k, i + 1, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
