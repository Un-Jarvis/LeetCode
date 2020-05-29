/* 最优解：
 * openNum -> The number of open parentheses
 * closeNum -> The number of cloing parentheses
 * 
 * 用char[]记录每一个combination
 * 记录openNum和closeNum，按照index逐个添加/替换前括号和后括号
 * 保证最终openNum = closeNum
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        char[] combination = new char[2 * n];

        dfs(n, combination, 0, 0, 0, result);

        return result;
    }
    
    private void dfs(int n, char[] combination, int openNum, int closeNum, int index, List<String> result){
        if (closeNum == n) {
            result.add(new String(combination));
        } else {
            if (openNum < n) {
                combination[index] = '(';
                dfs(n, combination, openNum + 1, closeNum, index + 1, result);
            }
            if (closeNum < openNum) {
                combination[index] = ')';
                dfs(n, combination, openNum, closeNum + 1, index + 1, result);
            }
        }
    }
}

/* 逻辑同上，把char[] combination替换成了String combination，耗时增加 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        String combination = "";

        dfs(n, combination, 0, 0, 0, result);

        return result;
    }
    
    private void dfs(int n, String combination, int openNum, int closeNum, int index, List<String> result){
        if (closeNum == n) {
            result.add(combination);
        } else {
            if (openNum < n) {
                combination = combination.substring(0, index) + "(";
                dfs(n, combination, openNum + 1, closeNum, index + 1, result);
            }
            if (closeNum < openNum) {
                combination = combination.substring(0, index) + ")";
                dfs(n, combination, openNum, closeNum + 1, index + 1, result);
            }
        }
    }
}

/* 多了一个for loop，比上面的解更耗时 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(n, "", result, 0);

        return result;
    }

    private void dfs(int n, String combination, List<String> result, int pos) {
        if (n == 0) {
            result.add("");
        } else {
            if (combination.equals("")) combination = "()";        
            if (combination.length() == n * 2) {
                result.add(combination);
            } else if (combination.length() < n * 2) {
                for (int i = pos; i < combination.length(); i++) {
                    String newCombination = combination.substring(0, i) + "()" + combination.substring(i, combination.length());
                    dfs(n, newCombination, result, i + 1);
                }
            }
        }
    }
}

