class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = nrOfOnes(i);
        }

        return result;
    }

    public int nrOfOnes(int binary) {
        int count = 0;

        while (binary != 0) {
            int bit = binary & 1 ;
            if (bit == 1) {
                count++;
            }

            binary >>= 1;
        }

        return count;
    }
}
