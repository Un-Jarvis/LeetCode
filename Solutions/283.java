/* 将每一个非0的值依次放入数组前端，然后把原位置改为0 */
class Solution {
    public void moveZeroes(int[] nums) {
        // nonZeroIndex为所有非零数的index，i为数组当前的index
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }
}

/* 憨憨解法 */
class Solution {
    public void moveZeroes(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newNums[index] = nums[i];
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}