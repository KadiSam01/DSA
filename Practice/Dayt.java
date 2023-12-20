import java.time.MonthDay;

public class Dayt {
    public enum Day{
        //MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        MONDAY("start of the week"), TUESDAY("second day"), WEDNESDAY("third day");

        private final String description;
        private Day(String description){
            this.description = description;
        }
        public String getDescription(){
            return description;
        }
    }
    public static void main(String [] args){
        Day monday = Day.MONDAY;
        System.out.println(monday.getDescription());
       // Day today = Day.WEDNESDAY;
        /**if(today == Day.WEDNESDAY){
            System.out.println("It's wednesday");
        } else if(today == Day.SUNDAY){
            System.out.println("It's Sunday!");
        }else{
            System.out.println("It's not sunday or wednesday");
        }
    }**/
}
}