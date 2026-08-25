class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        List<Integer> solution = new ArrayList<>();

        combinations(nums, 0, result, solution);

        return result;
    }

    private void combinations(int[] nums, int currStep, List<List<Integer>> result, List<Integer> solution) {
        if (currStep == nums.length) {
            return;
        }

        for (int i = currStep; i < nums.length; i++) {
            if (i > currStep && nums[i] == nums[i - 1]) {
                continue;
            }

            solution.add(nums[i]);

            combinations(nums, i + 1, result, solution);

            result.add(List.copyOf(solution));

            solution.removeLast();
        }
    }
}
