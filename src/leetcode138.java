import java.util.HashMap;
import java.util.Map;

public class leetcode138 {
    Map<Node,Node> visited = new HashMap<>();
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(this.visited.containsKey(head)){
            return this.visited.get(head);
        }
        Node node = new Node(head.val);
        this.visited.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }


}
