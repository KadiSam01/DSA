/** 
 * This class is completed for you.
 * 
 * Each record holds an integer key, a Customer, and a record type.
 * 
 * The record type is stored as an enumerated value.  Enumerated values allow
 * us to create a data type that holds a finite number of options. This allows it
 * to run efficiently and makes it so less error checking needs to be done.  
 * 
 * You shouldn't need to deal with the enumerated type. Just call the is<Type>()
 * methods to check if the type matches.
 * 
 * The only other class that should directly interact with the record class is
 * HashTable2020.java
 * 
 * This class is complete and should not need updated.
 */
 
package project3;

/**
 * @author Katie Timmerman
 * 
 * 
 * Course: Data Structures and Algorithms
 * 
 */


// There are three types of records in a closed hash:
// Normal records, empty records, and emptyAfterRemovals.
// Normal records hold valid key/values
// empty records are empty-since-start
// emptyAfterRemoval records are empty-after-removal
enum RecordType { normalRecord, emptyRecord, emptyAfterRemoval };

public class Record{

    private Integer key;
    private Integer value;
    private RecordType type;

    /**
     * Create an empty record.
     */
    public Record() {
        key = 0;
        type = RecordType.emptyRecord;
    }

    /**
     * Create a normal record.
     * @param key key
     * @param c value
     */
    public Record(Integer key, Integer c) {
        this.key = key;
        this.value = c;
        type = RecordType.normalRecord;
    }

    /**
     * Convert a record to a emptyAfterRemoval due to removal
     */
    public void deleteRecord() {
        key = 0;
        value = 0;
        type = RecordType.emptyAfterRemoval;
    }

    /**
     * Get the integer key of a record
     * @return key of record
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Get the value of a record
     * @return value of record
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Check if a record is empty-since-start
     * @return true if empty-since-start. False otherwise
     */ 
    public boolean isEmpty() {
        return (type == RecordType.emptyRecord);
    }

    /**
     * Check if a record is a normal record
     * @return true if normal. False otherwise
     */ 
    public boolean isNormal() {
        return (type == RecordType.normalRecord);
    }

    /**
     * Check if a record is a emptyAfterRemoval (empty-after-removal)
     * @return true if normal. False otherwise
     */ 
    public boolean isEmptyAfterRemoval() {
        return (type == RecordType.emptyAfterRemoval);
    }

    /**
     * Override the toString operator for printing records
     * @return string representing record
     */ 
    @Override
    public String toString() {
        if (isEmptyAfterRemoval()) {
            return "<<EmptyAfterRemoval>>";
        } else if (isEmpty()) {
            return "<<Empty>>";
        } else {
            return "Key: " + key + ", Value: " + value;
        }
    }

}
