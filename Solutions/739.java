/* Solution 1: Dynamic Programming */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) { /* Higher temp is right after one day */
                answer[i] = 1;
            } else if (answer[i + 1] == 0) { /* Next day will be colder but no higher temp in the future */
                answer[i] = 0;
            } else { /* Next day will be colder but we don't know if there is a higher temp day */
                answer[i] = 1;
                
                int j = i + 1;
                /* Keep looking for a future day with higher temp such that temperatures[i] < temperatures[j] */
                /* Loop until either such day is found or there is no higher temp */
                while (answer[j] > 0 && temperatures[i] >= temperatures[j]) {
                    answer[i] += answer[j];
                    j += answer[j];
                }
                
                if (answer[j] == 0 && temperatures[i] >= temperatures[j]) {
                    answer[i] = 0;
                }
            }
        }
        
        return answer;
    }
}