class Solution {
    public String multiply(String num1, String num2) {
        long val1 = 0;
        int n = num1.length();

        for (int i = 0; i < n; i++) {
            val1 = val1 * 10 + ((int) num1.charAt(i) - 48);
        }

        long val2 = 0;
        int n2 = num2.length();

        for (int i = 0; i < n2; i++) {
            val2 = val2 * 10 + ((int) num2.charAt(i) - 48);
        }

        return String.valueOf(val1 * val2);
    }
}
