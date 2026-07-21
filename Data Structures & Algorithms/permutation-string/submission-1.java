class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> s1FreqMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1FreqMap.containsKey(s1.charAt(i))) {
                s1FreqMap.put(s1.charAt(i), s1FreqMap.get(s1.charAt(i)) + 1);
            } else {
                s1FreqMap.put(s1.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> currStrFreq = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (currStrFreq.containsKey(s2.charAt(i))) {
                currStrFreq.put(s2.charAt(i), currStrFreq.get(s2.charAt(i)) + 1);
            } else {
                currStrFreq.put(s2.charAt(i), 1);
            }
        }

        if (s1FreqMap.equals(currStrFreq)) {
            return true;
        }

        int left = 0;

        for (int right = left + s1.length(); right < s2.length(); right++) {
            currStrFreq.put(s2.charAt(left), currStrFreq.get(s2.charAt(left)) - 1);

            if (currStrFreq.get(s2.charAt(left)) == 0) {
                currStrFreq.remove(s2.charAt(left));
            }

            left++;

            if (currStrFreq.containsKey(s2.charAt(right))) {
                currStrFreq.put(s2.charAt(right), currStrFreq.get(s2.charAt(right)) + 1);
            } else {
                currStrFreq.put(s2.charAt(right), 1);
            }

            if (s1FreqMap.equals(currStrFreq)) {
                return true;
            }
        }

        return false;
    }
}
