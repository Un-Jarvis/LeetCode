/* 
 * 类似#39
 * sort candidates之后通过candidates[i] == candidates[i - 1])排除相邻的两个相同的candidate来避免duplicate
 * 由于不能重复使用同一candidate，recursion中的pos要+1移动到下一个candidate
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        Stack<Integer> combination = new Stack<>();

        dfs(candidates, target, combination, result, 0);

        return result;
    }

    private void dfs(int[] candidates, int target, Stack<Integer> combination, List<List<Integer>> result, int pos) {
        for (int i = pos; i < candidates.length; i++) {
            if (!(i > pos && candidates[i] == candidates[i - 1])) {
                if (candidates[i] == target) {
                    combination.push(candidates[i]);
                    result.add(new ArrayList<>(combination));
                    combination.pop();
                } else if (candidates[i] < target) {
                    combination.push(candidates[i]);
                    dfs(candidates, target - candidates[i], combination, result, i + 1);
                    combination.pop();
                }
            }
        }
    }
}