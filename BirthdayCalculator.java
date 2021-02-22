import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;


public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator!");

        System.out.println("\nWhat's your birthday?");
        String userInput = input.nextLine();
        //System.out.println(userInput);

        String dayBorn = "";
        String dayCurrent = "";
        String currentDate = "";
        String daysLeft = "";
        String nextAge = "";

        SimpleDateFormat formatter=new SimpleDateFormat("MM-dd-yyyy");

        try {
            Date date = formatter.parse(userInput);
            //System.out.println("Given:" + date);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
            dayBorn = dateFormat.format(date).toUpperCase();

            LocalDate currentDateLD = LocalDate.now();
            String [ ] dateString = userInput.split("-");
            String currentYearBirthday = dateString[0]+"-"+dateString[1]+"-"+currentDateLD.getYear();
            Date date2 = formatter.parse(currentYearBirthday);
            dayCurrent = dateFormat.format(date2).toUpperCase();

            currentDate = currentDateLD.getMonthValue() + "-" + currentDateLD.getDayOfMonth() + "-" + currentDateLD.getYear();

            Date date3 = formatter.parse(currentDate);
            long difference_In_Time = date2.getTime() - date3.getTime();
            long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
            long difference_In_TimeAge = date2.getTime() - date.getTime();
            long difference_In_Years = (difference_In_TimeAge / (1000l * 60 * 60 * 24 * 365));
            if (difference_In_Days < 0){
                String nextYearDate = dateString[0]+"-"+dateString[1]+"-"+(currentDateLD.getYear()+1);
                Date date4 = formatter.parse(nextYearDate);
                //System.out.println("date4:" + nextYearDate);
                //System.out.println("date3:" + currentDate);
                difference_In_Time = date4.getTime() - date3.getTime();
                difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
                difference_In_Years++;
            }
            else if(difference_In_Days == 0){
                difference_In_Days = 365; // not accounting leap years
                difference_In_Years++;
            }

            daysLeft = difference_In_Days + "";

            nextAge = difference_In_Years + "";

            System.out.println("\nThat means you were born on a " + dayBorn + "!");
            System.out.println("This year it falls on a " + dayCurrent + "...");
            System.out.println("And since today is " + currentDate + ",");
            System.out.println("there's only " + daysLeft + " until the next one when you turn " + nextAge + "!");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
