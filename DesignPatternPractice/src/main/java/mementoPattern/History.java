package mementoPattern;

import java.util.ArrayList;
import java.util.List;

//Caretaker

public class History {
    // For state management.

    private List<EditorState> states = new ArrayList<>();
    public void push(EditorState state){
        states.add(state);
    }
    public EditorState pop(){
        return states.remove(states.size()-1);
    }
}
