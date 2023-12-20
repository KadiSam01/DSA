enum Day{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Enumlearn{
    Day day;
    public Enumlearn(Day day){
        this.day = day;
    }
    public void tellLikeItIs(){
        switch(day){
            case MONDAY:
                System.out.println("Mondays are bad");
                break;
            case FRIDAY:
                System.out.println("Fridays are better");
                break;
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best");
                break;
            
            default:
                System.out.println("Midweek days are so-so");
                break;
        }
    }
    public static void main(String [] args){
        Enumlearn firstday = new Enumlearn(Day.MONDAY);
        Enumlearn seconday = new Enumlearn(Day.FRIDAY);
        firstday.tellLikeItIs();
    }
}