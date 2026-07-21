class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq.containsKey(s.charAt(right))) {
                freq.put(s.charAt(right), freq.get(s.charAt(right)) + 1);
            } else {
                freq.put(s.charAt(right), 1);
            }

            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            int windowLen = right - left + 1;

            if (windowLen - maxFreq > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            } else {
                maxLength = Math.max(maxLength, windowLen);
            }
        }

        return maxLength;
    }
}
