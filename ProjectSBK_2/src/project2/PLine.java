/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 * Implementation of queue. Front is front of list. End is back of list
 *
 * @author johnsone
 */
public class PLine {

    private int limit; // the number of people allowed in the line
    private int currentSize; // the current amount of people in the line
    private DCircularLL list; // the lit of people in the line

    /**
     * constructor for PLine
     *
     * @param person limit for line size
     */
    public PLine(int n) {
        currentSize = 0;
        limit = n;
        list = new DCircularLL();
    }

    /**
     * Returns number of people in line
     *
     * @return number of people in line
     */
    public int getLineLength() {
        return currentSize;
    }

    /**
     * Tries to add p to queue. Returns true if the person is successfully added
     * to the queue; false otherwise. You can assume p is not null.
     *
     * @return true if added; false otherwise
     */
    public boolean enqueue(Person p) {
        if (currentSize < limit) {
            list.append(p);
            currentSize++;
            return true;
        }
        return false; // add person in a line
    }

    /**
     * returns the Person object that is first in line without removing them.
     * Return null if line is empty
     *
     * @return Person at front of line or null if line empty
     */
    public Person peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst(); // checks the first person in the line
    }

    /**
     * Dequeues the first x people from the line. If there are not x people in
     * line, it removes however many people are in the line. Returns the number
     * of people removed. You should check to make sure x is not negative.
     */
    public int dequeue(int x) {
        if (x < 0) {
            System.out.println("It is impossible to perform the action");
            return 0;
        }
        int numremoved = 0;
        if (getLineLength() < x) {
            x = getLineLength();
        }
            for (int i = 0; i < x; i++) {
                list.removeFirst();
                currentSize--;
                numremoved++;
            }
            return numremoved;
        }

    /**
     * Removes first person in line and returns.
     * Returns null if list empty
     * 
     * @return first person or null if list is empty
     */
    public Person dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        currentSize--;
        return list.removeFirst();
    }

    /**
     * Returns true if list is empty; false otherwise
     * 
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    /**
     * Creates a string representing PLine
     */
    public String toString() {
        return "Front to back " + list + " Length " + getLineLength();
    }
}
