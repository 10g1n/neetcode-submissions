class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = calcProduct(nums, i);
        }

        return result;
    }

    public int calcProduct(int[] arr, int index) {
        int product = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i == index) continue;
            product *= arr[i];
        }
        return product;
    }
}
