class MedianFinder {

    private PriorityQueue<Integer> leftHalf = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    private PriorityQueue<Integer> rightHalf = new PriorityQueue<>(); // min heap

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (leftHalf.isEmpty() && rightHalf.isEmpty()) {
            leftHalf.add(num);
        } else {
            if (!leftHalf.isEmpty()) {
                if (num <= leftHalf.peek()) {
                    leftHalf.add(num);
                } else {
                    rightHalf.add(num);
                }
            }
        }

        while (Math.abs(leftHalf.size() - rightHalf.size()) > 1) {
            if (leftHalf.size() > rightHalf.size()) {
                rightHalf.add(leftHalf.poll());
            }

            if (rightHalf.size() > leftHalf.size()) {
                leftHalf.add(rightHalf.poll());
            }
        }
    }

    public double findMedian() {
        if (!leftHalf.isEmpty() && !rightHalf.isEmpty()) {
            if ((leftHalf.size() + rightHalf.size()) % 2 != 0) {
                if ((leftHalf.size() - rightHalf.size()) == 1) {
                    return leftHalf.peek();
                } else {
                    return rightHalf.peek();
                }
            } else {
                return (leftHalf.peek() + rightHalf.peek()) / 2.0;
            }
        }

        return leftHalf.peek();
    }
}
