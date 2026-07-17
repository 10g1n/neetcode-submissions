class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }

            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                Character character = stack.pop();

                if (s.charAt(i) == ']' && character != '[') {
                    return false;
                }

                if (s.charAt(i) == '}' && character != '{') {
                    return false;
                }

                if (s.charAt(i) == ')' && character != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
