class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if ((i == 0 || dp[i - 1]) && wordDict.contains(s.substring(i, j + 1))) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}

/*
 * 粗暴解法
 * 超时
 */
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if (wordDict.contains(s)) return true;
        
//         int i = 1;
//         while (i < s.length()) {
//             if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()), wordDict)) {
//                 return true;
//             } else {
//                 i++;
//             }
//         }
        
//         return false;
//     }