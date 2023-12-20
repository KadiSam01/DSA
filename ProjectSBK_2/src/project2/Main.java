/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * For this project there are 4 major components: Main, PLine, EventHeap, and CarnivalSimulation.
 *
 * Main is where the main method resides. It is also where testing code can go.
 * PLine is an implementation of a queue.
 * EventHeap is an implementation of a minimum Heap
 * Carnival Simulation is a driver class that runs the simulation.  The method start() acts
 * as the main for this simulation.
 *
 * The minor classes include Event, Person, and Ride.  Each of these pieces are an object
 * that mostly holds data about that object.  There are no large quantities of code in
 * these classes.
 *
 * EventType is an enumerated type (enum). You can consider it a data type that has a finite
 * number of options of what it can hold.  The EventType enum is declared in the event class.
 */
package project2;

/**
 * @author Kathleen Timmerman
 * @version 2023.02 Built the project from scratch.
 */
public class Main {

    /**
     * This is where your code begins. Comment/Uncomment the parts you do/don't
     * want to run.
     * 
     *
     * @param args
     */
    public static void main(String[] args) {
       //testPLine();
       // testEventHeap();
        CarnivalSimulation.start();
    }

    private static void testPLine() {
        System.out.println("Testing for isempty ");
        PLine firstline = new PLine(8); // the limit of the line is 8
        //System.out.println(firstline);
        System.out.println("Test the length of the line ");
        System.out.println("Should be 0 " + ":" + firstline.getLineLength());

        // System.out.println(firstline);

        System.out.println("Test Constructor when there is 8 people in the line");
        System.out.println("TESTING ENQUEUE");
        System.out.println("The limit of the line is eight");
        PLine secondline = new PLine(8);
        // add people to the line
        secondline.enqueue(new Person(15, 30));
        secondline.enqueue(new Person(16, 31));
        secondline.enqueue(new Person(17, 32));
        secondline.enqueue(new Person(12, 33));
        secondline.enqueue(new Person(18, 34));
        secondline.enqueue(new Person(19, 35));
        secondline.enqueue(new Person(21, 36));
        System.out.println(secondline);
        System.out.println("Test getLength");
        int line = secondline.getLineLength();
        System.out.println("Should be 7:" + " " + line);

        // int line = person.getLineLength();
        // System.out.println("The line should be 0 " + line);
        // System.out.println("Should be 7:" + line);

        // add people to the line

        System.out.println("Test Constructor when there is 8 people in the line");
        System.out.println("Testing Enqueue by adding more people");
        PLine thirdline = new PLine(8);
        thirdline.enqueue(new Person(15, 30));
        thirdline.enqueue(new Person(16, 31));
        thirdline.enqueue(new Person(17, 32));
        thirdline.enqueue(new Person(12, 33));
        thirdline.enqueue(new Person(18, 34));
        thirdline.enqueue(new Person(19, 35));
        thirdline.enqueue(new Person(21, 36));
        System.out.println(thirdline);
        System.out.println("add the next person");
        thirdline.enqueue(new Person(20, 31));
        System.out.println("The line should be 8" + ":" + thirdline.getLineLength());
        System.out.println(thirdline);
        thirdline.enqueue(new Person(22, 34));
        System.out.println("The line has reach its limit");

        // TEST PEEK
        System.out.println("Testing peek when the line is not empty");
        PLine fullLine = new PLine(8);
        fullLine.enqueue(new Person(15, 30));
        fullLine.enqueue(new Person(16, 31));
        fullLine.enqueue(new Person(17, 32));
        fullLine.enqueue(new Person(12, 33));
        fullLine.enqueue(new Person(18, 34));
        fullLine.enqueue(new Person(19, 35));
        fullLine.enqueue(new Person(21, 36));
        System.out.println(fullLine);
        System.out.println("Should be 15:" + " " + fullLine.peek().getArrivalTime());

        System.out.println("Testing peek on an empty list");
        PLine emptyPLine = new PLine(8);
        System.out.println("Is the line empty? It should return true: " + " " + emptyPLine.isEmpty());

        // Testing dequeue(x)
        System.out.println("Test deque(x) when x is less than the number of people in the line");
        PLine fourthLine = new PLine(8);
        fourthLine.enqueue(new Person(15, 30));
        fourthLine.enqueue(new Person(16, 31));
        fourthLine.enqueue(new Person(17, 32));
        fourthLine.enqueue(new Person(12, 33));
        fourthLine.enqueue(new Person(18, 34));
        fourthLine.enqueue(new Person(19, 35));
        fourthLine.enqueue(new Person(21, 36));
        System.out.println(fourthLine);
        // System.out.println("Test dequeue(x) when x is less than the number of people
        // in the line");
        System.out.println("Testing dequeue(4)");
        // System.out.println(fourthLine);

        System.out.println("the result should be 4" + ":" + fourthLine.dequeue(4));
        System.out.println("the length of the line is 3: " + ":" + fourthLine.getLineLength());

        // Testing dequeue(x)
        System.out.println("Test dequeue(x) when the size of the line is equal to the limit of the line");
        PLine fifthLine = new PLine(8);
        fifthLine.enqueue(new Person(15, 30));
        fifthLine.enqueue(new Person(16, 31));
        fifthLine.enqueue(new Person(17, 32));
        fifthLine.enqueue(new Person(12, 33));
        fifthLine.enqueue(new Person(18, 34));
        fifthLine.enqueue(new Person(19, 35));
        fifthLine.enqueue(new Person(21, 36));
        fifthLine.enqueue(new Person(23, 37));
        System.out.println(fifthLine);
        System.out.println("the result should be 8" + ":" + fifthLine.dequeue(8));
        System.out.println("The length of the line is 0" + ":" + fifthLine.getLineLength());

        // Testing dequeue(x)
        System.out.println("Test dequeue(x) when the size of the line is larger than the limit of the line");
        PLine sixth = new PLine(8);
        sixth.enqueue(new Person(15, 30));
        sixth.enqueue(new Person(16, 31));
        sixth.enqueue(new Person(17, 32));
        sixth.enqueue(new Person(12, 33));
        sixth.enqueue(new Person(18, 34));
        sixth.enqueue(new Person(19, 35));
        sixth.enqueue(new Person(21, 36));
        sixth.enqueue(new Person(23, 37));
        System.out.println(sixth);

        System.out.println("Test dequeue(x) when the size of the line is larger than the limit of the line");
        // sixth.dequeue(9);
        System.out.println("The result should be 8" + " " + sixth.dequeue(9));
        System.out.println("the length of the line is 0" + " " + sixth.getLineLength());

        System.out.println("one person in line and try to remove 4");
        System.out.println("The result should be impossible" + null);
        System.out.println(sixth.getLineLength());

        PLine seventh = new PLine(8);
        seventh.enqueue(new Person(15, 30));
        seventh.enqueue(new Person(16, 31));
        seventh.enqueue(new Person(17, 32));
        System.out.println(seventh);

        System.out.println("The result should be 3" + " " + seventh.dequeue(4));
        System.out.println("The result ");

        // Testing dequeue() when line is not empty
        PLine person = new PLine(8);
        person.enqueue(new Person(15, 30));
        person.enqueue(new Person(16, 31));
        person.enqueue(new Person(17, 32));
        person.enqueue(new Person(12, 33));
        person.enqueue(new Person(18, 34));
        person.enqueue(new Person(19, 35));
        person.enqueue(new Person(21, 36));
        person.enqueue(new Person(23, 37));
        System.out.println(person);

        System.out.println("Test removing the first person in the line");
        Person removedPerson = person.dequeue();
        // System.out.println(person);
        System.out.println("It should return 15" + ":" + removedPerson.toString());
        System.out.println("The size of the line was reduced by 7" + ":" + person.getLineLength());

        // Testing dequeue() when line is empty
        PLine newperson = new PLine(8);
        System.out.println("There is no one in the line" + "should be true:" + newperson.isEmpty());
        System.out.println("The length of the line is 0" + ":" + newperson.getLineLength());

        // Testing dequeue() when the limit of the line is 0

        PLine p = new PLine(0);
        p.enqueue(new Person(15, 30));
        System.out.println(p);

        // Testing empty
        System.out.println("Testing empty");
        PLine nPLine = new PLine(8);
        System.out.println("The queue is empty:" + ":" + nPLine.isEmpty());
    }

