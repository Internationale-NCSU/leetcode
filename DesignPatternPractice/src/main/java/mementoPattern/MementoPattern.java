package mementoPattern;

public class MementoPattern {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        // an undo method
        editor.restore(history.pop());
    }
}
