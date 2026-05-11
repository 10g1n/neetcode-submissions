class Solution {
    public boolean hasDuplicate(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}