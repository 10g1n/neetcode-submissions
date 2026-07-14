class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = calcFreq(nums);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public HashMap<Integer, Integer> calcFreq(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return map;
    }
}
