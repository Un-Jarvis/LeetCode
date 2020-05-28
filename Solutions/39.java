/* 
 * 最优解：
 * 1. 判断每一个candidate是否等于target
 * 2. 如果小于target，则通过(target - candidates[i])来判断下一个组合的值 
 * 3. pos保证可以重复选用同一个candidate，并且不和之前的candidate重复
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Stack<Integer> combination = new Stack<>();

        dfs(candidates, target, combination, result, 0);

        return result;
    }

    private void dfs(int[] candidates, int target, Stack<Integer> combination, List<List<Integer>> result, int pos) {
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] == target) {
                combination.push(candidates[i]);
                result.add(new ArrayList<>(combination));
                combination.pop();
            } else if (candidates[i] < target) {
                combination.push(candidates[i]);
                dfs(candidates, target - candidates[i], combination, result, i);
                combination.pop();
            }
        }
    }
}

/*
 * 复杂解：
 * 1. 比较target和combination的总和 
 * 2. 判断duplicate
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates.length == 0) return result;

        dfs(candidates, target, new ArrayList<Integer>(), result);

        return result;
    }

    public void dfs(int[] candidates, int target, List<Integer> combination, List<List<Integer>> result) {
        if (getSumOfList(combination) == target && !hasDuplicate(combination, result)) {
            result.add(new ArrayList<>(combination));
        } else if (getSumOfList(combination) < target) {
            for (int i = 0; i < candidates.length; i++) {
                combination.add(candidates[i]);
                dfs(candidates, target, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    } 

    public int getSumOfList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public boolean hasDuplicate(List<Integer> combination, List<List<Integer>> result) {
        boolean hasDuplicate = false;
        for (int i = 0; i < result.size(); i++) {
            List<Integer> copy = new ArrayList<>(combination);
            if (result.get(i).size() == copy.size()) {
                for (int j = 0; j < result.get(i).size(); j++) {
                    copy.remove(result.get(i).get(j));
                }

                if (copy.size() == 0) hasDuplicate = true;
            }
        }
        return hasDuplicate;
    }
}

