import java.util.ArrayList;
import java.util.List;

public class ConcreteHotel implements Hotel {

    private List<Room> rooms = new ArrayList<>();
    private List<Integer>breakfast = new ArrayList<>();
    private List<Boolean>addbed = new ArrayList<>();
    private List<Double>allincome = new ArrayList<>();
    //private List<Double>total = new ArrayList<>();
    //private List<Room> times = new ArrayList<>();
    private double Lprice = 1200;
    private double Oprice = 500;
    private String currentDay = "MONDAY";
    private double total = 0;
    //private double allincome = 0;
    private double dailyincome = 0;
    //private ConcreteHotel concreteHotel;
    //private int count = 0;
    //private LuxuryRoom luxuryRoom;
    //private OrdinaryRoom ordinaryRoom;

    @Override
    public void addRoom(int type, int count) {
        if(type == 0){
            for(int i = 0; i < count; i++){
            LuxuryRoom room = new LuxuryRoom();
            rooms.add(room);
            addbed.add(false);
            breakfast.add(0);
            }
        }
        if(type == 1){
            for(int i = 0; i < count; i++){
            OrdinaryRoom room = new OrdinaryRoom();
            rooms.add(room);
            addbed.add(false);
            breakfast.add(0);

            }
        }
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
        addbed.add(false);
        breakfast.add(0);
    }

    @Override
    public void setPrice(int type, double price) {
        if(type == 0){this.Lprice = price;}
        else if(type == 1){this.Oprice = price;}
    }

    @Override
    public double getPrice(int type) {
        if(type == 0){return Lprice;}
        return Oprice;


    }

    @Override
    public double getRoomPrice(String number) {
        total = 0;
        for(int k = 0; k<rooms.size() ; k++) {
            if (rooms.get(k).getNumber().equals(number)&&rooms.get(k).getCheckIn()==true) {
                if (rooms.get(k).toString().startsWith("L")){
                total = total + getPrice(0) * Day.valueOf(currentDay).getRate();
                if (addbed.get(k) == true) {
                    total = total + 250;
                }
                //allincome = allincome + total;
                return total;
                }
                else if (rooms.get(k).toString().startsWith("O")) {
                total = total + getPrice(1) * Day.valueOf(currentDay).getRate();
                total = total + breakfast.get(k) * 180;
                //allincome = allincome + total;
                return total;
                }
            }
        }
       return 0;
    }

    @Override
    public void displayAllRooms() {
        for(int i = 0; i < rooms.size();i++){
           System.out.println(rooms.get(i).toString());
        }
    }

    @Override
    public List<Room> getAllCheckedRooms() {
        List<Room> checkInRoom = new ArrayList<>();
        for (int j = 0; j < rooms.size(); j++) {
            if (rooms.get(j).getCheckIn() == true) {
                checkInRoom.add(rooms.get(j));
            }
        }return checkInRoom;
    }

    @Override
    public void displayEveryDayInfo() {
        for(Day day : Day.values()){
            System.out.println(day.toString());
        }
    }

    @Override
    public void displayTodayInfo() {
        System.out.println(Day.valueOf(currentDay).toString());
    }

    @Override
    public void checkIn(int type, int number) {
       if(type == 0) {
            for (int j = 0; j < rooms.size(); j++) {
                if((rooms.get(j).toString().startsWith("L"))){
                if (rooms.get(j).getCheckIn() == false) {
                    rooms.get(j).setCheckIn(true);
                    rooms.get(j).checkIn(number);
                    if(number == 3){addbed.set(j,true);}
                    //else {addbed.add(true);}
                    break;
                }
                }
            }
        }
        if(type == 1) {
            for (int j = 0; j < rooms.size(); j++) {
                if((rooms.get(j).toString().startsWith("O"))){
                if (rooms.get(j).getCheckIn() == false) {
                    rooms.get(j).setCheckIn(true);
                    rooms.get(j).checkIn(number);
                    breakfast.set(j,number) ;
                    break;
                }
            }
            }
        }
    }

    @Override
    public void checkOut(String... roomNumber) {
        //ConcreteHotel a = new ConcreteHotel();
        /*for(int k = 0; k<rooms.size() ; k++){
            if (rooms.get(k).getCheckIn()==true){
              dailyincome = dailyincome + getRoomPrice(rooms.get(k).getNumber());
            }
        }*/
        total = 0;
        for(int k = 0; k<rooms.size() ; k++) {
            if (rooms.get(k).toString().startsWith("L")&&rooms.get(k).getCheckIn()==true) {
                total = total + getPrice(0) * Day.valueOf(currentDay).getRate();
                if (addbed.get(k) == true) {
                    total = total + 250;

                }
            } else if (rooms.get(k).toString().startsWith("O")&&rooms.get(k).getCheckIn()==true) {
                total = total + getPrice(1) * Day.valueOf(currentDay).getRate();
                total = total + breakfast.get(k) * 180;

            }//1
        }
        allincome.add(total);
            if(currentDay == "MONDAY"){currentDay = "TUESDAY";}
           else if(currentDay == "TUESDAY"){currentDay = "WEDNESDAY";}
           else if(currentDay == "WEDNESDAY"){currentDay = "THURSDAY";}
           else if(currentDay == "THURSDAY"){currentDay = "FRIDAY";}
           else if(currentDay == "FRIDAY"){currentDay = "SATURDAY";}
           else if(currentDay == "SATURDAY"){currentDay = "SUNDAY";}
           else if(currentDay == "SUNDAY"){currentDay = "MONDAY";}

        //2

           for(int j = 0;j<roomNumber.length;j++){
               for (int i = 0; i<rooms.size();i++){
          if (rooms.get(i).getNumber().equals(roomNumber[j])){
              rooms.get(i).setCheckIn(false);
              rooms.get(i).checkOut();
              addbed.set(i, false);
              breakfast.set(i, 0);
          }
            }
       }//3

    }

    @Override
    public double income() {
        return total;
        //return dailyincome;
    }

    @Override
    public double income(int recentTimes) {
        double a = 0;
        for(int i = 0;i<recentTimes;i++) {
            a = a + allincome.get(allincome.size() - i - 1);
        }return a;
    }
}

/*ConcreteHotel a = new ConcreteHotel();
        double i = 0 ;
        for(Day day : Day.values()){
        if(type == 0){
            LuxuryRoom b = new LuxuryRoom();
            if(b.toString()=="true"){i = (a.getPrice(type)*day.getRate()+250);}
            else if(b.toString() == "false"){i = a.getPrice(type)*day.getRate();}

        }
        if(type == 1){
            OrdinaryRoom b = new OrdinaryRoom();
            if(b.toString()=="true"){i = (a.getPrice(type)*day.getRate()+180);}
            else if(b.toString() == "false"){i = a.getPrice(type)*day.getRate();}

        }
       } return i;*/
