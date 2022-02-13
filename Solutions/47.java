class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result, new HashSet<Integer>());
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result, Set<Integer> indexSet) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        } else {
            Set<Integer> valueSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!indexSet.contains(i) && !valueSet.contains(nums[i])) {
                    permutation.add(nums[i]);
                    indexSet.add(i);
                    dfs(nums, permutation, result, indexSet);
                    permutation.remove(permutation.size() - 1);
                    indexSet.remove(i);
                    valueSet.add(nums[i]);
                }
            }
        }
    }
}