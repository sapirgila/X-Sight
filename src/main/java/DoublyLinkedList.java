class DoublyLinkedList {
    int size = 0;
    //A node class for doubly linked list
    class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    //Initially, heade and tail is set to null
    Node head, tail = null;

    //add a node to the list
    public Node addNode(int item) {
        //Create a new node
        Node newNode = new Node(item);
        size= size+1 ;

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
            head.previous = null;
        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
        return newNode;
    }
}