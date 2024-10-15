package assignments;

public class LeapYear {
    public static void main(String[] args) {
        int year = 2000;

        if (year >= 1900 && year <= 2016){
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                System.out.println(29);
            }
            else {
                System.out.println(28);
            }
        }
        else {
            System.out.println("Select a year between 1900 and 2016");
        }
    }
}
