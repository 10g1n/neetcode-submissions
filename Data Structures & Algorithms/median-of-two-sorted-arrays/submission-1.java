class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> combinedArray = new ArrayList<>();

        for (int num : nums1) {
            combinedArray.add(num);
        }

        for (int num : nums2) {
            combinedArray.add(num);
        }

        Collections.sort(combinedArray);

        int left = 0;
        int right = combinedArray.size() - 1;
        int mid = left + (right - left) / 2;

        if (combinedArray.size() % 2 != 0) {
            return (double) combinedArray.get(mid);
        } else {
            return (double) (combinedArray.get(mid) + combinedArray.get(mid + 1)) / 2;
        }
    }
}
