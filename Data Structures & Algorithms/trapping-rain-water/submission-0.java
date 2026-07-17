class Solution {
    public int trap(int[] height) {
        int maxLevel = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = calcLeftMax(height, i);
            int rightMax = calcRightMax(height, i);

            int waterLevel = Math.min(leftMax, rightMax) - height[i];

            if (waterLevel > 0) {
                maxLevel += waterLevel;
            }
        }

        return maxLevel;
    }

    public int calcLeftMax(int[] height, int index) {
        int max = 0;

        for (int i = 0; i < index; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }

    public int calcRightMax(int[] height, int index) {
        int max = 0;

        for (int i = index; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }
}
