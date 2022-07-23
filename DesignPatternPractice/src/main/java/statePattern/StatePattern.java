package statePattern;

public class StatePattern {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();

    }
}
