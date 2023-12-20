/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 * 
 * See Main before reading through this code.
 * 
 * This class runs the actual simulation. It requires most other classes within this
 * package. The method start() is where the simulation begins.
 * 
 * 
 */
package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kathleen Timmerman
 * @version 2023.02
 *          Built the project from scratch.
 */

public class CarnivalSimulation {

    private static final double PARK_CLOSING_TIME = 300.0; // Number of minutes after park opens before the park closes
    private static final double CUSHION_FOR_LEAVING = 15; // People will not join a new line if there is only 15 minutes
                                                          // before they intend to leave.
    private static final int MIN_MODIFIER = 3; // This is used as a cushion value for ride time length and it * 10 is
                                               // the minumum number of people on a ride at once.
    private static final int NUM_RIDES = 18; // Number of rides in the park. With current setup, as the number of rides
                                             // increase, the rides get longer but hold more people
    private static final double WAIT_TIME = 2.0;// How long a ride will wait before starting to run after the first
                                                // person gets in line.
    private static final double LOAD_TIME = 1.5; // How long it takes to unload and load a ride
    private static final double WALK_TIME = 4.0; // walk between rides

    private static double currentTime = 0.0; // The number of minutes since the park opened.
    private static final ArrayList<Ride> RIDES = new ArrayList<>(); // A list of all rides in the park
    private static final EventHeap EVENTS = new EventHeap(); // A priority queue to hold upcoming events
    private static int numLeaveEarly = 0; // Count of how many people left early because lines were too long.

    /**
     * This starts the simulation.
     * It initializes the ride, loads the starting events of people arriving, and
     * dequeues the next events from the heap. Once there are no more events in the
     * queue,
     * this method will print the number of people who left early and the simulation
     * ends.
     */
    public static void start() {
        // load RIDES
        for (int i = 0; i < NUM_RIDES; i++) {
            RIDES.add(new Ride(i + MIN_MODIFIER, (i + MIN_MODIFIER) * 10));
        }

        loadPeople();

        // Run the simulation
        while (!EVENTS.isEmpty()) {
            Event event = EVENTS.remove();
            currentTime = event.getEventTime();

            switch (event.getEventType()) {
                case START_RIDE:
                    Ride rs = (Ride) event.getEventTarget();
                    if (rs.startRide()) {
                        Event e = new Event(EventType.END_RIDE,
                                currentTime + rs.getRideTime(), rs);
                        EVENTS.add(e);

                    }
                    break;
                case END_RIDE:
                    Ride re = (Ride) event.getEventTarget();
                    ArrayList<Person> exiting = re.endRide();
                    while (!exiting.isEmpty()) {
                        Person p = exiting.remove(exiting.size() - 1);
                        // checks that the visitor has some time left to enjoy the ride so they can
                        // enjoy another ride
                        if (currentTime + CUSHION_FOR_LEAVING + WALK_TIME < p.getTimeLeaving()) {
                            findARide(p);
                        }
                    }
                    /*
                     * Event e = new Event(EventType.START_RIDE, currentTime + LOAD_TIME, re );
                     * EVENTS.add(e);
                     */
                    if (re.getLineLength() >= 1) {
                        // there should be several factors for a ride to start
                        // checks if there are any visitors walking to the ride
                        Event e = new Event(EventType.START_RIDE, currentTime + LOAD_TIME, re);
                        EVENTS.add(e);
                    }
                    break;
                case ARRIVE_AT_CARNIVAL:
                    findARide((Person) event.getEventTarget());
                    break;
            }
            // end switch
        } // end while

        System.out.println(numLeaveEarly + " people left early.");
    }

    /**
     * This method randomly choose a new ride for the person.
     * If the ride they find has no one else in line and the ride isn't currently
     * running,
     * a START_RIDE event will be created.
     * 
     * @param p
     */
    private static void findARide(Person p) {

        // A list of Indexs for all rides.
        ArrayList<Integer> rideOptions = new ArrayList();
        for (int i = 0; i < NUM_RIDES; i++) {
            rideOptions.add(i);
        }

        // Randomly remove one index from the list of indexs. See if there is room in
        // that line.
        // If ride is found, add that person to the line. Create a START_RIDE event if
        // the ride wasn't
        // running and no one was in line.

        boolean rideFound = false;
        while (!rideFound && !rideOptions.isEmpty()) {
            int index = (int) (Math.random() * rideOptions.size());
            index = rideOptions.remove(index);

            Ride r = RIDES.get(index);

            if (r.addToLine(p)) { // checks if a person can be added into the line of the the ride
                rideFound = true;
                // takes into consideration how long the first person had to walk to the ride
                if (!r.isRunning() && r.getLineLength() == 1) {
                    Event e = new Event(EventType.START_RIDE, currentTime + WALK_TIME + WAIT_TIME, r);
                    //Event e = new Event(EventType.START_RIDE, currentTime + WAIT_TIME, r);
                    EVENTS.add(e);

                }

            }
            // walking
        }

        // If no ride line had space
        if (!rideFound) {
            numLeaveEarly++;
        }

    }

    /**
     * Use the file personFile.txt to load arrival times and lengths of visit.
     * Each line in file will create a ARRIVE_AT_CARNIVAL event.
     */
    private static void loadPeople() {
        double arriveTime, timeHere;

        try {
            File myFile = new
            File("/Users/theonesammy/Developer/cs220/ProjectSBK_2/personFile.txt"); //
            // Finds the
            // file(the file
            // path is
            // different on my // device)
            //File myFile = new File("personFile.txt");
            Scanner inputFile = new Scanner(myFile); // connects to the file
            while (inputFile.hasNext()) { // while something to read
                arriveTime = inputFile.nextDouble();
                timeHere = inputFile.nextDouble();
                double leaveTime = (arriveTime + timeHere);
                if (leaveTime > PARK_CLOSING_TIME)
                    leaveTime = PARK_CLOSING_TIME;
                Person p = new Person(arriveTime , leaveTime);
                Event event = new Event(EventType.ARRIVE_AT_CARNIVAL, arriveTime , p);
                EVENTS.add(event); // add event into heap
            } // end while
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
            System.exit(0);
        }
    }

}
