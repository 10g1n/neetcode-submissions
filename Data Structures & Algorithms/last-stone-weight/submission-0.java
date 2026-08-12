class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones) {
            maxHeap.add(stone);
        }

        while (!maxHeap.isEmpty() && maxHeap.size() != 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 < stone2) {
                stone2 -= stone1;
                maxHeap.add(stone2);
            }

            if (stone1 > stone2) {
                stone1 -= stone2;
                maxHeap.add(stone1);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
