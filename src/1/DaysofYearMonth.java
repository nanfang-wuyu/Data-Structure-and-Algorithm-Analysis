
public class DaysofYearMonth {

    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        String monthName = "February";
        int days = 0;
        boolean isLeapYear = false;
        if (year%4==0&&year%100!=0||year%400==0) {// to finish it
            System.out.println(year +" is a leap year.");
            isLeapYear = true;
        } else {
            System.out.println(year +" is not a leap year.");
            isLeapYear = false;
        }
        switch (month) {
            case 1:days = 31;
                break;
            case 3:days = 31;
                break;
            case 5:days = 31;
                break;
            case 7:days = 31;
                break;
            case 8:days = 31;
                break;
            case 10:days = 31;
                break;
            case 12:
                days = 31;
                break;
            case 2: {
                if (isLeapYear) {
                    days = 29;
                } else {
                    days = 28;
                }
                monthName = "February";
                break;
            }
            case 4:days = 30;
                break;
            case 6:days = 30;
                break;
            case 9:days = 30;
                break;
            case 11:
                days = 30;
                break;
            default:
                System.out.println("error!!!");
                break;
        }
        System.out.printf("%d%2d %s has %d days.",year,month,monthName,days);
    }
}


