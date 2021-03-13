package a6_code;

/**
 * Created by zym on 19/4/23
 */
public class OrdinaryRoom extends Room {
    private int breakfastCount;

    public OrdinaryRoom(){
        breakfastCount=0;
    }

    @Override
    public void checkIn(int number) {
        this.breakfastCount=number;
        super.setCheckIn(true);
    }

    @Override
    public void checkOut() {
        this.breakfastCount=0;
        super.setCheckIn(false);
    }

    public int getBreakfastCount() {
        return breakfastCount;
    }

    @Override
    public String toString(){
        return String.format("O %s %d",super.toString(),this.breakfastCount);
    }
}
