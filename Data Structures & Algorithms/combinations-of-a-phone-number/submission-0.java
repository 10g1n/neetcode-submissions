class Solution {
    private HashMap<Character, List<String>> data = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        data.put('2', List.of("a", "b", "c"));
        data.put('3', List.of("d", "e", "f"));
        data.put('4', List.of("g", "h", "i"));
        data.put('5', List.of("j", "k", "l"));
        data.put('6', List.of("m", "n", "o"));
        data.put('7', List.of("p", "q", "r", "s"));
        data.put('8', List.of("t", "u", "v"));
        data.put('9', List.of("w", "x", "y", "z"));

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> solution = new ArrayList<>();

        combinations(digits, 0, solution, new StringBuilder());

        return solution;
    }

    private void combinations(String digits, int currStep, List<String> solution, StringBuilder sb) {
        if (currStep == digits.length()) {
            solution.add(sb.toString());
            return;
        }

        for (int i = 0; i < data.get(digits.charAt(currStep)).size(); i++) {
            if (data.containsKey(digits.charAt(currStep))) {
                sb.append(data.get(digits.charAt(currStep)).get(i));

                combinations(digits, currStep + 1, solution, sb);

                sb.deleteCharAt(currStep);
            }
        }
    }
}
