package a6_code; /**
 * Created by zym on 19/4/23
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConcreteHotel implements Hotel {

    private List<Room> rooms = new ArrayList<>();
    private double luxuryPrice = 1200;
    private double ordinaryPrice = 500;
    private double breakfastPrice = 180;
    private double addBedPrice = 250;
    private Day day = Day.MONDAY;
    private Map<Integer, Double> income = new HashMap<>();
    private int dayCount = 1;


    @Override
    public void addRoom(int type, int count) {
        while (count-- > 0) {
            rooms.add(type == 0 ? new LuxuryRoom() : new OrdinaryRoom());
        }
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);

    }

    @Override
    public void setPrice(int type, double price) {
        if (type == 0) {
            this.luxuryPrice = price;
        } else {
            this.ordinaryPrice = price;
        }
    }

    @Override
    public double getPrice(int type) {
        return type == 0 ? this.luxuryPrice : this.ordinaryPrice;
    }

    @Override
    public double getRoomPrice(String number) {
        Room room = rooms.stream().filter(
                room1 -> room1.getNumber().equals(number)).collect(
                Collectors.toList()).get(0);

        if (room.getCheckIn()) {
            if (room instanceof LuxuryRoom) {
                return (luxuryPrice * day.getRate() + (((LuxuryRoom) room).isAddBed() ? addBedPrice : 0));
            } else {
                return (ordinaryPrice * day.getRate() + ((OrdinaryRoom) room).getBreakfastCount() * breakfastPrice);
            }
        } else {
            return 0;
        }
    }


    @Override
    public void displayAllRooms() {
        rooms.forEach(System.out::println);
    }

    @Override
    public List<Room> getAllCheckedRooms() {
        return rooms.stream().filter(Room::getCheckIn).collect(Collectors.toList());
    }


    @Override
    public void displayEveryDayInfo() {
        Arrays.asList(Day.values()).forEach(System.out::println);
    }

    @Override
    public void displayTodayInfo() {
        System.out.println(day);
    }


    @Override
    public void checkIn(int type, int number) {
        Room checkRoom = rooms.stream().filter(
                room -> type == 0 ? room instanceof LuxuryRoom : room instanceof OrdinaryRoom
        ).filter(room -> !room.getCheckIn()
        ).collect(Collectors.toList()).get(0);

        checkRoom.checkIn(number);
    }


    @Override
    public void checkOut(String... roomNumber) {

        // calculate the income for all rooms that is checked
        double price = 0;
        for (Room room : rooms) {
            if (room.getCheckIn()) {
                if (room instanceof LuxuryRoom) {
                    price += luxuryPrice * day.getRate();
                    price += ((LuxuryRoom) room).isAddBed() ? addBedPrice : 0;
                } else {

                    price += ordinaryPrice * day.getRate();
                    price += ((OrdinaryRoom) room).getBreakfastCount() * breakfastPrice;
                }
            }
        }
        income.put(dayCount, price);

        // change today to tomorrow, and the dayCount should be increased
        day = Day.values()[(++dayCount - 1) % 7];
        // change checkIn status of room to false
        List<String> checkOutRooms = Arrays.asList(roomNumber);
        rooms.stream().filter(room ->
                checkOutRooms.contains(room.getNumber())).forEach(Room::checkOut);
    }

    @Override
    public double income() {
        return income.get(dayCount - 1);
    }

    @Override
    public double income(int recentTimes) {
        int price = 0;

        for (int i = 0; i < recentTimes; i++) {
            try {
                price += income.get(dayCount - i - 1);
            } catch (NullPointerException e) {
                System.out.println(income.size());
                System.out.println("day count = " + dayCount);
                e.printStackTrace();
            }
        }

        return price;
    }

}