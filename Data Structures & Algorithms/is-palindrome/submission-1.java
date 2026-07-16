class Solution {
    public boolean isPalindrome(String s) {
        String newStr = removeNonAlphanumeric(s);

        int left = 0;
        int right = newStr.length() - 1;

        while (left <= right) {
            if (newStr.charAt(left) != newStr.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public String removeNonAlphanumeric(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
