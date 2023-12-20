
package singlyLL;




class SinglyLL {
/**
 * Nodes are the building block of the linked list
 * linked list is a collection of nodes
 * Nodes consists of two parts(the data and the address of the next node)
 */
    private Node head; 
    private Node tail;

    /**
     * creates an empty list
     * head represents the first node in the list
     * tail represents the last node in the list
     */
    public SinglyLL() {
        this.head = null; 
        this.tail = null;
    }

    /**
     * Adds value to the start of the list
     *note we cannot access any elements in a linked list directly
     * must traverse head node to tail(last) node 
     * @param value
     */
    public void add(int value) {
        Node n = new Node(value);
        if(head == null){
           // Node n = new Node(value);
            head = n;
            tail = n;
        }else{
            //add code to the handle nonemptyy list
            //Node n = new Node(value);
            n.next = head;
            head = n;
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value
     */
    public void append(int value) {
        /**
         * When there is no node in the empty list
         * We check to see if the head node is null
         * We simply set head to the new node 
         */
        if(head == null){
            Node n = new Node(value);
            head = n;
            //handle empty list
        }else{
            Node n = new Node(value);
            tail.next = n;
            tail = n;
        }
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item
     */
    public void remove(int item) {
        if(head == null){
            //do nothing
        } else if(head == tail){
            if(head.value == item){
                head=null;
            }
        }
    }

    /**
     * Removes the first value in the list
     */
    public void remove() {
        if(head == null){
            //do nothing
        } else if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
    }

    /**
     * Returns the location of the first occurrence of the value in the list.
     * Returns 0 if it is the first item. Return -1 if it isn't in the list
     *
     * @param value
     */
    public int indexOf(int value) {
        
        return -1;
        
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        String strRepresentation = "Forward: [ ";
        Node cur = head;
        while (cur != tail) {
            strRepresentation += cur.value + " ";
            cur = cur.next;
        }
        strRepresentation += cur.value +" ]" ;
     
        return strRepresentation;
    }


    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {

        public Node next;
        public int value;

        public Node(int value) {
            
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            
            this.value = value;
            this.next = next;
        }
    }

}
