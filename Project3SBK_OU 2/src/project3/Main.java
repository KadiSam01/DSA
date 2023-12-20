/**
 * This is the driver class.
 * Note that it should NEVER interact with the Record class.
 *
 * HashTable220.java is your implementation Hash Table.
 * Record.java is a record object that is stored in the hash table.
 *
 * Links between classes
 * The hash table has an array of Records.
 * Each Record holds a (key, value) pair
 *
 */
package project3;

import java.util.ArrayList;

/**
 * @author Katie Timmerman
 * @author < your name >
 *
 * Course: Data Structures and Algorithms Semester:
 */
public class Main {

    public static void main(String[] args) {
        testingHashTable();
        runAnalysis();
    }

    /**
     * Code to test your HashTable 220 implementation
     */
    private static void testingHashTable(){
        HashTable220 myTable0 = new HashTable220(10);
        System.out.println("Testing adding elements");
        myTable0.insert(9,90);
        myTable0.insert(18,180);
        myTable0.insert(28,280);
        myTable0.insert(20,200);
        myTable0.insert(30,300);
        System.out.println("Should be: 28, 20, 30, 5 Empty, 18, 9");
        System.out.println(myTable0);
        
        System.out.println("Find 28 (should be 280): "+myTable0.find(28));
        System.out.println("Remove 20 (should be true): "+myTable0.remove(20));
        System.out.println("Should be: 28, Empty after remove, 30, 5 Empty, 18, 9");
        System.out.println(myTable0);
        System.out.println("Find 30 (should be 300): "+myTable0.find(30));
        myTable0.insert(40,400);
        System.out.println("Should be: 28, 40, 30, 5 Empty, 18, 9");
        System.out.println(myTable0);

        System.out.println("Load factor (should be 0.5): "+myTable0.alpha());
    }
    /*private static void testingHashTable() {
        HashTable220 myTable = new HashTable220(10);
        ArrayList<Integer> addedKeys = new ArrayList<Integer>();
        System.out.println("TESTING ADDING ELEMENTS");

        for (int i = 0; i < 5; i++) {
            int key_value = (int) (Math.random() * 20);
            int value_value = key_value * 10;
            if (myTable.insert(key_value, value_value)) {
                addedKeys.add(key_value);
            } else {
                i--; //Don't count the insert if key already in table
            }
        }
        System.out.println("My table should have 5 elements.\nEnsure that "
                + "everything was inserted to the correct spot and that something "
                + "used the probe function.\nIdeally, check that rolling over occurred.");
        System.out.println(myTable);

        System.out.println("\n\nTESTING FINDING ELEMENTS");
        System.out.println("Ensure that the values are in the correct spot in the table."
                + "\nAgain, you should make sure something that used the probe function was located.");
        for (int i = 0; i < addedKeys.size(); i++) {
            int key = addedKeys.get(i);
            System.out.println("The value " + key + " found: " + myTable.find(key));
        }
        System.out.println("The value 346 should not be found: " + myTable.find(346));

        System.out.println("\n\nTESTING REMOVING ELEMENTS");
        System.out.println("Ensure that the keys were removed.\nAgain, you want to"
                + "make sure this works with the probe function.");
        for (int i = 0; i < addedKeys.size(); i += 2) {
            int key = addedKeys.get(i);
            System.out.println("The value " + key + " removed: " + myTable.remove(key));
        }
        System.out.println("The table now looks like this:");
        System.out.println(myTable);

        System.out.println("\n\nTESTING FINDING REMOVED ELEMENTS");
        System.out.println("Make sure that the removed values are not found.");
        for (int i = 0; i < addedKeys.size(); i += 2) {
            int key = addedKeys.get(i);
            System.out.println("The value " + key + " found: " + myTable.find(key));
        }

        System.out.println("\n\nTESTING FINDING VALID ELEMENTS AFTER REMOVAL");
        System.out.println("These should be found.");
        for (int i = 1; i < addedKeys.size(); i += 2) {
            int key = addedKeys.get(i);
            System.out.println("The value " + key + " found: " + myTable.find(key));
        }
        System.out.println(myTable);

        System.out.println("\n\nTESTING ADDING ELEMENTS over empty-after-removal");

        for (int i = 0; i < 8; i++) {
            int key_value = (int) (Math.random() * 20);
            int value_value = key_value * 10;
            if (myTable.insert(key_value, value_value)) {
                addedKeys.add(key_value);
            } else {
                i--; //Don't count the insert if key already in table
            }
        }
        System.out.println("My table is now this:\n" + myTable);
        System.out.println("Load factor(should be 0.5)" + myTable.alpha());
        //System.out.println("Load factor(should be 0.5)" + myTable0.alpha());
    }

    /**
     * Function to do analysis
     */
    private static void runAnalysis() {
        int key_scale = 1000000;
        int capacity = 1009;
        HashTable220 ht = new HashTable220(capacity); 
        //create a collision counter method(ignore)
        double totalcollisions = 0.0;
        for(int i = 0; i<=1000; i++){
           if(i%100!=0){
            ht.insert((int)(Math.random() * key_scale), (int)(Math.random() * key_scale));
           } else{
            for(int j = 1; j<=20; j++){
                int random_num = (int) (Math.random() * key_scale);
                ht.insert(random_num, random_num);
                ht.remove(random_num);
                totalcollisions = totalcollisions + ht.getCollision();
            }
            System.out.println("The load factor " + " " + ht.alpha());
            System.out.println("Expected collisions:" + " " + (1)/(1-ht.alpha()));
            double avgCollisions = totalcollisions /20;
            System.out.println("The Average :" + " " + avgCollisions);
           }
        }
    }

}
