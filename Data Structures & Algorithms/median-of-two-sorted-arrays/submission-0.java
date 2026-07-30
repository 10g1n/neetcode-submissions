class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        TreeSet<Integer> combinedArray = new TreeSet<>();

        for (int num : nums1) {
            combinedArray.add(num);
        }

        for (int num : nums2) {
            combinedArray.add(num);
        }

        List<Integer> arr = new ArrayList<>((combinedArray));

        int left = 0;
        int right = combinedArray.size() - 1;
        int mid = left + (right - left) / 2;

        if (combinedArray.size() % 2 != 0) {
            return (double) arr.get(mid);
        } else {
            return (double) (arr.get(mid) + arr.get(mid + 1)) / 2;
        }
    }
}
