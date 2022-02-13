class Solution {    
    public int addDigits(int num) {
		if (num == 0) return 0; 
		if (num % 9 == 0) return 9;
		return num % 9;
	}
}

class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        while (sum >= 10) {
            sum = addDigits(sum);
        }
        return sum;
    }
}