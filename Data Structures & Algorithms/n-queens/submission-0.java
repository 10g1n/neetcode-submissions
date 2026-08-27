class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<StringBuilder> solution = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            sb.repeat(".", Math.max(0, n));
            solution.add(sb);
        }

        putQueens(n, 0, solution, result);

        return result;
    }

    private static void putQueens(int n, int currStep, List<StringBuilder> solution, List<List<String>> result) {
        if (currStep == n) {
            List<String> list = new ArrayList<>();

            for (StringBuilder sb : solution) {
                list.add(sb.toString());
            }

            result.add(List.copyOf(list));

            return;
        }

        for (int col = 0; col <= n - 1; col++) {
            solution.get(currStep).setCharAt(col, 'Q');

            if (isValidPosition(solution, n)) {
                putQueens(n, currStep + 1, solution, result);

                solution.get(currStep).setCharAt(col, '.');
            } else {
                solution.get(currStep).setCharAt(col, '.');
            }
        }
    }

    private static boolean isValidPosition(List<StringBuilder> board, int n) {
        return isRowValid(board, n) && isColValid(board, n) && isDiagonalValid(board, n);
    }
    
    private static boolean isRowValid(List<StringBuilder> board, int n) {
        for (int row = 0; row < n; row++) {
            int queenCount = 0;

            for (int col = 0; col < n; col++) {
                if (board.get(row).charAt(col) == 'Q') {
                    queenCount++;
                }

                if (queenCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isColValid(List<StringBuilder> board, int n) {
        for (int row = 0; row < n; row++) {
            int queenCount = 0;

            for (int col = 0; col < n; col++) {
                if (board.get(col).charAt(row) == 'Q') {
                    queenCount++;
                }

                if (queenCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isDiagonalValid(List<StringBuilder> board, int n) {
        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < n; col1++) {

                if (board.get(row1).charAt(col1) != 'Q') {
                    continue;
                }

                for (int row2 = row1 + 1; row2 < n; row2++) {
                    for (int col2 = 0; col2 < n; col2++) {

                        if (board.get(row2).charAt(col2) != 'Q') {
                            continue;
                        }

                        if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
