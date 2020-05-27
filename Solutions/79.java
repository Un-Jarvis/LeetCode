class Solution {
    public boolean visited(int[][] visited, int row, int column) {
        for (int i = 0; i < visited.length; i++) {
            if (row == visited[i][0] && column == visited[i][1]) {
                return true;
            }
        }
        return false;
    }
    
    public int[][] initializeArray(int[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                arr[x][y] = -1;
            }
        }
        return arr;
    }
    
    public boolean search(char[][] board, int row, int column, String word, int index, int[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        
        if (row < 0 || 
                row >= board.length ||
                column < 0 ||
                column >= board[row].length ||
                visited(visited, row, column) ||
                word.charAt(index) != board[row][column]) {
            return false;
        }
        
        // Mark current char as visited
        visited[index][0] = row;
        visited[index][1] = column;
        
        index++;
        boolean exist = search(board, row, column - 1, word, index, visited) ||
                search(board, row, column + 1, word, index, visited) || 
                search(board, row - 1, column, word, index, visited) ||
                search(board, row + 1, column, word, index, visited);

        visited[index - 1][0] = -1;
        visited[index - 1][1] = -1;
        
        return exist;
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        boolean exist = false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!exist && word.charAt(0) == board[i][j]) {
                    // Initialize visited array
                    int[][] visited = initializeArray(new int[word.length()][2]);
                    
                    exist = search(board, i, j, word, 0, visited);
                }
            }
        }
        
        return exist;
    }
}

/**
 * Breadth-First Search Tree
 * 1. 必须得用recursion，不然一步走错了无法退回上一步重新走
 * 2. 第44、45行，recursion结束要restore visited nodes
 * 3. 用了int[][]记录visted nodes，但其实用boolean[][]更好
 */ 
