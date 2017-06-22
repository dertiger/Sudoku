/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Daniel
 */
public class SudokuField {
    /**
     * Value of the Specific field (-1 (undefined) , 1-9)
     */
    private byte Value = -1;
    private EventListenerList fieldValueListeners = new EventListenerList();
    
    
    public SudokuField(){
        
    }
    
    /**
     * Sets the Value of the Field
     * @param Value Value to set (1-9)
     * @throws Exception if the Value isnt from 1-9
     */
    public void setValue(byte Value) throws Exception{
        if((Value>=1) && (Value<=9)){
            this.Value = Value;
            fireValueChanged();
        }
        else{
            throw new Exception("Value " + Value + " is out Of Range, could not Set the Field Value");
        }
    }
     /**
      * returns the Value of the Field
      * @return Value of the Field (-1 (undefined) , 1-9) 
      */
    public byte getValue(){
        return Value;
    }
    
    /**
     * Resets the Value to -1 (unset)
     */
    public void resetValue(){
        Value = -1;
    }
    
    public void addValueChangeListener(SudokuFieldValueChangeListener listener){
        fieldValueListeners.add(SudokuFieldValueChangeListener.class, listener);
    }
    
    public void removeValueChangeListener(SudokuFieldValueChangeListener listener){
        fieldValueListeners.remove(SudokuFieldValueChangeListener.class, listener);
    }
    
    private void fireValueChanged(){
        Object[] listeners = fieldValueListeners.getListenerList();
        // loop through each listener and pass on the event if needed
        int numListeners = listeners.length;
        for (int i = 0; i<numListeners; i+=2)
        {
             if (listeners[i]==SudokuFieldValueChangeListener.class) 
             {
                  // pass the event to the listeners event dispatch method
                   ((SudokuFieldValueChangeListener)listeners[i+1]).FieldValueChanged();
             }            
        }
    }
}
