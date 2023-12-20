/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * This class creates a MINIMUM HEAP built on an array. The size of the heap should
 * only be limited by the hardware of the computer.
 */
package project2;

import org.w3c.dom.events.Event;

/**
 * @author Samuel Kadima
 * @version 2023.10 Built the project from scratch.
 */
public class EventHeap {

    private int size;
    private Event[] heap;

    /**
     * Create an empty heap.
     */
    public EventHeap() {
        size = 0;
        heap = new Event[500];
    }

    /**
     * Add an item to the heap.
     *
     * @param event to be added
     * @return true if event is successfully added. False otherwise.
     */
    public boolean add(Event event) {
        if (size == heap.length) {
            doubleArray();
        }
        heap[size] = event;
        size++;
        bubbleUp(size - 1); 
        return true;
    }

    /**
     * Remove and return the minimum value in the heap.
     *
     * @return minimum value or, if empty, return null
     *
     */
    public Event remove() {
        if (isEmpty()) {
            return null;
        }
        Event minValue = heap[0];
        Event replaceValue = heap[size - 1];
        size--;
        if (size > 0) {
            heap[0] = replaceValue;
            bubbleDown(0);
        }
        return minValue;
    }

    /**
     * Returns without removing the minimum value in the heap.
     *
     * @return min value or, if empty, null
     *
     */
    public Event peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    /**
     * returns the number of items in the heap
     *
     * @return number of heap items
     */
    public int size() {

        return size;
    }

    /**
     * Returns true if heap is empty. False otherwise.
     *
     * @return true if heap is empty. False otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Doubles the capacity of the heap. This method should also copy over all
     * elements from the old array to the new array.
     */
    private void doubleArray() {
        
        Event[] events = new Event[heap.length * 2];
        for (int i = 0; i < size; i++) {
            events[i] = heap[i];
        }
        heap = events;
    }

    /**
     * Once something is added to the bottom of the heap, this method moves it
     * upward until it is in the correct spot.
     *
     * @param index original index of item to bubble
     */
    private void bubbleUp(int index) {
        while (index > 0) {
            // Compute the parent node's index
            int parentIndex = (index - 1) / 2;

            // Check for a violation of the max heap property
            if (heap[index].getEventTime() >= heap[parentIndex].getEventTime()) {
                // No violation, so percolate up is done.
                return;
            } else {
                swap(parentIndex, index);
                index = parentIndex;
            }
        }
    }

    /**
     * Once something is swapped to the top of the heap, this method will move
     * it downwards until it is the correct spot.
     *
     * @param index original index of item to bubble
     */
    private void bubbleDown(int index) {
        int childIndex = 2 * index + 1;
        Event value = heap[index];

        while (childIndex < size) {
            // Find the max among the node and all the node's children
            Event minValue = value;
            int maxIndex = -1;
            int i = 0;
            while (i < 2 && i + childIndex < size) {
                if (heap[i + childIndex].getEventTime() < minValue.getEventTime()) {
                    minValue = heap[i + childIndex];
                    maxIndex = i + childIndex;
                }
                i++;
            }

            // Check for a violation of the max heap property
            if (minValue == value) {
                return;
            } else {
                // Swap heapArray[nodeIndex] and heapArray[maxIndex]
                swap(index, maxIndex);

                // Continue loop from the max index node
                index = maxIndex;
                childIndex = 2 * index + 1;
            }
        }
    }

    /**
     * Creates a string representation of the tree. Note: size and heap might
     * need to be updated to reflect your variable names.
     *
     * @return string representing heap
     */
    public String toString() {
        String s = "";
        int nodesPerLevel = 0;
        int maxNodesPerLevel = 1;
        for (int i = 0; i < size; i++) {
            s += heap[i] + "  ";
            nodesPerLevel++;
            if (nodesPerLevel >= maxNodesPerLevel) {
                s += "\n"; // New Line
                maxNodesPerLevel *= 2;
                nodesPerLevel = 0;
            }
        }
        return s;
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param index1 index of first element
     * @param index2 index of second element
     */
    private void swap(int index1, int index2) {
        Event temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}