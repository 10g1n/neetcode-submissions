class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] solution = new int[nums.length];

        permutations(nums, 0, solution, result);

        return result;
    }

    private void permutations(int[] nums, int currStep, int[] solution, List<List<Integer>> result) {
        if (currStep == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : solution) {
                permutation.add(num);
            }

            result.add(permutation);
            return;
        }


        for (int j = 0; j < nums.length; j++) {
            boolean ok = true;

            for (int i = 0; i < currStep; i++) {
                if (solution[i] == nums[j]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                solution[currStep] = nums[j];
                permutations(nums, currStep + 1, solution, result);
            }
        }
    }
}
