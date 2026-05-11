class Solution {
    public boolean isAnagram(String s, String t) {
        boolean res = false;
        if (s.length() != t.length()) {
            return res;
        } else {
            Map<Character, Integer> map1 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            }

            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
            }

            if (map1.equals(map2)) {
                res = true;
            }
        }
        return res;
    }
}
