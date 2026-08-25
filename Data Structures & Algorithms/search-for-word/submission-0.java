class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (checkCells(board, 0, word, visited, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkCells(char[][] board, int currStep, String word, boolean[][] visited, int row, int col) {
        if (currStep == word.length()) {
            return true;
        }

        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) {
            if (board[row][col] == word.charAt(currStep) && !visited[row][col]) {
                visited[row][col] = true;

                boolean res =  checkCells(board, currStep + 1, word, visited, row + 1, col)
                        || checkCells(board, currStep + 1, word, visited, row - 1, col)
                        || checkCells(board, currStep + 1, word, visited, row, col + 1)
                        || checkCells(board, currStep + 1, word, visited, row, col - 1);

                visited[row][col] = false;

                return res;
            }
        }

        return false;
    }
}
