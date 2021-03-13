public class OrdinaryRoom extends Room{

    private int breakfastCount = 0;

    public OrdinaryRoom(){

    }

    @Override
    public void checkIn(int number) {
        breakfastCount = number;
    }

    @Override
    public void checkOut() {
        breakfastCount = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", "O", super.getNumber(),this.breakfastCount);
    }

    public String getType(){
        return "O";
    }
}
