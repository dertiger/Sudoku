/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Daniel
 */
public class Sudoku {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SudokuBoard sb = new SudokuBoard();
        sb.SetValue(0, 0, 1);
        sb.SetValue(0, 0, 3);
        sb.SetValue(3, 0, 3);
    }
}
