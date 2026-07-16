class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            HashSet<Character> set1 = new HashSet<>();
            for (char aChar : chars) {
                if (aChar == '.') {
                    continue;
                }

                if (set1.contains(aChar)) {
                    return false;
                }
                
                set1.add(aChar);
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set2 = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (set2.contains(board[j][i])) {
                    return false;
                }

                set2.add(board[j][i]);
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                HashSet<Character> set3 = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int m = j; m < j + 3; m++) {
                        if (board[k][m] == '.') {
                            continue;
                        }

                        if (set3.contains(board[k][m])) {
                            return false;
                        } 

                        set3.add(board[k][m]);
                    }
                }
            }
        }


        return true;
    }
}
