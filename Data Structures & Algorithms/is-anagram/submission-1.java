class Solution {
    public boolean isAnagram(String s, String t) {
        char tempArr1[] = s.toCharArray();
        char tempArr2[] = t.toCharArray();

        Arrays.sort(tempArr1);
        Arrays.sort(tempArr2);

        return new String(tempArr1).equals(new String(tempArr2));
    }
}
