class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        int left = 0;
        int right = len1;
        int half = (len1 + len2 + 1) / 2;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            int leftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int rightA = (i == len1) ? Integer.MAX_VALUE : nums1[i];

            int leftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int rightB = (j == len2) ? Integer.MAX_VALUE : nums2[j];

            if (leftA <= rightB && leftB <= rightA) {
                if ((len1 + len2) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            }

            if (leftA > leftB) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return 0.0;
    }
}
