public class Solution {
    private List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();

        checkStr(s, 0, solution, result);

        return result;
    }

    private void checkStr(String input, int currStep, List<String> solution, List<List<String>> result) {
        if (currStep == input.length()) {
            result.add(List.copyOf(solution));

            return;
        }

        for (int end = currStep; end < input.length(); end++) {
            String substring = input.substring(currStep, end + 1);

            if (isPalindrome(substring)) {
                solution.add(substring);

                checkStr(input, end + 1, solution, result);

                solution.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}