class Solution {
    public boolean isPalindrome(String s) {
        String cleanedStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        boolean res = true;

        int start = 0;
        int end = cleanedStr.length() - 1;


        while (start < end) {

            if (cleanedStr.charAt(start) == cleanedStr.charAt(end)) {
                start++;
                end--;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }
}
