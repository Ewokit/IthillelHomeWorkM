
public class LList {
    private int size = 0;
    Node<java.lang.Number> first;
    Node<java.lang.Number> last;

    private class Node<Number>{
        Number component;
        Node next;
        Node previous;

        Node(Node previous, Number element, Node next){
            this.previous = previous;
            this.next = next;
            this.component = element;
        }
    }
}
