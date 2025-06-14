class Solution {
    public boolean isValidSudoku(char[][] board) {
         // Arrays to check the validity of rows, columns, and sub-grids.
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subgrids = new boolean[9][9];

        // Iterate over the board by rows and columns.
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char currentChar = board[i][j];

                // If the current character is a dot, ignore and continue to the next iteration.
                if (currentChar == '.') {
                    continue;
                }

                // Convert char to its corresponding number (1-9).
                int number = currentChar - '0' - 1;

                // Calculate index for the subgrids.
                int subgridIndex = (i / 3) * 3 + j / 3;

                // Check if the number has already been recorded in the current row, column, or subgrid.
                if (rows[i][number] || columns[j][number] || subgrids[subgridIndex][number]) {
                    // If any is true, then the board is not valid.
                    return false;
                }

                // Mark the presence of the number in the current row, column, and subgrid.
                rows[i][number] = true;
                columns[j][number] = true;
                subgrids[subgridIndex][number] = true;
            }
        }

        // If no conflicts are found, the board is valid.
        return true;
    }
}