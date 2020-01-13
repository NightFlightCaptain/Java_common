package algorithm.leetcode;

/**
 * 【单词搜索】
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/27 15:32
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        if (row * col < word.length()) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] passBy = new boolean[row][col];
                if (board[i][j] == word.charAt(0)) {
                    passBy[i][j] = true;
                    if (judgePoint(i, j, 1, passBy, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean judgePoint(int indexRow, int indexCol, int wordIndex, boolean[][] passBy,
                               char[][] board, String word) {
        if (wordIndex == word.length()) {
            return true;
        }
        int[][] move = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < 4; i++) {
            indexRow += move[i][0];
            indexCol += move[i][1];
            boolean beyondBound = indexRow >= 0 && indexRow < row
                    && indexCol >= 0 && indexCol < col
                    && !passBy[indexRow][indexCol];
            if (beyondBound && board[indexRow][indexCol] == word.charAt(wordIndex)) {
                passBy[indexRow][indexCol] = true;
                if (judgePoint(indexRow, indexCol, wordIndex + 1, passBy, board, word)) {
                    return true;
                }
                passBy[indexRow][indexCol] = false;
            }
            indexRow -= move[i][0];
            indexCol -= move[i][1];

        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode79 solution = new LeetCode79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));

        board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        System.out.println(solution.exist(board, "AAB"));

    }
}
