class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;

        List<Integer> result = new ArrayList<>();

        for (int right = k; right <= nums.length; right++) {
            int[] arr = Arrays.copyOfRange(nums, left, right);

            int currMax = findMax(arr);

            result.add(currMax);
            left++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
