class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        combinations(candidates, 0, solution, target, result);

        return result;
    }

    private void combinations(int[] nums, int currStep, List<Integer> solution, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(solution));
            return;
        }

        for (int i = currStep; i < nums.length; i++) {
            if (i > currStep && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            solution.add(nums[i]);

            combinations(nums, i+1, solution, target - nums[i], result);

            solution.remove(Integer.valueOf(nums[i]));
        }
    }
}
