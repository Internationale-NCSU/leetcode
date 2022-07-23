package mementoPattern;

//Originator

public class Editor {
    /*  implement an undo solution.
        Single Responsibility Principle:
    */

    private String content;
    // private List<String> prevContent
    // this way to implement 'undo' is not highly extendable.
    // to follow the Single Responsibility Principle,
    // we don't declare this list in the Editor class.
    // make sure use a new 'History' class to implement this function.
    public EditorState createState(){
        return new EditorState(content);
    }
    public void restore(EditorState state){
        content = state.getContent();
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
