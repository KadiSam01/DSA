/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testingStacks;

/**
 * Implementation of stack. Top of stack is front of list.
 * @author johnsone
 */
public class PStack {

    private int limit;
    private int currentSize;
    private DCircularLL list;

    /**
     * constructor for PStack
     *
     * @param n limit for line size
     */
    public PStack(int n) {
        currentSize = 0;
        limit = n;
        list = new DCircularLL();
    }

    /**
     * Returns number of people in stack
     *
     * @return number of people in stack
     */
    public int getLineLength() {
        return currentSize;
    }

    /**
     * Tries to add p to stack. Returns true if the person is successfully added
     * to the stack; false otherwise. You can assume p is not null.
     *
     * @return true if added; false otherwise
     */
    public boolean push(Person p) {
        if (currentSize == limit) {
            return false;
        } else {
            list.prepend(p);
            currentSize++;
            return true;
        }
    }

    /**
     * returns the Person object that is first on stack without removing them.
     * Return null if stack is empty
     *
     * @return Person at top of stack or null if line empty
     */
    public Person peek() {
        return list.getFirst();
    }

    /**
     * Removes the first x people from the stack. If there are not x people in
     * line, it removes however many people are in the stack. Returns the number
     * of people removed. You should check to make sure x is not negative.
     */
    public int pop(int x) {
        if (x <= 0) {
            return 0;
        } else {
            int count = 0;
            while (count < x && currentSize != 0) {
                list.removeFirst();
                count++;
                currentSize--;
            }
            return count;
        }
    }

    /**
     * Removes first person in stack and returns. 
     * Returns null if list empty
     * @return first person or null if list is empty
     */
    public Person pop() {
        if (currentSize > 0) { 
            currentSize--;
        }
        return list.removeFirst();
    }

    /**
     * Returns true if list is empty; false otherwise
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /**
     * Creates a string representing PStack
     */
    public String toString(){
        return "Top to bottom "+list+" Length "+getLineLength();
    }
}
/**
 * Testing idea
 * Action - in a full stack, try to add a person
 * why - to check to see if theres room for a person - return false
 * How do I create a full stack?
 */