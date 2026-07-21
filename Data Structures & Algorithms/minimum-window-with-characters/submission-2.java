class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int start = 0;

        HashMap<Character, Integer> currMap = new HashMap<>();

        int valid = 0;

        for (int right = 0; right < s.length(); right++) {
            if (currMap.containsKey(s.charAt(right))) {
                currMap.put(s.charAt(right), currMap.get(s.charAt(right)) + 1);
            } else {
                currMap.put(s.charAt(right), 1);
            }

            if (tMap.containsKey(s.charAt(right))) {
                if (Objects.equals(tMap.get(s.charAt(right)), currMap.get(s.charAt(right)))) {
                    valid++;
                }
            }

            while (valid == tMap.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                currMap.put(s.charAt(left), currMap.get(s.charAt(left)) - 1);

                if (tMap.containsKey(s.charAt(left)) && currMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) {
                    valid--;
                }

                if (currMap.get(s.charAt(left)) == 0) {
                    currMap.remove(s.charAt(left));
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
