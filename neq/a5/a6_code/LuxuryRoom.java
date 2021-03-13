import java.io.Serializable;

/**
 * Created by zym on 19/4/23
 */
public class LuxuryRoom extends Room {
    private boolean addBed;

    public LuxuryRoom() {
        this.addBed = false;
    }


    @Override
    public void checkIn(int number) {
        this.addBed = number == 3;
        super.setCheckIn(true);
    }

    @Override
    public void checkOut() {
        this.addBed = false;
        super.setCheckIn(false);
    }

    public boolean isAddBed() {
        return addBed;
    }

    @Override
    public String toString() {
        return String.format("L %s %s", super.toString(), this.addBed);
    }
}
