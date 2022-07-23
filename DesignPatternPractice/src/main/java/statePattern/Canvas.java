package statePattern;

public class Canvas {
    private ToolType currentTool;

    public ToolType getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(ToolType currentTool) {
        this.currentTool = currentTool;
    }

    // write in this way would be hard to extend.

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
}
