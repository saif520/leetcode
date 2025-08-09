class Solution {
    private char[][] gameBoard; // Renamed board to gameBoard for clarity
    private int rows;           // Renamed m to rows for clarity
    private int cols;           // Renamed n to cols for clarity

    // Function updates the game board when a user clicks on a cell (i.e., uncovers the cell)
    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;        // Total number of rows in the board
        cols = board[0].length;     // Total number of columns in the board
        gameBoard = board;          // Assign board to gameBoard for internal use

        int clickRow = click[0], clickCol = click[1]; // Row and column indexes of the click position

        // Check if the clicked cell contains a mine
        if (gameBoard[clickRow][clickCol] == 'M') {
            gameBoard[clickRow][clickCol] = 'X'; // If there's a mine, mark the cell as 'X'
        } else {
            // If the clicked cell does not contain a mine, perform Depth First Search (DFS) from this cell
            dfs(clickRow, clickCol);
        }
        return gameBoard; // Return the updated board
    }

    // Performs Depth First Search (DFS) to reveal cells
    private void dfs(int row, int col) {
        int mineCount = 0; // Counter for adjacent mines

        // Iterate through the adjacent cells
        for (int x = row - 1; x <= row + 1; ++x) {
            for (int y = col - 1; y <= col + 1; ++y) {
                // Check if the adjacent cell is within the board and if it contains a mine
                if (x >= 0 && x < rows && y >= 0 && y < cols && gameBoard[x][y] == 'M') {
                    mineCount++; // Increment the mine counter
                }
            }
        }

        if (mineCount > 0) { 
            // If there are mines found around the cell, display the mine count
            gameBoard[row][col] = (char) (mineCount + '0');
        } else {
            // If there are no mines around the cell, mark the cell as 'B' for blank
            gameBoard[row][col] = 'B';
            // Recursively reveal adjacent cells that are not mines and are unrevealed ('E')
            for (int x = row - 1; x <= row + 1; ++x) {
                for (int y = col - 1; y <= col + 1; ++y) {
                    if (x >= 0 && x < rows && y >= 0 && y < cols && gameBoard[x][y] == 'E') {
                        dfs(x, y); // Recursive call to dfs
                    }
                }
            }
        }
    }
}