class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = left + 1;

        while (left != right) {
            if (right == numbers.length) {
                left++;
                right = left + 1;
            }

            if (numbers[left] + numbers[right] == target && numbers[left] < numbers[right]) {
                return new int[]{left + 1, right + 1};
            }

            right++;
        }

        return new int[]{};
    }
}
