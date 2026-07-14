class Solution {
    public boolean isAnagram(String s, String t) {
        char[] str1Arr = s.toCharArray();
        char[] str2Arr = t.toCharArray();

        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);

        return new String(str1Arr).equals(new String(str2Arr));
    }
}
