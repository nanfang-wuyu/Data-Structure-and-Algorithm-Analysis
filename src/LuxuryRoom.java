public class LuxuryRoom extends Room {
    private boolean addBed = false;
   /* private static int count=0;
    private String number;
    private Boolean checkIn=false;*/
   /* public String getNumber(){
        return this.number;
    }*/
    public LuxuryRoom(){
        //this.number="R"+count++;
    }

    @Override
    public void checkIn(int number) {
        if(number == 2){addBed = false;}
        if(number == 3){addBed = true;}
    }

    @Override
    public void checkOut() {
        addBed = false;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s","L", super.getNumber(),this.addBed);

    }

    public String getType(){
        return "L";
    }

    public boolean getAddBed(){
        return addBed;
    }

}
