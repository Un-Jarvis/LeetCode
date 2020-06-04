/*
 * Anagrams -> All permutations of a given string
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        
        if (s.length() < p.length()) return result;
        
        int[] pRep = new int[26]; // Represention for p
        int[] sRep = new int[26]; // Represention for n characters of s where n is the length of p
        
        for (int i = 0; i < p.length(); i++) {
            pRep[p.charAt(i) - 'a']++;
            sRep[s.charAt(i) - 'a']++;
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            // If p is an anagram of n characters of s, add index
            if (Arrays.equals(pRep, sRep)) result.add(i - p.length());

            // Decrement the least recent character count in sRep
            sRep[s.charAt(i - p.length()) - 'a']--;
            // Increment the next character count in sRep
            sRep[s.charAt(i) - 'a']++;
        }

        // Final n characters string check
        if (Arrays.equals(pRep, sRep)) result.add(s.length() - p.length());
            
        return result;
    }
}

/*
 * 超时
 * Time Complexity = O(n^m) where m = p.length and n = s.length
 * input过长时会超时
 */
// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> result = new ArrayList<>();

//         if (s.length() < p.length()) return result;

//         for (int i = 0; i <= s.length() - p.length(); i++) {
//             if (isAnagram(p, s.substring(i, i + p.length()))) result.add(i);
//         }

//         return result;
//     }

//     private boolean isAnagram(String s, String p) {
//         if (s.equals(p)) return true;
//         boolean isAnagram = true;
//         for (int j = 0; j < s.length(); j++) {
//             int index = p.indexOf(s.charAt(j));
//             if (index < 0) {
//                 isAnagram = false;
//             } else {
//                 p = p.substring(0, index) + p.substring(index + 1, p.length());
//             }
//         }
//         return isAnagram;
//     }
// }