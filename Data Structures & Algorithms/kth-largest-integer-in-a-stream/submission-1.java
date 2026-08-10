class KthLargest {
    private int k;

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        if (!minHeap.isEmpty()) {
            return minHeap.peek();
        }

        return -1;
    }
}
