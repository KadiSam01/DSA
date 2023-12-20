
package circulardoublyLL;

import java.util.ArrayList;


public class ProjectMain {

    public static void main(String[] args) {
        CircularDoublyLL list=new CircularDoublyLL();
        System.out.println("Empty List\n"+list);
        list.add(5);
        System.out.println("5 added at beginning\n"+list);
        list.add(6);
        System.out.println("6 added at beginning\n"+list);
        list.add(7);
        System.out.println("7 added at beginning\n"+list);
        list.append(8);
        System.out.println("8 added at end\n"+list);
        
        list=new CircularDoublyLL();
        System.out.println("Empty List\n"+list);
        list.append(9);
        System.out.println("9 added at end\n"+list);
        list.append(10);
        System.out.println("10 added at end\n"+list);
        list.append(11);
        System.out.println("11 added at end\n"+list);
        list.remove();
        System.out.println("9 removed from list\n"+list);
        list.remove();
        System.out.println("10 removed from list\n"+list);
        list.remove();
        System.out.println("11 removed from list\n"+list);
        
        list=new CircularDoublyLL();
        System.out.println("Empty List\n"+list);
        list.remove(9);
        System.out.println("Try to remove 9\n"+list);
        list.add(9);
        System.out.println("Add 9\n"+list);
        list.remove(10);
        System.out.println("Try to remove 10\n"+list);
        list.remove(9);
        System.out.println("Try to remove 9\n"+list);
        list.add(5);
        list.add(6);
        list.add(5);
        System.out.println("After adding 5,6,5\n"+list);
        list.remove(5);
        System.out.println("Try to remove 5\n"+list);
        list.remove(5);
        System.out.println("Try to remove 5\n"+list);
        list.append(4);
        list.append(7);
        System.out.println("After appending 4 and 7\n"+list);
        list.remove(4);
        System.out.println("Try to remove 4\n"+list);
        
        list=new CircularDoublyLL();
        System.out.println("Empty List\n"+list);
        list.append(0);
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.println("After appending 0,10,20,30\n"+list);
        System.out.println("Index of 0: "+list.indexOf(0));
        System.out.println("Index of 10: "+list.indexOf(10));
        System.out.println("Index of 20: "+list.indexOf(20));
        System.out.println("Index of 30: "+list.indexOf(30));
        System.out.println("Index of 40: "+list.indexOf(40));
        
    }

}