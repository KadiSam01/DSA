
package circulardoublyLL;




class CircularDoublyLL {

    private Node head;
    private Node tail;

    /**
     * creates an empty list
     */
    public CircularDoublyLL() {
        head = null;
        tail = null;
    }

    /**
     * Adds value to the start of the list
     *
     * @param value
     */
    public void add(int value) {
        Node n  = new Node(value);
        if(head == null){
            head = n; //set head to the the new node n
            tail = n; //set tail to the new node n
            n.prev = n; //set the previous node of n to itself
            n.next = n; //set the next node of n to itself
        }else if(head == tail){ //it verifies there is at least one node in the lsit
            n.next = head; //set the next node of n to the current head
            n.prev = tail; //set the previous node of n to the current tail
            head.prev = n; //update the previous node of the current head to point to n
            head.next = n; //update the next node of the current head to point to n
            head = n; //updates head to the new node n
        }else{ //if there are multiple nodes in the list besides one
            n.next = head; //set the next node of n to the current head
            n.prev = tail; //set the previous node of n to previous head
            head.prev = n; //updates the previous node of n of the current head to point to n
            tail.next = n; //updates the next node of n of the current tail to point to n
            head = n; //updates head to a new node n
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value
     */
    public void append(int value) {
        
    
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item
     */

    private Node find(int item){
        if(head == null){
            return null;
        }else{
            Node curr = head;
            while(curr!=null){
                if(curr.value == item){
                    return curr;
                }else{
                    return null;
                }
            }
        }
        return head;
    }


    public void remove(int item) {
        Node target = find(item);
        if(target == null){

        }else if(head == null){
            head = null;
            tail = null;
        }else if(target == head){
            remove();
        }else if(target == tail){
            head.prev = tail.prev;
            tail.prev.next = head;
            tail = tail.prev;
        }else{
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
    }

    /**
     * Removes the first value in the list
     */
    public void remove() {
        
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
        strRepresentation += cur.value + "]\nBackward: [ ";
        
        cur = tail;
        while (cur != tail.next) {
            strRepresentation += cur.value + " ";
            cur = cur.prev;
        }
        strRepresentation += cur.value + "]";
        return strRepresentation;
    }


    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {

        public Node next;
        public int value;
        public Node prev;

        public Node(int value) {
            
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node(Node prev,int value, Node next) {
            
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}