    private static void testEventHeap() {

        // Test adding 500 events inside the heap

        EventHeap heaps = new EventHeap();

        System.out.println("Adding 500 events inside the heap");

        for (int i = 1; i < 501; i++) {

            Event events = new Event(EventType.START_RIDE, i, "Riding a roller coaster");

            heaps.add(events);

            System.out.println("An event was added " + " " + events);

        }

        // Test adding more than 500 events inside the heap(501)

        System.out.println("adding more than 500 events");

        Event event = new Event(EventType.START_RIDE, 0, "events");
        heaps.add(event);
        
        EventHeap eventsremove = new EventHeap();
        System.out.println("The result should be null" + " " + eventsremove.remove());

        /*heaps.add(event);

        System.out.println("Error cannot add another event.");*/

        // Test Remove from a non empty heap

        System.out.println("Testing Remove");

        EventHeap eventheaps2 = new EventHeap();

        Event event1 = new Event(null, 15, null);

        eventheaps2.add(event1);

        Event event2 = new Event(null, 16, null);

        eventheaps2.add(event2);

        Event event3 = new Event(null, 17, null);

        eventheaps2.add(event3);

        Event event4 = new Event(null, 18, null);

        eventheaps2.add(event4);

        Event event5 = new Event(null, 19, null);

        eventheaps2.add(event5);


        System.out.println("The result should be 15:" + "" + eventheaps2.remove().getEventTime());
        //System.out.println(eventheaps2);
        System.out.println("The result should be 16:" + "" + eventheaps2.remove().getEventTime());
        //System.out.println(eventheaps2);

        // Test Remove from an empty heap

        EventHeap eventheaps4 = new EventHeap();

        eventheaps4.remove();

        System.out.println("There is no event to be removed" + " " + heaps.remove());

        // Test Peek from a non empty heap

        System.out.println("Testing Peak");

        EventHeap eventheaps3 = new EventHeap();

        Event event6 = new Event(null, 19, null);

        eventheaps3.add(event6);

        Event event7 = new Event(null, 16, null);

        eventheaps2.add(event7);

        Event event8 = new Event(null, 17, null);

        eventheaps3.add(event8);

        Event event9 = new Event(null, 18, null);

        eventheaps3.add(event9);

        Event event10 = new Event(null, 15, null);

        eventheaps3.add(event10);

        System.out.println("It should return 15" + " " + eventheaps3.peek().getEventTime());

        // Test Peek from an empty heap

        EventHeap eventheaps5 = new EventHeap();
        System.out.println("Test Peek from an empty heap");
        System.out.println("Should return null: " + eventheaps5.peek());

        System.out.println("Testing for isEmpty");

        System.out.println("should return true: " + eventheaps5.isEmpty());

        // Test Size

        System.out.println("Testing Size");

        EventHeap eventheaps6 = new EventHeap();

        Event event12 = new Event(null, 15, null);

        eventheaps6.add(event12);

        Event event11 = new Event(null, 16, null);

        eventheaps6.add(event11);

        Event event13 = new Event(null, 17, null);

        eventheaps6.add(event13);
        eventheaps6.size();
        System.out.println("Should return 3: " + eventheaps6.size());

    }
}
