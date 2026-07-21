class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        int left = 0;
        int right = 0;

        List<Integer> res = new ArrayList<>();

        while (right < nums.length) {
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);

            if (k <= right - left + 1) {
                res.add(deque.peekFirst());

                if (deque.peekFirst() == nums[left++]) {
                    deque.pollFirst();
                }
            }
            right++;
        }

        int[] resArr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;   
    }
}
