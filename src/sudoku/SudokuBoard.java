/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class SudokuBoard {
    private SudokuField[][] sudokuboard = new SudokuField[9][9];
    private List<SudokuCollisionZone> collisionRow = new ArrayList<SudokuCollisionZone>();
    private List<SudokuCollisionZone> collisionCollumn = new ArrayList<SudokuCollisionZone>();
    private List<SudokuCollisionZone> collisionSquare = new ArrayList<SudokuCollisionZone>();
    
    /**
     * new 9*9 Sudoku Board
     */
    public SudokuBoard(){
        //Generate Collision Zones
        for(int i = 0; i<9; i++){
            collisionRow.add(new SudokuCollisionZone());
            collisionCollumn.add(new SudokuCollisionZone());
            collisionSquare.add(new SudokuCollisionZone());
        }
        //Gereate Field (Fill Collision Zones)
        for(int x = 0; x < 9; x++){
            for(int y = 0; y<9; y++){
                sudokuboard[x][y] = new SudokuField();
                collisionRow.get(x).AddField(sudokuboard[x][y]);
                collisionCollumn.get(y).AddField(sudokuboard[x][y]);
                int Squarpos = (y/3) + (x/3)*3;
                collisionSquare.get(Squarpos).AddField(sudokuboard[x][y]);
            }
        }
    }
    
    /**
     * Sets the Value of a Position
     * @param x x pos
     * @param y y pos
     * @param Value Value (0-9)
     */
    public void SetValue(int x, int y, int Value){
        try{
            sudokuboard[x][y].setValue((byte)Value);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
