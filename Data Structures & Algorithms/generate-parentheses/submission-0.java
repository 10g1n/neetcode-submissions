class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();

        char[] input = {'(', ')'};

        generate(n, 0, solution, input, new StringBuilder(), 0, 0);

        return solution;
    }

    private void generate(int n, int currStep, List<String> solution, char[] input, StringBuilder sb, int openCount, int closedCount) {
        if (currStep == 2 * n) {
            solution.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append(input[0]);
            generate(n, currStep + 1, solution, input, sb, openCount + 1, closedCount);
            sb.deleteCharAt(currStep);
        }

        if (closedCount < openCount) {
            sb.append(input[1]);
            generate(n, currStep + 1, solution, input, sb, openCount, closedCount + 1);
            sb.deleteCharAt(currStep);
        }
    }
}
