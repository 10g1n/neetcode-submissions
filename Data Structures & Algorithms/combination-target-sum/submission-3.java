class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        combinations(nums, 0, solution, target, result);

        return result;
    }

    private void combinations(int[] nums, int currStep, List<Integer> solution, int target, List<List<Integer>> result) {
        if (currStep == nums.length) {
            return;
        }

        solution.add(nums[currStep]);

        int sum = calcSum(solution);

        if (sum == target) {
            result.add(List.copyOf(solution));
            solution.removeLast();
            combinations(nums, currStep + 1, solution, target, result);
            return;
        }

        if (sum > target) {
            solution.removeLast();

            combinations(nums, currStep + 1, solution, target, result);

            return;
        }

        combinations(nums, currStep, solution, target, result);

        solution.removeLast();

        combinations(nums, currStep + 1, solution, target, result);
    }

    private int calcSum(List<Integer> list) {
        int sum = 0;

        for (Integer el : list) {
            sum += el;
        }

        return sum;
    }
}
