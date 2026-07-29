class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = maxElArr(piles);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinishWithinH(mid, piles, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinishWithinH(int k, int[] piles, int h) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }

        return totalHours <= h;
    }

    private int minElArr(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int j : arr) {
            min = Math.min(min, j);
        }

        return min;
    }

    private int maxElArr(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int j : arr) {
            max = Math.max(max, j);
        }

        return max;
    }
}
