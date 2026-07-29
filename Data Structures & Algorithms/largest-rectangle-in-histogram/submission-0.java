class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> heightIndexes = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!heightIndexes.isEmpty() && heights[heightIndexes.peek()] > heights[i]) {
                int height = heights[heightIndexes.pop()];
                int leftBound = heightIndexes.isEmpty() ? -1 : heightIndexes.peek();

                int width = i - leftBound - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            heightIndexes.push(i);
        }

        while (!heightIndexes.isEmpty()) {
            int height = heights[heightIndexes.pop()];
            int left = heightIndexes.isEmpty() ? -1 : heightIndexes.peek();
            int width = heights.length - left - 1;

            maxArea = Math.max(maxArea, height * width);
        }


        return maxArea;
    }
}
