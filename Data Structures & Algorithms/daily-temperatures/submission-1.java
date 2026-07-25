class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> waitingTemps = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!waitingTemps.isEmpty() &&(temperatures[waitingTemps.peek()] < temperatures[i])) {
                result[waitingTemps.peek()] = i - waitingTemps.peek();
                waitingTemps.pop();
            }

            waitingTemps.push(i);
        }

        return result;
    }
}
