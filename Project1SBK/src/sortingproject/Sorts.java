/**
 * This is the starter code for the sorting project in CSCI 220. Note that there
 * are multiple files.
 *
 * This class contains the sort methods for sorts performed on arrays and
 * ArrayLists. The sorts for LL are in that class.
 * 
 * This method also contains a final variable for list size.  Make sure you test on
 * lists of various sizes.
 * 
 * You need to implement these methods:
 * selectionSortOnArray(int[] list) 
 * insertionSortOnArray(int [] list) 
 * selectionSortOnArrayList(ArrayList<Integer> list)
 * radixSortOnArrayList(ArrayList<Integer> list)
 * 
 * These methods have already been implemented and need no changes:
 * public static int[] createUnsortedArray() 
 * public static ArrayList<Integer> createUnsortedArrayList()  
 * public static String getArrayString(int[] ary) 
 * 
 */
package sortingproject;

import java.util.ArrayList;

/**
 * @version Starter Code
 * @author Samuel Kadima
 */
public class Sorts {

    // You should change this size as you are testing your program
    final static int LIST_SIZE = 12;

    /**
     * Sorts the list using selection sort.
     * 
     * @param list array to be sorted
     *             the code below comes from the pseducode from the book
     *             minor changes were made but not that much
     */
    public static void selectionSortOnArray(int[] list) {
        // the first for loop represents the outer loop and we loop through the entire
        // loop except the last one
        // because we do not want the loop to go beyond\
        // int n = list.length;
        for (int i = 0; i < list.length - 1; i++) {
            // we use the findsmallest method to provide us the index of the smallest
            // element in the list
            int indexSmallest = findSmallest(list, i, list.length);
            int temp = list[i];
            list[i] = list[indexSmallest];
            list[indexSmallest] = temp;
        }

    }

    /**
     * for (i = 0; i < numbersSize - 1; ++i) {
     * 
     * // Find index of smallest remaining element
     * indexSmallest = i
     * for (j = i + 1; j < numbersSize; ++j) {
     * 
     * if (numbers[j] < numbers[indexSmallest]) {
     * indexSmallest = j
     * }
     * }
     * 
     * // Swap numbers[i] and numbers[indexSmallest]
     * temp = numbers[i]
     * numbers[i] = numbers[indexSmallest]
     * numbers[indexSmallest] = temp
     * }
     **/

    /**
     * 
     * @param arr        we are looking for the array in the list with the smallest
     *                   element
     * @param startIndex we assume that the startingindex has the smallest elem ent
     *                   in the list
     * @param endIndex   we loop through the endindex to search
     * @return the smallest index of the list
     */
    private static int findSmallest(int[] arr, int startIndex, int endIndex) {
        int smallestIndex = startIndex;
        for (int i = smallestIndex; i < endIndex; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;

    }

    /**
     * Sorts the list using insertion sort
     * 
     * @param list array to be sorted
     *             There is a sorted and unsorted part
     *             the first element is the sorted part while the rest are unsorted
     *             the code comes from the pseudocome from the book
     *             minor changes were made
     */
    public static void insertionSortOnArray(int[] list) {
        // we start from the second element on the list because we assume the first
        // element is sorted
        for (int i = 1; i < list.length; i++) {
            int j = i;
            // the variable j is used to track the index of the current elemt inserted into
            // the sort part(according to the book)
            while (j > 0 && list[j] < list[j - 1]) {
                /**
                 * the swap method just swaps the current element with the elements on its left
                 * understand the swap things
                 */
                int temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                j--;
            }
        }
        /**
         * for (i = 1; i < numbersSize; ++i) {
         * j = i
         * // Insert numbers[i] into sorted part
         * // stopping once numbers[i] in correct position
         * while (j > 0 && numbers[j] < numbers[j - 1]) {
         * 
         * // Swap numbers[j] and numbers[j - 1]
         * temp = numbers[j]
         * numbers[j] = numbers[j - 1]
         * numbers[j - 1] = temp
         * --j
         * }
         * }
         **/
    }

    /**
     * Sorts the list using selection sort
     * 
     * @param list ArrayList to be sorted
     */
    public static void selectionSortOnArrayList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // we use the findsmallest method to provide us the index of the smallest
            // element in the list
            int indexSmallest = findSmallest(list, i, list.size());
            int temp = list.get(i);
            list.set(i,list.get(indexSmallest));
            list.set(indexSmallest,temp);
        }
    }

    //
    private static int findSmallest(ArrayList<Integer> list, int startIndex, int endIndex) {
        int smallestIndex = startIndex;
        for (int i = smallestIndex; i < endIndex; i++) {
            if (list.get(i)< list.get(smallestIndex)) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * Sorts the list using radix sort
     * 
     * @param list ArrayList to be sorted
     */
    public static void radixSortOnArrayList(ArrayList<Integer> list) {
        //creates the buckets 
        ArrayList<Integer> [] buckets= new ArrayList[10];
        //initalizes each buckets
        for(int i = 0; i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        int maxDigits = RadixGetMaxLength(list); //find the maxDigits in the list
        int pow10 = 1; //a multiplier of 10
        for(int digitIndex = 0; digitIndex<maxDigits; digitIndex++){
            for(int i = 0; i<list.size(); i++){
                int bucketsIndex  = Math.abs(list.get(i)/pow10)%10;
                buckets[bucketsIndex].add(list.get(i));
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

    private static int RadixGetMaxLength(ArrayList<Integer> list){
        int maxDigits = 0;
        for(int i = 0; i<list.size(); i++){
            int countDigit = RadixGetLength(list.get(i));
            if(countDigit > maxDigits){
                maxDigits = countDigit;
            }
        }
        return maxDigits;
    }


    private static int RadixGetLength(int value){
        int v = value;
        if(v == 0){
            return 1;
        }
            int digits = 0;
            while(v!=0){
                digits++;
                v/=10;
            }
            return digits;
        }

    /******************
     * Below methods already implemented
     ****************************/

    /**
     * Creates an array of LIST_SIZE that is filled with random integers between
     * 0 and 999.
     * 
     * @return unsorted array of random numbers
     */
    public static int[] createUnsortedArray() {
        int[] ary = new int[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            ary[i] = (int) (Math.random() * 1000);
        }
        return ary;
    }

    /**
     * Creates an ArrayList of LIST_SIZE that is filled with random integers between
     * 0 and 999.
     * 
     * @return unsorted ArrayList of random numbers
     */
    public static ArrayList<Integer> createUnsortedArrayList() {
        ArrayList<Integer> ary = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            ary.add((int) (Math.random() * 1000));
        }
        return ary;
    }

    /**
     * @return a string representation of array ary as "[ n1 n2 n3 ]"
     */
    public static String getArrayString(int[] ary) {
        String s = "[ ";
        for (int i = 0; i < ary.length; i++) {
            s += ary[i] + " ";
        }
        s += "]";
        return s;
    }

}