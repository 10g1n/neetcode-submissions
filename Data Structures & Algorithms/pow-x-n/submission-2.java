class Solution {
    public double myPow(double x, int n) {
        double res = 1;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res*=x;
            }
        } else {
            double newVal = 1;
            for (int i = 1; i <= -n; i++) {
                newVal*=x;
            }
            res = 1 / newVal;
        }

        return res;
        
    }
}
