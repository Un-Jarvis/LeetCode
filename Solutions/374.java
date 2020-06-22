/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1, mid = 1, max = n;

        while (min <= max) {
            mid = min + (max - min) / 2;

            if (guess(mid) > 0) min = mid + 1;
            else if (guess(mid) < 0) max = mid - 1;
            else return mid; 
        }

        return mid;
    }
}