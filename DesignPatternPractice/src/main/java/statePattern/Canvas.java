package statePattern;

import java.util.Collections;

public class Canvas {
    // Open Close Principle
    // Open to extension.
    // Close to modification.

    private Tool currentTool;

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public void mouseDown(){
        currentTool.mouseDown();
    }
    public void mouseUp(){
        currentTool.mouseUp();
    }

    // write in this way would be hard to extend.
    // we use the Abstraction characteristic in OOP
    // to separately implement these methods.

    /*
    public void mouseDown(){
        if(currentTool.equals(ToolType.SELECTION)){
            System.out.println("Selection Icon");
        }else if(currentTool.equals(ToolType.BRUSH)){
            System.out.println("Brush Icon");
        }else if(currentTool.equals(ToolType.ERASER)) {
            System.out.println("Erase Icon");
        }
    }
    public void mouseUp(){
        if(currentTool.equals(ToolType.SELECTION)){
            System.out.println("Draw dashed rectangle");
        }else if(currentTool.equals(ToolType.BRUSH)){
            System.out.println("Draw a line");
        }else if(currentTool.equals(ToolType.ERASER)) {
            System.out.println("Erase Something");
        }
    }
    */

}
