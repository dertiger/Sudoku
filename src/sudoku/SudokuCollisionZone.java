/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.List;
/**
 *
 * @author Daniel
 */
public class SudokuCollisionZone 
        implements SudokuFieldValueChangeListener{ 
    List<SudokuField> collisionField = new ArrayList<>();
    
    public SudokuCollisionZone(){
    }
    
    /**
     * Adds a Field to the Collision Zone
     * @param collisionField The Field to Add
     */
    public void AddField(SudokuField collisionField){
        this.collisionField.add(collisionField);
        //register This Zone to the Value Changed Listener
        collisionField.addValueChangeListener(this);
    }
    
    /**
     * Checks for the FIRST collison in the Field
     * @return -1 = no collision (Value = Collision in the coresponding NR)
     */
    private byte hasCollision(){
        for(int i = 0; i < collisionField.size()-1; i++){   //for all but least
            for(int x = i+1; x < collisionField.size(); x++){//all bigger then i
                if(collisionField.get(i).getValue() == collisionField.get(x).getValue()){
                    return collisionField.get(i).getValue();
                }
            }
        }
        return -1;
    }
    
    /**
     * Checks wether a Value is part of this Collision Field
     * @param Number The Value to Check
     * @return true = is part of
     */
    public boolean Contains(byte Number){
        for(SudokuField sf : collisionField){
            if(sf.getValue() == Number){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks the new FieldValue with the collision Zone
     */
    @Override
    public void FieldValueChanged(){
        byte collision = hasCollision();
        if(collision != -1){    //if collision detected
            //TODO: Implement
            System.out.println("collision with NR: " + collision + " detected");
            //throw new NotImplementedException();
        }
    }
}
