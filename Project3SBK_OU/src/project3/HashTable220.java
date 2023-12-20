/**
 * This is where you will implement your hash table.
 */
package project3;



/**
 * @author Oma
 * @author Samuel Kadima
 *
 * Course: Data Structures and Algorithms Semester:
 */
public class HashTable220 {

    private final int CAPACITY; //Capacity of the table
    private Record[] hashAry; // the array of records
    private int size; //Number of values in the table
    private int colliions;
    
    

    /**
     * This constructor builds a hash table. It then fills the table with a
     * bunch of empty records.
     *
     * @param capacity number of slots in table
     */
    public HashTable220(int capacity) {
        this.CAPACITY = capacity;
        hashAry = new Record[CAPACITY];
        this.size = 0;
        for (int i = 0; i < CAPACITY; i++) {
            Record r = new Record();
            hashAry[i] = r;
        }
    }

    /**
     * Inserts the key/value into the hashtable if there is room and the key
     * isn't already in the table
     *
     * @param key key to be inserted
     * @param value value associated with key
     * @return true if key/value could be inserted, false otherwise
     * 
     */


    public int getCollision(){
        return this.colliions;
    }
    public boolean insert(Integer key, Integer value) {
        //System.out.println("The value of key: " + key);
        //System.out.println(hashFunction(key));
        //System.out.println(doublehashfunction(key));
        colliions = 0; //sets the collision to 0 before each insert
       // System.out.println("collision" + this.colliions);
       if((size == CAPACITY) || (indexOf(key)!=-1)){
            return false;
        }
        int pos_index = hashFunction(key);
        int homeIndex = pos_index;
        int check_colllision = 0;
        while(true){
            if(hashAry[pos_index].isNormal()){
                check_colllision= check_colllision + 1;
                pos_index = probeFunction(homeIndex, check_colllision, key);
            }else{
                hashAry[pos_index] = new Record(key,value);
                size++;
                this.colliions = this.colliions + check_colllision;
                //this.colliions++;
                //System.out.println("collision" + this.colliions);
                return true;
            }
        }

    } 
    /**
     * Attempts to delete a key and returns true if the key/value is removed.
     *
     * @param key key to searched for
     */
    public boolean remove(Integer key) {

        //This method should only be about 7-8 lines
        int remove_index = 0;
        remove_index = indexOf(key);
        if(remove_index !=-1){
            hashAry[remove_index].deleteRecord();
            size--;
            return true;
        }
        return false;
    }

    /**
     * Finds an element with a certain key and returns the associated value
     *
     * @param key key to be checked
     * @return value associated with key or, if key not in table, null
     */
    public Integer find(Integer key) {  //possible

        //This method should only be about 4-5 lines
        int locate_index = 0;
        locate_index = indexOf(key);
        if(locate_index !=-1){
            return hashAry[locate_index].getValue();
        } 
        return null;
    }

    /**
     * Return load factor
     *
     * @returns size/capacity
     */
    public double alpha() {
        return (double)size/CAPACITY;
    }
    /**
     * Returns the home index for the given key.
     *
     * @param key key to be hashed
     * @return hash value for that key
     */
    private int hashFunction(Integer key) { //possible
        return key % CAPACITY;
    }

    private int doublehashfunction(Integer key){
        int q = 5; //the number does not matter //it hates 5 and 7 for no reason
        return q-(key%q);
    }

    public int getSize(){
        return size;
    }

   

    /**
     * Returns the next index that should be investigated. For example, if my
     * home index is 4 and I am calling a +1 linear probe for the 3rd time, this
     * function should return 7.
     *
     * @param homeIndex original hash for the key
     * @param collision number of collisions so far
     * @return next index to be checked
     */
    private int probeFunction(int homeIndex, int collisions, Integer key) { //linear probing
        //double hashing formula: (H1(key) + i * H2(key) % tablesize)
        int h2 = doublehashfunction(key);
        int next_index = homeIndex + collisions * h2;
        return (next_index % CAPACITY);

    }

    /**
     * This is a private method only to be used internally. It returns the index
     * where the record with the key is stored in the table. It returns -1 if
     * the key is not found in the table.
     *
     * @param key key to be checked
     * @return index where key exists in table or -1 if not in table
     */
  private int indexOf(Integer key) { //possible
    //there is an infinite loop in indexof
    //it does not move up from 0;
    //
        int check_index = hashFunction(key);
        int homeIndex = check_index;
        int collision = 0;
        while(!hashAry[check_index].getKey().equals(key)){
            if(hashAry[check_index].isEmpty()){
                return -1;
            }else{
                collision = collision + 1;
                check_index = probeFunction(homeIndex, collision,key);
                //check_index = (check_index + CAPACITY) % CAPACITY; to keep it in bound with 5 and 7(still does not work)
            }
        }
        return check_index;
        //create a field(instance variable) to keep track of the number of colliions
    }
     /* Already Complete. Returns a string representation of the hash table
     *
     * @return string representing table
     */
    public String toString() {
        String table = "";
        for (int i = 0; i < this.CAPACITY; i++) {
            table += i + ". " + hashAry[i].toString() + "\n";
        }
        return table;
    }

}
