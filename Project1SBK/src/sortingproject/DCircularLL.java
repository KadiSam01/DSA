/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class is your DCircularLL. You will be implementing the methods in accordance
 * of the project description.
 * 
 * REMEMBER: A circular linked list only uses a tail pointer - no head pointer.
 *
 * Methods you will implement:
 * public void add(int value)
 * public void append(int value) 
 * public void remove(int item)
 * public void remove()
 * public void empty()
 * public int indexOf(int value) 
 * public void insertionSort() 
 * public void mergeSort()
 * 
 * Methods and Classes Already implemented for you:
 * public DCircularLL()
 * public static DCircularLL createUnsortedLL() 
 * public String toString() 
 * private static class Node  <-- Inner Node class
 * 
 */
package sortingproject;

import java.util.ArrayList;

/**
 * @version Starter Code
 * @author Samuel Kadima
 */
class DCircularLL {

    private Node tail;

    /**
     * creates an empty list
     */
    public DCircularLL() {
        tail = null;
    }

    /**
     * Adds value to the start of the list
     *
     * @param value to be added
     */
    public void add(int value) {
        Node n = new Node(value);
        if(tail == null){
            tail = n;
            tail.next = tail;
            tail.prev = tail;
        }else{
            tail.next.prev = n;
            n.next = tail.next;
            tail.next = n;
            tail.next.prev = tail;
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value to be added
     */
    public void append(int value) {
        Node n = new Node(value);
        if(tail == null){
            tail = n;
            tail.next = tail;
            tail.prev = tail;
        }else{
          tail.next.prev = n;
          n.prev = tail;
          n.next = tail.next;
          tail.next = n;
          tail = n;
        }
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item to be removed
     */

    public void remove(int item) {
        Node current = tail.next;
        if(tail == null){
            //do nothing
        } 
        else if(tail.next == tail && item == tail.value){
            tail = null;
        }
        else{
            while(current.value!=item && current!=tail){
            current = current.next;
            /*if(current!=tail){
            current = current.next;
            }*/
        }
        if(current.value == item){
            current.prev.next = current.next;
            current.next.prev = current.prev;
            if(tail == current){
                tail = tail.prev;
            }
        }
        }
        
    }

   

    /**
     * Removes the first value in the list
     */
    public void remove() {
        if(tail == null){
            //do nothing
        }
        if(tail == tail.next){
            tail = null;
        }else{
            tail.next.next.prev = tail;
            tail.next = tail.next.next;
        }
    }

    /**
     * Empties the list
     */
    public void empty() {
        tail = null;
    }

    /**
     * Returns the location of the first occurrence of the value in the list.
     * 
     * @param value value to be located
     * @return 0 if it is the first item. Return -1 if it isn't in the list
     */
    public int indexOf(int value) {
        int count = 0;
        if(tail == null){
            return -1;
        }
        Node current = tail.next;
        while(current.value!=value && current!=tail){
           /*if(current!=tail){
                current = current.next;
            }*/
            current = current.next;
            count++;
        }
        if(current.value!=value){
            return -1;
        }
        return count;
    }

    /**
     * Sorts the list using insertion sort
     */
    public void insertionSort() {
        if(tail==null){

        }
        while(tail.next!=tail){

        }
    }
    
    /**
     * Sorts the list using radix sort
     */
    public void radixSort(){
        if(tail == null || tail.next == tail){
            //do nothing
        }
        //creates the buckets 
        ArrayList<Integer> [] buckets= new ArrayList[10];
        //initalizes each buckets
        for(int i = 0; i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        int maxDigits = RadixGetMaxLength(); //find the maxDigits in the list
        int pow10 = 1; //a multiplier of 10
        for(int digitIndex = 0; digitIndex<maxDigits; digitIndex++){
            for(int i = 0; i<buckets.length; i++){
                int bucketsIndex  = (Math.abs(tail.next.value)/pow10)%10;
                buckets[bucketsIndex].add(tail.next.value);
                tail.next = tail.next.next;
            }
        
        
        int arrayIndex = 0;
        for(int i = 0; i<buckets.length; i++){
            for(int j = 0; j<buckets[i].size(); j++){
               list.set(arrayIndex, buckets[i].get(j));
               arrayIndex++;
            }
        }
        for(int i = 0; i<buckets.length; i++){
            buckets[i].clear();
        }
         pow10 = 10 * pow10;
        }
    }
    private int RadixGetMaxLength() {
        int maxDigits = 0;
        Node current = tail.next;
        while (current != tail.next) {
            int countDigit = RadixGetLength(current.value);
            if (countDigit > maxDigits) {
                maxDigits = countDigit;
            }
            current = current.next;
        }
        return maxDigits;
    }
    
    private int RadixGetLength(int value) {
        int v = value;
        if (v == 0) {
            return 1;
        }
        int digits = 0;
        while (v != 0) {
            digits++;
            v /= 10;
        }
        return digits;
    }
    
    /**
     * Creates a DCircularLL of LIST_SIZE that is filled with random integers
 between 0 and 999.
 * @return random list
     */
    public static DCircularLL createUnsortedLL() {
        DCircularLL linkedList = new DCircularLL();
        for (int i = 0; i < Sorts.LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            linkedList.add(value);
        }
        return linkedList;
    }
    
  
    /**
     * This is the method called when a DCircularLL is passed to System.out.print It
     * determines what is printed.
     * 
     * For this project I printed the list forward and backward.
     */
    @Override
    public String toString() {
        if (tail == null) {
            return "[]";
        }
        String strRepresentation = "Forward: [";
        Node cur = tail.next;
        while (cur != tail) {
            strRepresentation += cur.value + " ";
            cur = cur.next;
        }
        strRepresentation += cur.value + "]\nBackward: [";
        
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

        public Node prev;
        public Node next;
        public int value;

        /**
         * Constructor for Node
         * @param value value contained in Node
         */
        public Node(int value) {
            this.prev = null;
            this.value = value;
            this.next = null;
        }

        /**
         * Constructor for Node
         * @param prev previous pointer
         * @param value value contained in Node
         * @param next next pointer
         */
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}
