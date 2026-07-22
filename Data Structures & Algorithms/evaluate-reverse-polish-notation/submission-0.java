class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNum(token)) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                switch (token) {
                    case "+" -> stack.push(String.valueOf(num1 + num2));
                    case "-" -> stack.push(String.valueOf(num1 - num2));
                    case "*" -> stack.push(String.valueOf(num1 * num2));
                    case "/" -> stack.push(String.valueOf(num1 / num2));
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public boolean isNum(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
