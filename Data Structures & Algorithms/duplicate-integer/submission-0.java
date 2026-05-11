class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean res = false;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res = true;
                }
            }
        }
        return res;
    }
}
