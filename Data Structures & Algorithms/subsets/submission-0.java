class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        result.add(new ArrayList<>());

        combinations(nums, 0, solution, result);

        return result;
    }

    private void combinations(int[] nums, int currStep, List<Integer> solution, List<List<Integer>> result) {
        if (currStep == nums.length) {
            return;
        }

        solution.add(nums[currStep]);

        combinations(nums, currStep + 1, solution, result);

        result.add(List.copyOf(solution));

        solution.remove(Integer.valueOf(nums[currStep]));

        combinations(nums, currStep + 1, solution, result);
    }
}
 