class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        Stack<Integer> combination = new Stack<>();

        dfs(k, n, combination, result, 1);

        return result;
    }

    private void dfs(int k, int n, Stack<Integer> combination, List<List<Integer>> result, int pos) {
        for (int i = pos; i <= 9; i++) {
            if (k == 1 && i == n) {
                combination.push(i);
                result.add(new ArrayList<>(combination));
                combination.pop();
            }
            if (i < n) {
                combination.push(i);
                dfs(k - 1, n - i, combination, result, i + 1);
                combination.pop();
            }
        }
    }
}