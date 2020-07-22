class Solution {
    private Map<Character, String> map;

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        map = buildMap();

        letterCombination(digits, 0, "", result);

        return result;
    }

    public Map<Character, String> buildMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public void letterCombination(String digits, int index, String str, List<String> list) {
        if (index == digits.length()) list.add(str);

        if (digits.length() != 0 && digits.length() > index) {
            for (char c : map.get(digits.charAt(index)).toCharArray()) {
                letterCombination(digits, index + 1, str + c, list);
            }
        }
    }
}