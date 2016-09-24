package com.java.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 *
 * @author mti1301
 * @since 2015/6/11.
 */
public class ValidSudoku {

    public static void main(String[] args) {
        // '.' ascii 等于46 '0' ascii 等于 48
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        List<Map<Character, Integer>> columnMaps = new ArrayList<>();
        List<Map<Character, Integer>> gridMaps = new ArrayList<>();
        // Init Maps
        for (int i = 0; i < len; i++) {
            columnMaps.add(new HashMap<Character, Integer>());
            gridMaps.add(new HashMap<Character, Integer>());
        }

        Map<Character, Integer> rowMap = new HashMap<>();
        for (int row = 0; row < len; ++row) {
            rowMap.clear();
            for (int col = 0; col < len; ++col) {
                char ch = board[row][col];
                Integer value;

                if (ch > '0') {
                    // 先判定同一行的数字是否成立
                    value = rowMap.get(ch);
                    if (value != null) {
                        return false;
                    }
                    rowMap.put(ch, col);

                    // 再判定同一列的数字是否成立
                    Map<Character, Integer> colMap = columnMaps.get(col);
                    value = colMap.get(ch);
                    if (value != null) {
                        return false;
                    }
                    colMap.put(ch, col);

                    // 最后再判断一个九宫格里面的数字是否成立
                    int gridIndex = (row / 3) * (len / 3) + (col / 3);
                    Map<Character, Integer> gridMap = gridMaps.get(gridIndex);
                    value = gridMap.get(ch);
                    if (value != null) {
                        return false;
                    }
                    gridMap.put(ch,col);
                }
            }
        }
        return true;
    }
}
